package ru.kpfu.itis.timm.facerecogniser.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.timm.facerecogniser.config.CloudinaryConfig;
import ru.kpfu.itis.timm.facerecogniser.dto.Face;
import ru.kpfu.itis.timm.facerecogniser.dto.ZofaceResponse;
import ru.kpfu.itis.timm.facerecogniser.model.Image;
import ru.kpfu.itis.timm.facerecogniser.proxy.ZofaceProxy;
import ru.kpfu.itis.timm.facerecogniser.repo.ImageRepository;
import ru.kpfu.itis.timm.facerecogniser.service.api.ImageService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ZofaceProxy zofaceProxy;
    private final ImageRepository imageRepository;
    private final CloudinaryConfig cloudinaryConfig;

    @Value("${zuface.url}")
    private String zufaceUrl;

    @Override
    @Transactional
    public ZofaceResponse recognise(MultipartFile image) throws IOException {
        File file = convert(image);
        Image imageModel = upload(file);
        imageRepository.save(imageModel);
        ZofaceResponse zofaceResponse = zofaceProxy.recognise(URI.create(zufaceUrl), file, "1");
        zofaceResponse.setUrl(imageModel.getUrl());
        if (zofaceResponse.getFaces() != null) {
            for (Face face : zofaceResponse.getFaces()) {
                BufferedImage faceImage = cropImage(ImageIO.read(file), face);
                ImageIO.write(faceImage, "jpg", file);
                Image faceImageModel = upload(file);
                faceImageModel.setParrent(imageModel);
                imageRepository.save(faceImageModel);

                face.setUrl(faceImageModel.getUrl());
            }
        }
        return zofaceResponse;
    }

    private Image upload(File file) throws IOException {
        Map resp = cloudinaryConfig.cloudinary().uploader().upload(file, null);
        return Image.builder()
                .recognised(false)
                .url(resp.get("url").toString())
                .build();
    }

    private BufferedImage cropImage(BufferedImage src, Face face) {
        BufferedImage dest = src.getSubimage(face.getX(), face.getY(), face.getW(), face.getH());
        return dest;
    }

    private File convert(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convFile;
    }
}

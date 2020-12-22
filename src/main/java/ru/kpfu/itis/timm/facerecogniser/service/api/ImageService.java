package ru.kpfu.itis.timm.facerecogniser.service.api;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.timm.facerecogniser.dto.ZofaceResponse;

import java.io.IOException;

public interface ImageService {
    ZofaceResponse recognise(MultipartFile image) throws IOException;
}

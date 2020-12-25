package ru.kpfu.itis.timm.facerecogniser.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.timm.facerecogniser.service.api.ImageService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping(value = "/image")
    public ResponseEntity recognise(HttpServletRequest request, @RequestParam(name = "extension") String extension) throws IOException {
        File file = File.createTempFile(UUID.randomUUID().toString(),  "." +  extension);
        Files.copy(request.getInputStream(), file.toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.ok(imageService.recognise(file));
    }
}

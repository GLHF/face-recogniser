package ru.kpfu.itis.timm.facerecogniser.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.timm.facerecogniser.service.api.ImageService;

import java.io.IOException;

@Controller
@RequestMapping("/image")
@Slf4j
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/recognise")
    public ResponseEntity recognise(@RequestParam("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok(imageService.recognise(image));
    }
}

package ru.kpfu.itis.timm.facerecogniser.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/image")
@Slf4j
@RequiredArgsConstructor
public class ImageController {

    @PostMapping("/recognise")
    public ResponseEntity recognise() throws IOException {
        return ResponseEntity.ok("Hello");
    }
}

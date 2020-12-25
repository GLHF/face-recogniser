package ru.kpfu.itis.timm.facerecogniser.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Arrays;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ImageController {

    @PostMapping("/image")
    public ResponseEntity recognise() throws Exception{
        return ResponseEntity.ok(new ObjectMapper().writeValueAsString(Arrays.asList("Идите", "В", "ЖОПУ")));
    }
}

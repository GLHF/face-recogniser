package ru.kpfu.itis.timm.facerecogniser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FaceRecogniserApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FaceRecogniserApplication.class, args);
    }

}

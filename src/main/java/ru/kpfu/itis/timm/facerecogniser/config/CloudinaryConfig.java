package ru.kpfu.itis.timm.facerecogniser.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CloudinaryConfig {
    @Value("${cloudinary.url}")
    private String cloudinaryUrl;

    public Cloudinary cloudinary() {
        return new Cloudinary(cloudinaryUrl);
    }
}

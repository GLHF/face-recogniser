package ru.kpfu.itis.timm.facerecogniser.config;

import feign.RequestInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
@EnableFeignClients(basePackages = "ru.kpfu.itis.timm.facerecogniser.proxy")
public class FeignConfig {

    /**
     * Добавляет к Feign-клиенту проброс apikey для сервиса распознавания лиц
     */
    @Bean
    public RequestInterceptor apikeyInterceptor(@Value("${zuface.apikey}") String apikey) {
        return new ApikeyFeignRequestInterceptor(apikey);
    }
}
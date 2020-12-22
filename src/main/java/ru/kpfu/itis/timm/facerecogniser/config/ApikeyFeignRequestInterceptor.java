package ru.kpfu.itis.timm.facerecogniser.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.MediaType;

public class ApikeyFeignRequestInterceptor implements RequestInterceptor {
    private final String APIKEY;

    public ApikeyFeignRequestInterceptor(String apikey) {
        this.APIKEY = apikey;
    }

    @Override
    public void apply(RequestTemplate template) {
        if ("zuface".equalsIgnoreCase(template.feignTarget().name())) {
            template.header("z-api-key", APIKEY);
        }
    }
}

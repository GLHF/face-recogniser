package ru.kpfu.itis.timm.facerecogniser.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.timm.facerecogniser.exception.FeignClientException;

import static feign.FeignException.errorStatus;

/**
 *  Кастомный декодер для feign для обработки ответов сервисов
 * */
@Component
@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() > 400 && response.status() <= 599) {
            FeignClientException feignClientException = new FeignClientException(
                    response.status(),
                    methodKey
            );
            log.error("Feign decoder logging {} with response \n {} \n and request {}", feignClientException.toString(), response.toString(), response.request());
            return feignClientException;
        }
        return errorStatus(methodKey, response);
    }
}
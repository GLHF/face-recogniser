package ru.kpfu.itis.timm.facerecogniser.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FeignClientException extends RuntimeException {
    private int status;
    private String request;

    public FeignClientException(int status, String request) {
        this.status = status;
        this.request = request;
    }

    public FeignClientException(String message) {
        super(message);
    }

    public FeignClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeignClientException(Throwable cause) {
        super(cause);
    }
}

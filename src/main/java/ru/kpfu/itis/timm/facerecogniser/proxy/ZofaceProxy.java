package ru.kpfu.itis.timm.facerecogniser.proxy;


import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.timm.facerecogniser.dto.Form;
import ru.kpfu.itis.timm.facerecogniser.dto.ZofaceResponse;

import java.io.File;
import java.net.URI;

@FeignClient(
        name = "zuface",
        url = "${zuface.api-base-url}",
        path = "${zuface.host}"
)
public interface ZofaceProxy {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequestLine("POST")
    ZofaceResponse recognise(URI uri,
                             @RequestPart("image_file") File image,
                             @RequestPart("image_source") String imageSource);
}

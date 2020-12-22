package ru.kpfu.itis.timm.facerecogniser.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Face {
    private Integer x;
    private Integer y;
    private Integer w;
    private Integer h;

    private String url;
}

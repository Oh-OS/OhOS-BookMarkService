package com.mirim.ohos.dto.bookmark;

import lombok.Getter;

@Getter
public class AddBookMarkRequestDto {
    private String locationName;
    private Double latitude;
    private Double longitude;
}

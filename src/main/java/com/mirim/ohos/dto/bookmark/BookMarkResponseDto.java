package com.mirim.ohos.dto.bookmark;

import com.mirim.ohos.domain.BookMark;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookMarkResponseDto {
    private final Long id;
    private final String locationName;
    private final Double latitude;
    private final Double longitude;

    @Builder
    public BookMarkResponseDto(Long id, String locationName, Double latitude, Double longitude) {
        this.id = id;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public static BookMarkResponseDto from(BookMark bookMark) {
        return BookMarkResponseDto.builder()
                .id(bookMark.getId())
                .locationName(bookMark.getLocationName())
                .latitude(bookMark.getLatitude())
                .longitude(bookMark.getLongitude())
                .build();
    }

}

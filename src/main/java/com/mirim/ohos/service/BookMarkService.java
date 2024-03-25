package com.mirim.ohos.service;

import com.mirim.ohos.domain.BookMark;
import com.mirim.ohos.dto.bookmark.AddBookMarkRequestDto;
import com.mirim.ohos.dto.bookmark.BookMarkResponseDto;
import com.mirim.ohos.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookMarkService {

    private final BookMarkRepository bookMarkRepository;

    @Transactional
    public BookMarkResponseDto saveBookMark(AddBookMarkRequestDto requestDto) {
        BookMark bookMark = BookMark.builder()
                .locationName(requestDto.getLocationName())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .build();

        BookMark savedBookMark = bookMarkRepository.save(bookMark);
        return BookMarkResponseDto.from(savedBookMark);
    }

    public List<BookMarkResponseDto> getAllBookMarks() {
        List<BookMark> bookMarks = bookMarkRepository.findAll();
        return bookMarks.stream()
                .map(BookMarkResponseDto::from)
                .collect(Collectors.toList());
    }

    public BookMarkResponseDto getBookMarkById(Long id) {
        BookMark bookMark = bookMarkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BookMark not found for id: " + id));
        return BookMarkResponseDto.from(bookMark);
    }
}
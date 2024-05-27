package com.mirim.ohos.controller;
import com.mirim.ohos.dto.bookmark.AddBookMarkRequestDto;
import com.mirim.ohos.dto.bookmark.BookMarkResponseDto;
import com.mirim.ohos.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookMarkController {

    private final BookMarkService bookMarkService;

    @PostMapping
    public ResponseEntity<BookMarkResponseDto> saveBookMark(@RequestBody AddBookMarkRequestDto requestDto) {
        BookMarkResponseDto savedBookMark = bookMarkService.saveBookMark(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBookMark);
    }

    @GetMapping
    public ResponseEntity<List<BookMarkResponseDto>> getAllBookMarks() {
        List<BookMarkResponseDto> allBookMarks = bookMarkService.getAllBookMarks();
        return ResponseEntity.ok().body(allBookMarks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookMarkResponseDto> getBookMarkById(@PathVariable Long id) {
        BookMarkResponseDto bookMark = bookMarkService.getBookMarkById(id);
        return ResponseEntity.ok().body(bookMark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookMark(@PathVariable Long id) {
        bookMarkService.deleteBookMarkById(id);
        return ResponseEntity.noContent().build();
    }
}

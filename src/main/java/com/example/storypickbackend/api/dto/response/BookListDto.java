package com.example.storypickbackend.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookListDto {

    String title;
    String isbn;
    String cover;
    String author;
    String description;
    String categoryName;
    int ratingScore;

}

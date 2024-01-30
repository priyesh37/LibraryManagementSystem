package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Enums.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddBookRequest {

    private String bookName;

    private Genre bookGenre;

    private int noOfPages;

    private int price;

    private Date publishDate;

    private Integer authorId;
}

package com.example.LibraryManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAuthorRequest {

    private String authorName;

    private int authorAge;

    private String emailId;
}


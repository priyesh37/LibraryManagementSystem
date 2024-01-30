package com.example.LibraryManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyPhnNoRequest {

    private Integer studentId;
    private String newPhnNo;
}

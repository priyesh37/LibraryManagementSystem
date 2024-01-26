package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int bookId;

        @Column(unique = true)
        private String bookName;

        @Enumerated(value = EnumType.STRING)
        private Genre bookGenre;

        private int noOfPages;

        private int price;

        private Date pulishDate;

        private Boolean isAvailable;

        @JoinColumn
        @ManyToOne
        private Author author;


        
}

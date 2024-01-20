package com.example.LibraryManagementSystem.Entities;

import com.example.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="library_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int cardId;

        private CardStatus cardStatus;

        private int noOfBooksIssued;

        //Library card should have the foreign key column
        //bcz this is the child class
        @JoinColumn
        @OneToOne
        private Student student;
}

package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.AssociateCardStudentRequest;
import com.example.LibraryManagementSystem.Entities.LibraryCard;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Repository.CardRepository;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

        @Autowired
        private CardRepository cardRepository;

        @Autowired
        private StudentRepository studentRepository;

    public String getFreshCard(){

        LibraryCard newCard = new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBooksIssued(0);

        LibraryCard savedCard = cardRepository.save(newCard);

        return "New Card with Card No "+savedCard.getCardId()+" has been generated";

    }

    public String  associateCardAndStudent(AssociateCardStudentRequest associateCardStudentRequest) throws Exception{

        Integer cardId = associateCardStudentRequest.getCardId();
        Integer studentId = associateCardStudentRequest.getStudentId();


        Optional<LibraryCard> optionalLibraryCard = cardRepository.findById(cardId);
        if(optionalLibraryCard.isEmpty()){
            throw new Exception("Invalid card id entered");

        }

        LibraryCard libraryCard = optionalLibraryCard.get();

        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()){
            throw new Exception("No student with the given Id exists in the system");

        }

        Student student = optionalStudent.get();

        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);
        libraryCard.setNoOfBooksIssued(0);

        cardRepository.save(libraryCard);

        return "Card with cardId "+cardId+" and student with studentId "+studentId+" are associated";

    }
}

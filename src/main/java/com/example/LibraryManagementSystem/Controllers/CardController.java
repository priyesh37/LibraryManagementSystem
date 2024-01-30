package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.AssociateCardStudentRequest;
import com.example.LibraryManagementSystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

        @Autowired
        private CardService cardService;
        @PostMapping("/generateCard")
        public String addCard(){

                String result = cardService.getFreshCard();
                return result;

        }

        @PutMapping("/associateCardAndStudent")
        public ResponseEntity associateCardAndStudent(@RequestBody AssociateCardStudentRequest associateCardStudentRequest){

                try {
                        String res = cardService.associateCardAndStudent(associateCardStudentRequest);
                        return new ResponseEntity(res, HttpStatus.OK);
                }
                catch (Exception e){
                        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
                }
        }
        


}

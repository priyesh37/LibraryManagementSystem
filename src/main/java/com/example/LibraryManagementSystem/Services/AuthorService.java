package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.AddAuthorRequest;
import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

        @Autowired
        private AuthorRepository authorRepository;

    @Autowired
    private JavaMailSender mailSender;

        public String addAuthor(AddAuthorRequest addAuthorRequest){

            Author authorEntity = new Author(addAuthorRequest.getAuthorName(),addAuthorRequest.getAuthorAge(),addAuthorRequest.getEmailId());

            Author newAuthor =  authorRepository.save(authorEntity);

            SimpleMailMessage message = new SimpleMailMessage();

            message.setSubject("Hi "+newAuthor.getAuthorName()+" !");

            message.setFrom("springacciojob@gmail.com");
            message.setTo(newAuthor.getEmailId());


            message.setText("You have been successfully Registered on our portal !" +
                    "Looking forward for adding more books ");

            mailSender.send(message);


            return "Author  with authorId "+newAuthor.getAuthorId()+" has been saved to DB";
        }
}

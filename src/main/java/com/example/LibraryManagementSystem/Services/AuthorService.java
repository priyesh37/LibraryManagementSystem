package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.AddAuthorRequest;
import com.example.LibraryManagementSystem.Entities.Author;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

        @Autowired
        private AuthorRepository authorRepository;

        public String addAuthor(AddAuthorRequest addAuthorRequest){

            Author authorEntity = new Author(addAuthorRequest.getAuthorName(),addAuthorRequest.getAuthorAge(),addAuthorRequest.getEmailId());

            Author newAuthor =  authorRepository.save(authorEntity);

            return "Author  with authorId "+newAuthor.getAuthorId()+" has been saved to DB";
        }
}

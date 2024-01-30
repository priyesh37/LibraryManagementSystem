package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.ModifyPhnNoRequest;
import com.example.LibraryManagementSystem.Entities.Student;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

        @Autowired
        StudentService studentService;

        @PostMapping("/addStudent")
        public ResponseEntity<String> addStudent(@RequestBody Student student){
            String res = studentService.addStudent(student);
            return new ResponseEntity<>(res, HttpStatus.CREATED);

        }

        @GetMapping("/findById")
        public ResponseEntity findStudentById(@RequestParam("studentId")Integer studentId) {

                try{
                        Student student = studentService.findStudentById(studentId);
                        return new ResponseEntity(student,HttpStatus.OK);
                }catch (Exception e){
                        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
                }
        }

        @PutMapping("/modifyPhnNo")
        public String modifyPhnNo(@RequestBody ModifyPhnNoRequest modifyPhnNoRequest){

                String result = studentService.modifyPhnNo(modifyPhnNoRequest);

                return result;

        }
}

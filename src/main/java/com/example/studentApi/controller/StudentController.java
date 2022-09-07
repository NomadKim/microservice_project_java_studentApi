package com.example.studentApi.controller;

import com.example.studentApi.request.CreateStudentRequest;
import com.example.studentApi.responce.StudentResponce;
import com.example.studentApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/")
public class StudentController  {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public StudentResponce createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/getById/{id}")
    public StudentResponce getById(@PathVariable Long id){
        return studentService.getByid(id);
    }
}

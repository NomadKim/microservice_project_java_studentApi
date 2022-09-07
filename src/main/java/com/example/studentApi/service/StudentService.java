package com.example.studentApi.service;

import com.example.studentApi.entity.Student;
import com.example.studentApi.feighnclients.FeignClients;
import com.example.studentApi.repository.StudentRepository;
import com.example.studentApi.request.CreateStudentRequest;
import com.example.studentApi.responce.AddressResponce;
import com.example.studentApi.responce.StudentResponce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CommonService commonService;

    @Autowired
    FeignClients feignClients;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentResponce getByid(Long id) {
        logger.info("inside Student id");
        Student student = studentRepository.findById(id).get();
        AddressResponce addressResponce = commonService.getAddressById(student.getAddressId());
        return new StudentResponce(student, addressResponce);
    }

    public StudentResponce createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());

        studentRepository.saveAndFlush(student);

        StudentResponce studentResponce = new StudentResponce(student, commonService.getAddressById(student.getAddressId()));

        return studentResponce;

    }


}

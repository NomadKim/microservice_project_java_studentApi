package com.example.studentApi.responce;

import com.example.studentApi.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponce {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;

    public StudentResponce(Student student, AddressResponce addressResponce){
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = addressResponce.getStreet();
        this.city = addressResponce.getCity();
    }
}

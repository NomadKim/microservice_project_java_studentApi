package com.example.studentApi.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private Long addressId;
}

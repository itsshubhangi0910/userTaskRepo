package com.example.userDemo.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long userId;
    private String name;
    private String email;
    private String city;
    private String country;
    private String password;
    private String state;
    private String zipCode;

}

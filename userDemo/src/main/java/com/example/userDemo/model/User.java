package com.example.userDemo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long userId;

    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z_]+$", message = "Name can only contain alphabetic characters and underscores")
    @Column(name = "name")
    private String name;

    @Column(name = "email",unique = true)
    private String email;

    @NotEmpty
    @Size(min = 10,max = 10,message = "password must be  max of 6 chars")
    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @NotEmpty
    @Size(min = 6,max = 6,message = "zipcode must be  max of 6 chars")
    @Column(name = "zipCode")
    private String zipCode;
}

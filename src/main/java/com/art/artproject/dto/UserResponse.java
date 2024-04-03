package com.art.artproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
public class UserResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String mail;
    private String profileImage;
    private String password;

}
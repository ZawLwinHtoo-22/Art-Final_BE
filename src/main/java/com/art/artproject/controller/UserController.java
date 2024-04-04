package com.art.artproject.controller;

import com.art.artproject.domain.OTPValidateRequest;

import com.art.artproject.dto.*;
import com.art.artproject.domain.TalentResponse;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;
import com.art.artproject.service.UserService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<TalentResponse<UserResponse>> registerUser( @RequestBody NewUserRequest request){


        UserResponse user = userService.registerUser(request);
        TalentResponse<UserResponse> response=
                new TalentResponse<>(user, "Successfully registered", HttpStatus.CREATED );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/validate")
    public ResponseEntity<UserInfo> validateUser(@RequestBody UserValidateRequest request){
        return ResponseEntity.ok(userService.validateUser(request));
    }

    @GetMapping
    public ResponseEntity<List<User>> showUser(){
        List<User> users=userService.showAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<TalentResponse<VerifyMailResponse>> verifyEmail(@RequestBody VerifyMailRequest request){
        VerifyMailResponse verifyMailResponse=userService.verifyMailToRegister(request);
        TalentResponse<VerifyMailResponse> response=
                new TalentResponse<>(verifyMailResponse,"Successfully verify by email",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/validateOTP")
    public ResponseEntity<TalentResponse<Boolean>> validateOTP(@RequestBody OTPValidateRequest request){
        boolean isValidate = userService.validateOTP(request);
        TalentResponse<Boolean> response =
                new TalentResponse<>(isValidate, "Ok", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countCards(){
        Long count=userService.countUsers();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<TalentResponse<User>> updateUser(@RequestParam Long id,@RequestBody PasswordRequest passwordRequest){
        User user=userService.updateUser(id,passwordRequest);
        TalentResponse<User> response=
                new TalentResponse<>(user,"Successfully updated",HttpStatus.OK);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }
}

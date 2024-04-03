package com.art.artproject.service;

import com.art.artproject.domain.OTPValidateRequest;
import com.art.artproject.dto.*;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    UserResponse registerUser( NewUserRequest request);

    UserInfo validateUser(UserValidateRequest request);

    List<User> showAll();

    VerifyMailResponse verifyMailToRegister(VerifyMailRequest request);

    boolean validateOTP(OTPValidateRequest request);

    Long countUsers();
    User updateUser(Long id,PasswordRequest request);

    void deleteUser (Long id);
}

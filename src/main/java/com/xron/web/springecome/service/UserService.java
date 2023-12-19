package com.xron.web.springecome.service;

import com.xron.web.springecome.dto.UserLogInDTO;
import com.xron.web.springecome.dto.UserRegisterRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface UserService {
    ResponseEntity<?> userSignUp(UserRegisterRequestDTO userRegisterRequestDTO);

    ResponseEntity<?> userSignIn(UserLogInDTO userLogInDTO);
}

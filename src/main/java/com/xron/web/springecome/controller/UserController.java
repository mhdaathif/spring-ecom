package com.xron.web.springecome.controller;

import com.xron.web.springecome.dto.UserLogInDTO;
import com.xron.web.springecome.dto.UserRegisterRequestDTO;
import com.xron.web.springecome.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        return userService.userSignUp(userRegisterRequestDTO);
    }

    @PostMapping("signin")
    public ResponseEntity<?> userSignIn(@RequestBody UserLogInDTO userLogInDTO){
        return userService.userSignIn(userLogInDTO);
    }

}

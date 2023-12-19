package com.xron.web.springecome.dto;

import com.xron.web.springecome.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
}
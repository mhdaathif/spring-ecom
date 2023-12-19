package com.xron.web.springecome.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLogInDTO  {
    String email;
    String password;
}
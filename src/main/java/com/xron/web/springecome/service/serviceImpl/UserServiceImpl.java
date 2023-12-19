package com.xron.web.springecome.service.serviceImpl;

import com.xron.web.springecome.dto.UserLogInDTO;
import com.xron.web.springecome.dto.UserRegisterRequestDTO;
import com.xron.web.springecome.model.User;
import com.xron.web.springecome.model.UserType;
import com.xron.web.springecome.repository.UserRepository;
import com.xron.web.springecome.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> userSignUp(UserRegisterRequestDTO userRegisterRequestDTO) {
        if (userRegisterRequestDTO.getFirstName().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("First Name not Found");
        } else if (userRegisterRequestDTO.getLastName().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Last Name not Found");
        } else if (userRegisterRequestDTO.getEmail().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not Found");
//        } else if (!Pattern.compile("^[a-zA-Z0-9_!#$%&'+/=?^`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-][a-zA-Z0-9])?\\.[a-zA-Z0-9](?:[a-zA-Z0-9-][a-zA-Z0-9])$").matcher(userRegisterRequestDTO.getEmail().toLowerCase()).matches()) {
////            System.out.println(userRegisterRequestDTO.getEmail());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Email Address");
        } else if (userRegisterRequestDTO.getMobile().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mobile not Found");
        } else if (!Pattern.compile("^07[01245678][0-9]{7}$").matcher(userRegisterRequestDTO.getMobile()).matches()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Mobile");
        } else if (userRegisterRequestDTO.getPassword().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password not Found");
//        }
//        else if (!Pattern.compile("").matcher(userRegisterRequestDTO.getPassword()).matches()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Email");
        } else if (userRepository.findByEmail(userRegisterRequestDTO.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email Already Exist");
        } else if (userRepository.findByMobile(userRegisterRequestDTO.getMobile()).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mobile Already Exist");
        } else {
            User user = new User();
            user.setFirstName(userRegisterRequestDTO.getFirstName());
            user.setLastName(userRegisterRequestDTO.getLastName());
            user.setMobile(userRegisterRequestDTO.getMobile());
            user.setEmail(userRegisterRequestDTO.getEmail());
            user.setPassword(userRegisterRequestDTO.getPassword());

            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("User Register Successfully!");
        }
    }

    @Override
    public ResponseEntity<?> userSignIn(UserLogInDTO userLogInDTO) {
        if (userLogInDTO.getEmail().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not Found");
        } else if (userLogInDTO.getPassword().equals("")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password not Found");
        } else if (userRepository.findByEmailAndPassword(userLogInDTO.getEmail(), userLogInDTO.getPassword()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid User");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("User Logged Successfully!");
        }
    }
}

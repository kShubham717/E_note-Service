package com.example.E_Note.Controller;

import com.example.E_Note.DTO.UserDto;
import com.example.E_Note.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {
    @Autowired
    UserService userService;

@PostMapping("/")
    public ResponseEntity<?> registeruser(@RequestBody UserDto userDto){
    Boolean register =userService.register(userDto);
    if(register){
        return new ResponseEntity<>("success registered", HttpStatus.CREATED);
    }
    return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
}
}

package com.example.E_Note.Utils;

import com.example.E_Note.DTO.CategoryDto;
import com.example.E_Note.DTO.UserDto;
import com.example.E_Note.Entity.Role;
import com.example.E_Note.Exception.ValidationException;
import com.example.E_Note.Repository.RoleRepo;
import com.example.E_Note.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class Validation {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    public CategoryDto validationCheck(CategoryDto categoryDto) {
        Map<String, Object> error = new LinkedHashMap<>();
        if (ObjectUtils.isEmpty(categoryDto)) {
            throw new IllegalArgumentException("Category obj should not be null");
        } else {
            //Validation of name
            if (ObjectUtils.isEmpty(categoryDto.getName())) {
                error.put("name", "name mudst be note null");
            } else {
                if (categoryDto.getName().length() > 100) {
                    error.put("name", "lenth less than 100");
                } else {
                    if (categoryDto.getName().length() < 10) {
                        error.put("name", "lenth grter than 10");
                    }
                }
            }

        }


        if (ObjectUtils.isEmpty(categoryDto.getDescription())) {
            error.put("description", "description null");
        }
        if (!error.isEmpty()){
            throw new ValidationException(error);
        }
        return categoryDto;
    }

    public  void UserValidation(UserDto userDto){
        if(!StringUtils.hasText(userDto.getFirstName())){
            throw new IllegalArgumentException("first name is invalid");
        }

        if(!StringUtils.hasText(userDto.getLastname())){
            throw new IllegalArgumentException("last name is invalid");
        }
        if(!StringUtils.hasText(userDto.getEmails())||!userDto.getEmails().matches(Constand.Emailregex)){
            throw new IllegalArgumentException("Emails  is invalid");
        }

        if(!StringUtils.hasText(userDto.getEmails())||!userDto.getEmails().matches(Constand.Mobregix)){
            throw new IllegalArgumentException("Mobile  is invalid");
        }
        if(CollectionUtils.isEmpty(userDto.getRoles())){
            throw new IllegalArgumentException("role is invalid");
        }else{
        List<Integer> roleids= roleRepo.findAll().stream().map(e->e.getId()).toList();
       List<Integer> invalidroleid= userDto.getRoles().stream().map(e->e.getId()).filter(roleid->roleids.contains(roleid)).toList();

        if(!CollectionUtils.isEmpty(invalidroleid)){
            throw new IllegalArgumentException("role is invalid"+ invalidroleid);
        }
        }
    }


}
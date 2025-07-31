package com.example.E_Note.Utils;

import com.example.E_Note.DTO.CategoryDto;
import com.example.E_Note.Exception.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Validation {

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
}
package com.example.E_Note.Serviceimpl;

import com.example.E_Note.DTO.UserDto;
import com.example.E_Note.Entity.User;
import com.example.E_Note.Repository.UserRepo;
import com.example.E_Note.Service.UserService;
import com.example.E_Note.Utils.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
@Service
public class UserServiceImple implements UserService {

    @Autowired
    ModelMapper mapper;
    @Autowired
    UserRepo userRepo;
    @Autowired
    Validation validation;

    @Override
    public boolean register(UserDto userDto) {
        validation.UserValidation(userDto);
        User user = mapper.map(userDto, User.class);
        User saveUser = userRepo.save(user);
        if (!ObjectUtils.isEmpty(saveUser)) {
            return true;
        }
        return false;
    }
}

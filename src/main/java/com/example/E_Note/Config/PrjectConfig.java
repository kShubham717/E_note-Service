package com.example.E_Note.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrjectConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}

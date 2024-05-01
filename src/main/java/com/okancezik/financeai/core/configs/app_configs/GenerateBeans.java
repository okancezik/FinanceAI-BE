package com.okancezik.financeai.core.configs.app_configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerateBeans {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}

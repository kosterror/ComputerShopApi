package ru.kosterror.computershopapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComputerShopApiApplication {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ComputerShopApiApplication.class, args);
    }

}

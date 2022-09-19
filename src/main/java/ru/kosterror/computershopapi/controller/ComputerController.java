package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kosterror.computershopapi.model.ComputerEntity;
import ru.kosterror.computershopapi.service.ComputerService;

@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;


    @PostMapping()
    public ComputerEntity create(@RequestBody ComputerEntity computer){
        return computerService.create(computer);
    }

}

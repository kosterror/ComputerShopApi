package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.ComputerDto;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;


    @PostMapping()
    public ComputerDto create(@RequestBody CreateComputerDto computer) {
        return computerService.create(computer);
    }

    @GetMapping("/{id}")
    public ComputerDto getById(@PathVariable Long id) {
        return computerService.getById(id);
    }

    @GetMapping
    public List<ComputerDto> getAll() {
        return computerService.getAll();
    }

    @PutMapping
    public ComputerDto update(@RequestBody ComputerDto computerDto){
        return computerService.update(computerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        computerService.deleteById(id);
    }

}

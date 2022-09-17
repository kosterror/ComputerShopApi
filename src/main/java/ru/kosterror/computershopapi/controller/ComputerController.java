package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateComputerDto;
import ru.kosterror.computershopapi.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/computer")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @PostMapping
    public GetUpdateComputerDto createComputer(@RequestBody CreateComputerDto createComputerDto){
        return computerService.createComputer(createComputerDto);
    }

    @GetMapping("/{id}")
    public GetUpdateComputerDto getComputerById(@PathVariable Long id){
        return computerService.getComputerById(id);
    }

    @GetMapping
    public List<GetUpdateComputerDto> getAllComputers(){
        return computerService.GetAllComputers();
    }

    @PutMapping("/update")
    public GetUpdateComputerDto update(@RequestBody GetUpdateComputerDto updatedComputer) {
        return computerService.update(updatedComputer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        computerService.deleteById(id);
    }
}

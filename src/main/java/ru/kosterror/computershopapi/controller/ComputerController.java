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

    private final ComputerService productService;

    @PostMapping
    public GetUpdateComputerDto createComputer(@RequestBody CreateComputerDto createComputerDto){
        return productService.createComputer(createComputerDto);
    }

    @GetMapping("/{id}")
    public GetUpdateComputerDto getComputerById(@PathVariable Long id){
        return productService.getComputerById(id);
    }

    @GetMapping
    public List<GetUpdateComputerDto> getAllComputers(){
        return productService.GetAllComputers();
    }
}

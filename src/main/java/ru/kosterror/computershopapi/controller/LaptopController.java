package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateLaptopDto;
import ru.kosterror.computershopapi.service.LaptopService;

import java.util.List;

@RestController
@RequestMapping("laptop/")
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopService laptopService;

    @PostMapping
    public GetUpdateLaptopDto create(@RequestBody CreateLaptopDto createLaptopDto) {
        return laptopService.create(createLaptopDto);
    }

    @GetMapping("/{id}")
    public GetUpdateLaptopDto getById(@PathVariable Long id) {
        return laptopService.getById(id);
    }

    @GetMapping
    public List<GetUpdateLaptopDto> getAll(){
        return laptopService.getAll();
    }

    @PutMapping("/update")
    public GetUpdateLaptopDto update(@RequestBody GetUpdateLaptopDto updatedLaptop){
        return laptopService.update(updatedLaptop);
    }

}

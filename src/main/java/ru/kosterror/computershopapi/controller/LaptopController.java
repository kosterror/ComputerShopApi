package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.LaptopDto;
import ru.kosterror.computershopapi.service.LaptopService;

import java.util.List;

@RestController
@RequestMapping("/laptop")
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopService laptopService;


    @PostMapping()
    public LaptopDto create(@RequestBody CreateLaptopDto laptop) {
        return laptopService.create(laptop);
    }

    @GetMapping("/{id}")
    public LaptopDto getById(@PathVariable Long id) {
        return laptopService.getById(id);
    }

    @GetMapping
    public List<LaptopDto> getAll() {
        return laptopService.getAll();
    }

    @PutMapping
    public LaptopDto update(@RequestBody LaptopDto laptopDto) {
        return laptopService.update(laptopDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        laptopService.deleteById(id);
    }

}

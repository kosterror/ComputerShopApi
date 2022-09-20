package ru.kosterror.computershopapi.controller;

import io.swagger.v3.oas.annotations.Operation;
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


    @PostMapping
    @Operation(summary = "Добавление товара")
    public LaptopDto create(@RequestBody CreateLaptopDto laptop) {
        return laptopService.create(laptop);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение товара")
    public LaptopDto getById(@PathVariable Long id) {
        return laptopService.getById(id);
    }

    @GetMapping
    @Operation(summary = "Получить все товары")
    public List<LaptopDto> getAll() {
        return laptopService.getAll();
    }

    @PutMapping
    @Operation(summary = "Изменить данные товара")
    public LaptopDto update(@RequestBody LaptopDto laptopDto) {
        return laptopService.update(laptopDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить товар")
    public void delete(@PathVariable Long id) {
        laptopService.deleteById(id);
    }

}

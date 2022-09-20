package ru.kosterror.computershopapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.ComputerDto;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.service.ComputerService;

import java.util.List;

@RestController
@RequestMapping("/computer")
@OpenAPI30
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;


    @PostMapping()
    @Operation(summary = "Добавление товара")
    public ComputerDto create(@RequestBody CreateComputerDto computer) {
        return computerService.create(computer);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение товара")
    public ComputerDto getById(@PathVariable Long id) {
        return computerService.getById(id);
    }

    @GetMapping
    @Operation(summary = "Получить все товары")
    public List<ComputerDto> getAll() {
        return computerService.getAll();
    }

    @PutMapping
    @Operation(summary = "Изменить данные товара")
    public ComputerDto update(@RequestBody ComputerDto computerDto) {
        return computerService.update(computerDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить товар")
    public void delete(@PathVariable Long id) {
        computerService.deleteById(id);
    }
}

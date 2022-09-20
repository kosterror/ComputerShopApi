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
    @Operation(description = "Добавление товара категории \"компьютер\" в базу данных")
    public ComputerDto create(@RequestBody CreateComputerDto computer) {
        return computerService.create(computer);
    }

    @GetMapping("/{id}")
    @Operation(description = "Получение товара категории \"компьютер\" по ID")
    public ComputerDto getById(@PathVariable Long id) {
        return computerService.getById(id);
    }

    @GetMapping
    @Operation(description = "Получить все товары категории \"компьютер\"")
    public List<ComputerDto> getAll() {
        return computerService.getAll();
    }

    @PutMapping
    @Operation(description = "Изменить данные товара категории \"компьютер\"")
    public ComputerDto update(@RequestBody ComputerDto computerDto) {
        return computerService.update(computerDto);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Удалить товар категории \"компьютер\" по ID")
    public void delete(@PathVariable Long id) {
        computerService.deleteById(id);
    }
}

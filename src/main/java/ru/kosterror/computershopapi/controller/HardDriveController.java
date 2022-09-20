package ru.kosterror.computershopapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.HardDriveDto;
import ru.kosterror.computershopapi.service.HardDriveService;

import java.util.List;

@RestController
@RequestMapping("/hard_drive")
@OpenAPI30
@RequiredArgsConstructor
public class HardDriveController {

    private final HardDriveService hardDriveService;

    @PostMapping
    @Operation(summary = "Добавление товара")
    public HardDriveDto create(@RequestBody CreateHardDriveDto dto) {
        return hardDriveService.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение товара")
    public HardDriveDto getById(@PathVariable Long id) {
        return hardDriveService.getById(id);
    }

    @GetMapping
    @Operation(summary = "Получить все товары")
    public List<HardDriveDto> getAll() {
        return hardDriveService.getAll();
    }

    @PutMapping
    @Operation(summary = "Изменить данные товара")
    public HardDriveDto update(@RequestBody HardDriveDto dto) {
        return hardDriveService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить товар")
    public void deleteById(@PathVariable Long id) {
        hardDriveService.delete(id);
    }

}

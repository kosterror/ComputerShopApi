package ru.kosterror.computershopapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateMonitorDto;
import ru.kosterror.computershopapi.model.dto.MonitorDto;
import ru.kosterror.computershopapi.service.MonitorService;

import java.util.List;

@RestController
@RequestMapping("/monitor")
@RequiredArgsConstructor
public class MonitorController {

    private final MonitorService monitorService;

    @PostMapping
    @Operation(summary = "Добавление товара")
    public MonitorDto create(@RequestBody CreateMonitorDto monitorDto){
        return monitorService.create(monitorDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение товара")
    public MonitorDto getById(@PathVariable Long id){
        return monitorService.getById(id);
    }

    @GetMapping
    @Operation(summary = "Получить все товары")
    public List<MonitorDto> getAll(){
        return monitorService.getAll();
    }

    @PutMapping
    @Operation(summary = "Изменить данные товара")
    public MonitorDto update(@RequestBody MonitorDto dto){
        return monitorService.update(dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить товар")
    public void delete(@PathVariable Long id){
        monitorService.deleteById(id);
    }

}

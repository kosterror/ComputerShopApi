package ru.kosterror.computershopapi.controller;

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
    public MonitorDto create(@RequestBody CreateMonitorDto monitorDto){
        return monitorService.create(monitorDto);
    }

    @GetMapping("/{id}")
    public MonitorDto getById(@PathVariable Long id){
        return monitorService.getById(id);
    }

    @GetMapping
    public List<MonitorDto> getAll(){
        return monitorService.getAll();
    }

    @PutMapping
    public MonitorDto update(@RequestBody MonitorDto dto){
        return monitorService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        monitorService.deleteById(id);
    }

}

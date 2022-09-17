package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateMonitorDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateMonitorDto;
import ru.kosterror.computershopapi.service.MonitorService;

import java.util.List;

@RestController
@RequestMapping("/monitor")
@RequiredArgsConstructor
public class MonitorController {

    private final MonitorService monitorService;

    @PostMapping
    public GetUpdateMonitorDto createMonitor(@RequestBody CreateMonitorDto createMonitorDto){
        return monitorService.create(createMonitorDto);
    }

    @GetMapping("/{id}")
    public GetUpdateMonitorDto getById(@PathVariable Long id){
        return monitorService.getById(id);
    }

    @GetMapping
    public List<GetUpdateMonitorDto> getAll(){
        return monitorService.getAll();
    }

    @PutMapping("/update")
    public GetUpdateMonitorDto update(@RequestBody GetUpdateMonitorDto updatedMonitor){
        return monitorService.update(updatedMonitor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        monitorService.deleteById(id);
    }
}

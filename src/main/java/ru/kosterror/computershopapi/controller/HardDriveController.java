package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.HardDriveDto;
import ru.kosterror.computershopapi.service.HardDriveService;

import java.util.List;

@RestController
@RequestMapping("/hard_drive")
@RequiredArgsConstructor
public class HardDriveController {

    private final HardDriveService hardDriveService;

    @PostMapping
    public HardDriveDto create(@RequestBody CreateHardDriveDto dto) {
        return hardDriveService.create(dto);
    }

    @GetMapping("/{id}")
    public HardDriveDto getById(@PathVariable Long id) {
        return hardDriveService.getById(id);
    }

    @GetMapping
    public List<HardDriveDto> getAll() {
        return hardDriveService.getAll();
    }

    @PutMapping
    public HardDriveDto update(@RequestBody HardDriveDto dto) {
        return hardDriveService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        hardDriveService.delete(id);
    }

}

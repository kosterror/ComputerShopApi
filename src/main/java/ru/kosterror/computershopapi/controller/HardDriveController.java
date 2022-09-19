package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateHardDriveDto;
import ru.kosterror.computershopapi.service.HardDriveService;

@RestController
@RequestMapping("/hard_drive")
@RequiredArgsConstructor
public class HardDriveController {

    private final HardDriveService hardDriveService;

    @PostMapping
    public GetUpdateHardDriveDto create(@RequestBody CreateHardDriveDto createHardDriveDto) {
        return hardDriveService.create(createHardDriveDto);
    }


}

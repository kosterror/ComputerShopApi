package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateHardDriveDto;
import ru.kosterror.computershopapi.model.entity.HardDriveEntity;
import ru.kosterror.computershopapi.model.repository.HardDriveRepository;

@Service
@RequiredArgsConstructor
public class HardDriveService {

    private final HardDriveRepository hardDriveRepository;

    private final ModelMapper modelMapper;

    public GetUpdateHardDriveDto create(CreateHardDriveDto createHardDriveDto) {

        HardDriveEntity entity = modelMapper.map(createHardDriveDto, HardDriveEntity.class);
        entity = hardDriveRepository.save(entity);

        return modelMapper.map(entity, GetUpdateHardDriveDto.class);

    }

}

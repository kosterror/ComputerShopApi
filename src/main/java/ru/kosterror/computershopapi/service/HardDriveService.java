package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exception.ProductNotFoundException;
import ru.kosterror.computershopapi.model.converter.HardDriveConverter;
import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.HardDriveDto;
import ru.kosterror.computershopapi.model.entity.HardDriveEntity;
import ru.kosterror.computershopapi.repository.HardDriveRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HardDriveService {

    private final HardDriveRepository hardDriveRepository;

    public HardDriveDto create(CreateHardDriveDto dto) {
        HardDriveEntity entity = HardDriveConverter.createToEntity(dto);

        return HardDriveConverter.entityToDto(hardDriveRepository.save(entity));
    }

    public HardDriveDto getById(Long id) {
        if (hardDriveRepository.existsById(id)) {
            return HardDriveConverter.entityToDto(hardDriveRepository.getHardDriveEntityById(id));
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public HardDriveDto update(HardDriveDto dto) {
        if (hardDriveRepository.existsById(dto.getId())) {
            HardDriveEntity entity = HardDriveConverter.updateEntity(dto);

            return HardDriveConverter.entityToDto(hardDriveRepository.save(entity));
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public List<HardDriveDto> getAll() {
        List<HardDriveEntity> entities = (List<HardDriveEntity>) hardDriveRepository.findAll();
        List<HardDriveDto> dtos = new ArrayList<>();

        for (HardDriveEntity entity : entities) {
            dtos.add(HardDriveConverter.entityToDto(entity));
        }

        return dtos;
    }

    public void delete(Long id) {
        if (hardDriveRepository.existsById(id)) {
            hardDriveRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("The product with this ID does not exist");
        }
    }
}

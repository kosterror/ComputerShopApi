package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exception.ProductNotFoundException;
import ru.kosterror.computershopapi.model.converter.ComputerConverter;
import ru.kosterror.computershopapi.model.dto.ComputerDto;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;
import ru.kosterror.computershopapi.repository.ComputerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerDto create(CreateComputerDto dto) {
        ComputerEntity entity = ComputerConverter.createToEntity(dto);

        entity = computerRepository.save(entity);

        return ComputerConverter.entityToDto(entity);
    }

    public ComputerDto getById(Long id) {
        if (computerRepository.existsById(id)) {
            ComputerEntity entity = computerRepository.getComputerEntityById(id);
            return ComputerConverter.entityToDto(entity);
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public ComputerDto update(ComputerDto dto) {
        if (computerRepository.existsById(dto.getId())) {
            ComputerEntity entity = ComputerConverter.updateEntity(dto);

            return ComputerConverter.entityToDto(computerRepository.save(entity));
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public List<ComputerDto> getAll() {
        List<ComputerEntity> entities = (List<ComputerEntity>) computerRepository.findAll();
        List<ComputerDto> dtos = new ArrayList<>();

        for (ComputerEntity entity : entities) {
            dtos.add(ComputerConverter.entityToDto(entity));
        }

        return dtos;
    }

    public void deleteById(Long id) {
        if (computerRepository.existsById(id)) {
            computerRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("The product with this ID does not exist");
        }
    }
}

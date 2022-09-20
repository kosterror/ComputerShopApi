package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.model.converter.ComputerConverter;
import ru.kosterror.computershopapi.model.dto.ComputerDto;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;
import ru.kosterror.computershopapi.model.entity.ProductEntity;
import ru.kosterror.computershopapi.repository.ComputerRepository;
import ru.kosterror.computershopapi.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ProductRepository productRepository;
    private final ComputerRepository computerRepository;

    public ComputerDto create(CreateComputerDto dto) {
        ComputerEntity entity = ComputerConverter.createToEntity(dto);

        entity = computerRepository.save(entity);

        return ComputerConverter.entityToDto(entity);
    }

    public ComputerDto getById(Long id) {
        ComputerEntity entity = computerRepository.findById(id).orElseThrow();
        return ComputerConverter.entityToDto(entity);
    }

    public ComputerDto update(ComputerDto dto) {
        ComputerEntity entity = computerRepository.findById(dto.getId()).orElseThrow();

        entity.setType(dto.getType());

        ProductEntity details = entity.getDetails();

        details.setSerialNumber(dto.getSerialNumber());
        details.setProducer(dto.getProducer());
        details.setCost(dto.getCost());
        details.setCountInStock(dto.getCountInStock());

        entity.setDetails(details);

        return ComputerConverter.entityToDto(computerRepository.save(entity));
    }

    public List<ComputerDto> getAll() {
        List<ComputerEntity> entities = (List<ComputerEntity>) computerRepository.findAll();
        List<ComputerDto> dtos = new ArrayList<>();

        for (ComputerEntity entity : entities) {
            dtos.add(ComputerConverter.entityToDto(entity));
        }

        return dtos;
    }

    public void deleteById(Long id){
        computerRepository.deleteById(id);
    }
}

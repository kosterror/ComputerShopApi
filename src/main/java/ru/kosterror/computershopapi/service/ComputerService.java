package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exceptions.ProductNotFoundException;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateComputerDto;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;
import ru.kosterror.computershopapi.model.repository.ComputerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;

    public GetUpdateComputerDto createComputer(CreateComputerDto computerCreateDto) {

        ComputerEntity computerEntity = modelMapper.map(computerCreateDto, ComputerEntity.class);
        computerEntity = computerRepository.save(computerEntity);

        return modelMapper.map(computerEntity, GetUpdateComputerDto.class);
    }

    public GetUpdateComputerDto getComputerById(Long id) {
        ComputerEntity computerEntity = computerRepository.getComputerEntityById(id);

        return modelMapper.map(computerEntity, GetUpdateComputerDto.class);
    }

    public List<GetUpdateComputerDto> GetAllComputers() {
        List<ComputerEntity> computerEntities = (List<ComputerEntity>) computerRepository.findAll();

        List<GetUpdateComputerDto> getUpdateComputersDto = new ArrayList<>();

        for (ComputerEntity computerEntity : computerEntities) {

            getUpdateComputersDto.add(modelMapper.map(computerEntity, GetUpdateComputerDto.class));
        }

        return getUpdateComputersDto;
    }

    public GetUpdateComputerDto update(GetUpdateComputerDto updatedComputer) {
        if (computerRepository.existsById(updatedComputer.getId())) {
            ComputerEntity entity = modelMapper.map(updatedComputer, ComputerEntity.class);
            entity = computerRepository.save(entity);

            return modelMapper.map(entity, GetUpdateComputerDto.class);
        } else {
            throw new ProductNotFoundException("The product with this ID was not found");
        }
    }

    public void deleteById(Long id) {
        if (computerRepository.existsById(id)) {
            computerRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("The product with this ID was not found");
        }
    }
}

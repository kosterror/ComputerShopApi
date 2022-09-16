package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
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
        ComputerEntity computerEntity = computerRepository.findById(id).orElseThrow();

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
}

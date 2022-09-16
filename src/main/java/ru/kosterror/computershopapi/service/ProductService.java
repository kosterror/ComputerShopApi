package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateComputerDto;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;
import ru.kosterror.computershopapi.repository.ComputerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ComputerRepository computerRepository;

    public GetUpdateComputerDto createComputer(CreateComputerDto computerCreateDto) {
        ComputerEntity computerEntity = new ComputerEntity(
                computerCreateDto.getProducer(),
                computerCreateDto.getPrice(),
                computerCreateDto.getCountInStock(),
                computerCreateDto.getComputerType()
        );

        computerEntity = computerRepository.save(computerEntity);

        return new GetUpdateComputerDto(
                computerEntity.getId(),
                computerEntity.getProducer(),
                computerEntity.getPrice(),
                computerEntity.getCountInStock(),
                computerEntity.getComputerType()
        );
    }

    public GetUpdateComputerDto getComputerById(Long id) {
        ComputerEntity computerEntity = computerRepository.findById(id).orElseThrow();

        return new GetUpdateComputerDto(
                computerEntity.getId(),
                computerEntity.getProducer(),
                computerEntity.getPrice(),
                computerEntity.getCountInStock(),
                computerEntity.getComputerType()
        );
    }

    public List<GetUpdateComputerDto> GetAllComputers() {
        List<ComputerEntity> computerEntities = (List<ComputerEntity>) computerRepository.findAll();

        List<GetUpdateComputerDto> getUpdateComputersDto = new ArrayList<>();

        for (ComputerEntity computerEntity : computerEntities) {
            getUpdateComputersDto.add(new GetUpdateComputerDto(
                    computerEntity.getId(),
                    computerEntity.getProducer(),
                    computerEntity.getPrice(),
                    computerEntity.getCountInStock(),
                    computerEntity.getComputerType()
            ));
        }

        return getUpdateComputersDto;
    }
}

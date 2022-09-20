package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exception.ProductNotFoundException;
import ru.kosterror.computershopapi.model.converter.LaptopConverter;
import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.LaptopDto;
import ru.kosterror.computershopapi.model.entity.LaptopEntity;
import ru.kosterror.computershopapi.repository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public LaptopDto create(CreateLaptopDto dto){
        LaptopEntity entity = LaptopConverter.createToEntity(dto);

        entity = laptopRepository.save(entity);

        return LaptopConverter.entityToDto(entity);
    }

    public LaptopDto getById(Long id){
        if (laptopRepository.existsById(id)){
            LaptopEntity entity = laptopRepository.getLaptopEntityById(id);

            return LaptopConverter.entityToDto(entity);
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public LaptopDto update(LaptopDto dto){
        if (laptopRepository.existsById(dto.getId())){
            LaptopEntity entity = LaptopConverter.updateEntity(dto);

            return LaptopConverter.entityToDto(laptopRepository.save(entity));
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public List<LaptopDto> getAll(){
        List<LaptopEntity> entities = (List<LaptopEntity>) laptopRepository.findAll();
        List<LaptopDto> dtos = new ArrayList<>();

        for (LaptopEntity entity : entities){
            dtos.add(LaptopConverter.entityToDto(entity));
        }

        return dtos;
    }

    public void deleteById(Long id){
        if (laptopRepository.existsById(id)){
            laptopRepository.deleteById(id);
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

}

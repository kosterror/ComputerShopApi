package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exceptions.ProductNotFoundException;
import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateLaptopDto;
import ru.kosterror.computershopapi.model.entity.LaptopEntity;
import ru.kosterror.computershopapi.model.repository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;

    public GetUpdateLaptopDto create(CreateLaptopDto createLaptopDto) {
        LaptopEntity laptopEntity = modelMapper.map(createLaptopDto, LaptopEntity.class);

        laptopEntity = laptopRepository.save(laptopEntity);

        return modelMapper.map(laptopEntity, GetUpdateLaptopDto.class);
    }

    public GetUpdateLaptopDto getById(Long id){
        LaptopEntity laptopEntity = laptopRepository.getLaptopEntityById(id);

        return modelMapper.map(laptopEntity, GetUpdateLaptopDto.class);
    }

    public List<GetUpdateLaptopDto> getAll(){
        List<LaptopEntity> laptopEntities = (List<LaptopEntity>) laptopRepository.findAll();

        List<GetUpdateLaptopDto> laptopDtoList = new ArrayList<>();

        for (LaptopEntity laptopEntity : laptopEntities){
            laptopDtoList.add(modelMapper.map(laptopEntity, GetUpdateLaptopDto.class));
        }

        return laptopDtoList;
    }

    public GetUpdateLaptopDto update(GetUpdateLaptopDto updatedLaptop){
        if (laptopRepository.existsById(updatedLaptop.getId())){
            LaptopEntity entity = modelMapper.map(updatedLaptop, LaptopEntity.class);
            entity = laptopRepository.save(entity);

            return modelMapper.map(entity, GetUpdateLaptopDto.class);

        } else{
            throw new ProductNotFoundException("The product with this ID was not found");
        }
    }
}

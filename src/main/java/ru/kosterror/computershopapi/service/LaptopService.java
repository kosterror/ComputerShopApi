package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateLaptopDto;
import ru.kosterror.computershopapi.model.entity.LaptopEntity;
import ru.kosterror.computershopapi.repository.LaptopRepository;

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
        LaptopEntity laptopEntity = laptopRepository.findById(id).orElseThrow();

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

}

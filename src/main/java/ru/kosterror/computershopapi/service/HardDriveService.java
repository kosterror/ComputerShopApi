package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exceptions.ProductNotFoundException;
import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateHardDriveDto;
import ru.kosterror.computershopapi.model.entity.HardDriveEntity;
import ru.kosterror.computershopapi.model.repository.HardDriveRepository;

import java.util.ArrayList;
import java.util.List;

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

    public GetUpdateHardDriveDto getById(Long id) {
        if (hardDriveRepository.existsById(id)) {
            HardDriveEntity entity = hardDriveRepository.getHardDriveEntityById(id);

            return modelMapper.map(entity, GetUpdateHardDriveDto.class);
        } else {
            throw new ProductNotFoundException("The product with this ID does not exist");
        }
    }

    public List<GetUpdateHardDriveDto> getAll(){
        List<HardDriveEntity> entities = (List<HardDriveEntity>) hardDriveRepository.findAll();

        List<GetUpdateHardDriveDto> dtoList = new ArrayList<>();

        for (HardDriveEntity entity : entities){
            dtoList.add(modelMapper.map(entity, GetUpdateHardDriveDto.class));
        }

        return dtoList;
    }

}

package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exceptions.ProductNotFoundException;
import ru.kosterror.computershopapi.model.dto.CreateMonitorDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateMonitorDto;
import ru.kosterror.computershopapi.model.entity.MonitorEntity;
import ru.kosterror.computershopapi.model.repository.MonitorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;
    private final ModelMapper modelMapper;

    public GetUpdateMonitorDto create(CreateMonitorDto createMonitorDto) {
        MonitorEntity monitorEntity = modelMapper.map(createMonitorDto, MonitorEntity.class);

        monitorEntity = monitorRepository.save(monitorEntity);

        return modelMapper.map(monitorEntity, GetUpdateMonitorDto.class);
    }

    public GetUpdateMonitorDto getById(Long id) {
        try {
            MonitorEntity monitorEntity = monitorRepository.getMonitorEntityById(id);

            return modelMapper.map(monitorEntity, GetUpdateMonitorDto.class);
        } catch (Exception e) {
            throw new ProductNotFoundException("The product with this ID was not found");
        }
    }

    public List<GetUpdateMonitorDto> getAll(){
        List<MonitorEntity> monitorEntities = monitorRepository.findAll();

        List<GetUpdateMonitorDto> monitorDtoList = new ArrayList<>();

        for (MonitorEntity monitorEntity : monitorEntities){
            monitorDtoList.add(modelMapper.map(monitorEntity, GetUpdateMonitorDto.class));
        }

        return monitorDtoList;
    }

    public GetUpdateMonitorDto update(GetUpdateMonitorDto updatedMonitor){
        if (monitorRepository.existsById(updatedMonitor.getId())){
            MonitorEntity entity = modelMapper.map(updatedMonitor, MonitorEntity.class);
            entity = monitorRepository.save(entity);

            return modelMapper.map(entity, GetUpdateMonitorDto.class);


        } else{
            throw new ProductNotFoundException("The product with this ID was not found");
        }
    }

    public void deleteById(Long id){
        try{
            monitorRepository.deleteById(id);
        } catch (Exception e){
            throw new ProductNotFoundException("The product with this ID was not found");
        }
    }



}

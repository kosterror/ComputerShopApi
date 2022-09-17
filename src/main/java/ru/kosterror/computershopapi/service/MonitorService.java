package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exceptions.ProductNotFoundException;
import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateMonitorDto;
import ru.kosterror.computershopapi.model.entity.MonitorEntity;
import ru.kosterror.computershopapi.model.repository.MonitorRepository;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;
    private final ModelMapper modelMapper;

    public GetUpdateMonitorDto create(CreateLaptopDto createLaptopDto) {
        MonitorEntity monitorEntity = modelMapper.map(createLaptopDto, MonitorEntity.class);

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



}

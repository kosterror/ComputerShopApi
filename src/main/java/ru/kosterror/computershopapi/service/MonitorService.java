package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.exception.ProductNotFoundException;
import ru.kosterror.computershopapi.model.converter.MonitorConverter;
import ru.kosterror.computershopapi.model.dto.CreateMonitorDto;
import ru.kosterror.computershopapi.model.dto.MonitorDto;
import ru.kosterror.computershopapi.model.entity.MonitorEntity;
import ru.kosterror.computershopapi.repository.MonitorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorDto create(CreateMonitorDto dto) {
        MonitorEntity entity = MonitorConverter.createToEntity(dto);

        entity = monitorRepository.save(entity);

        return MonitorConverter.entityToDto(entity);
    }

    public MonitorDto getById(Long id) {
        if (monitorRepository.existsById(id)) {
            MonitorEntity entity = monitorRepository.getMonitorEntityById(id);

            return MonitorConverter.entityToDto(entity);
        }

        throw new ProductNotFoundException("The product with this ID does not exist ");
    }

    public MonitorDto update(MonitorDto dto) {
        if (monitorRepository.existsById(dto.getId())) {
            MonitorEntity entity = MonitorConverter.updateEntity(dto);

            return MonitorConverter.entityToDto(monitorRepository.save(entity));
        }

        throw new ProductNotFoundException("The product with this ID does not exist");
    }

    public List<MonitorDto> getAll() {
        List<MonitorEntity> entities = (List<MonitorEntity>) monitorRepository.findAll();
        List<MonitorDto> dtos = new ArrayList<>();

        for (MonitorEntity entity : entities) {
            dtos.add(MonitorConverter.entityToDto(entity));
        }

        return dtos;
    }

    public void deleteById(Long id) {
        if (monitorRepository.existsById(id)) {
            monitorRepository.deleteById(id);
        } else{
            throw new ProductNotFoundException("The product with this ID does not exist");
        }
    }
}

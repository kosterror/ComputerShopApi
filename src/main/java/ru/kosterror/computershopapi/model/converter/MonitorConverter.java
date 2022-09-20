package ru.kosterror.computershopapi.model.converter;

import ru.kosterror.computershopapi.model.dto.CreateMonitorDto;
import ru.kosterror.computershopapi.model.dto.MonitorDto;
import ru.kosterror.computershopapi.model.entity.MonitorEntity;
import ru.kosterror.computershopapi.model.entity.ProductEntity;

public class MonitorConverter {

    public static MonitorEntity createToEntity(CreateMonitorDto dto) {
        MonitorEntity entity = new MonitorEntity();
        ProductEntity details = new ProductEntity();

        details.setSerialNumber(dto.getSerialNumber());
        details.setProducer(dto.getProducer());
        details.setCost(dto.getCost());
        details.setCountInStock(dto.getCountInStock());

        entity.setDetails(details);
        entity.setSize(dto.getSize());

        return entity;
    }

    public static MonitorDto entityToDto(MonitorEntity entity) {
        MonitorDto dto = new MonitorDto();

        dto.setId(entity.getId());
        dto.setSize(entity.getSize());
        dto.setSerialNumber(entity.getDetails().getSerialNumber());
        dto.setProducer(entity.getDetails().getProducer());
        dto.setCost(entity.getDetails().getCost());
        dto.setCountInStock(entity.getDetails().getCountInStock());

        return dto;
    }

    public static MonitorEntity updateEntity(MonitorDto dto) {
        ProductEntity details = new ProductEntity();

        details.setSerialNumber(dto.getSerialNumber());
        details.setProducer(dto.getProducer());
        details.setCost(dto.getCost());
        details.setCountInStock(dto.getCountInStock());

        MonitorEntity entity = new MonitorEntity();

        entity.setId(dto.getId());
        entity.setSize(dto.getSize());
        entity.setDetails(details);

        return entity;
    }

}

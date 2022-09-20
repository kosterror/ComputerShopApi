package ru.kosterror.computershopapi.model.converter;

import ru.kosterror.computershopapi.model.dto.CreateHardDriveDto;
import ru.kosterror.computershopapi.model.dto.HardDriveDto;
import ru.kosterror.computershopapi.model.entity.HardDriveEntity;
import ru.kosterror.computershopapi.model.entity.ProductEntity;

public class HardDriveConverter {

    public static HardDriveEntity createToEntity(CreateHardDriveDto dto) {
        HardDriveEntity entity = new HardDriveEntity();
        ProductEntity details = new ProductEntity();

        details.setSerialNumber(dto.getSerialNumber());
        details.setProducer(dto.getProducer());
        details.setCost(dto.getCost());
        details.setCountInStock(dto.getCountInStock());

        entity.setDetails(details);
        entity.setSize(dto.getSize());

        return entity;
    }

    public static HardDriveDto entityToDto(HardDriveEntity entity) {
        HardDriveDto dto = new HardDriveDto();

        dto.setId(entity.getId());
        dto.setSize(entity.getSize());
        dto.setSerialNumber(entity.getDetails().getSerialNumber());
        dto.setProducer(entity.getDetails().getProducer());
        dto.setCost(entity.getDetails().getCost());
        dto.setCountInStock(entity.getDetails().getCountInStock());

        return dto;
    }

    public static HardDriveEntity updateEntity(HardDriveDto dto) {
        ProductEntity details = new ProductEntity();

        details.setSerialNumber(dto.getSerialNumber());
        details.setProducer(dto.getProducer());
        details.setCost(dto.getCost());
        details.setCountInStock(dto.getCountInStock());

        HardDriveEntity entity = new HardDriveEntity();

        entity.setId(dto.getId());
        entity.setSize(dto.getSize());
        entity.setDetails(details);

        return entity;
    }
    
}

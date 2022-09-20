package ru.kosterror.computershopapi.model.converter;

import ru.kosterror.computershopapi.model.dto.CreateLaptopDto;
import ru.kosterror.computershopapi.model.dto.LaptopDto;
import ru.kosterror.computershopapi.model.entity.LaptopEntity;
import ru.kosterror.computershopapi.model.entity.ProductEntity;

public class LaptopConverter {

    public static LaptopEntity createToEntity(CreateLaptopDto dto){
        LaptopEntity laptopEntity = new LaptopEntity();
        ProductEntity details = new ProductEntity();

        details.setSerialNumber(dto.getSerialNumber());
        details.setCost(dto.getCost());
        details.setProducer(dto.getProducer());
        details.setCountInStock(dto.getCountInStock());

        laptopEntity.setDetails(details);
        laptopEntity.setType(dto.getType());

        return laptopEntity;
    }

    public static LaptopDto entityToDto(LaptopEntity entity){
        LaptopDto dto = new LaptopDto();

        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setSerialNumber(entity.getDetails().getSerialNumber());
        dto.setProducer(entity.getDetails().getProducer());
        dto.setCost(entity.getDetails().getCost());
        dto.setCountInStock(entity.getDetails().getCountInStock());

        return dto;
    }

    public static LaptopEntity updateEntity(LaptopDto dto){
        ProductEntity details = new ProductEntity();

        details.setSerialNumber(dto.getSerialNumber());
        details.setProducer(dto.getProducer());
        details.setCost(dto.getCost());
        details.setCountInStock(dto.getCountInStock());

        LaptopEntity entity = new LaptopEntity();

        entity.setId(dto.getId());
        entity.setType(dto.getType());
        entity.setDetails(details);

        return entity;
    }

}

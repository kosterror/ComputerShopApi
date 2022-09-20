package ru.kosterror.computershopapi.model.converter;

import ru.kosterror.computershopapi.model.dto.ComputerDto;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;
import ru.kosterror.computershopapi.model.entity.ProductEntity;

public class ComputerConverter {

    public static ComputerEntity createToEntity(CreateComputerDto dto) {
        ComputerEntity computerEntity = new ComputerEntity();
        ProductEntity productEntity = new ProductEntity();

        productEntity.setSerialNumber(dto.getSerialNumber());
        productEntity.setCost(dto.getCost());
        productEntity.setProducer(dto.getProducer());
        productEntity.setCountInStock(dto.getCountInStock());

        computerEntity.setDetails(productEntity);
        computerEntity.setType(dto.getType());

        return computerEntity;
    }

    public static ComputerDto entityToDto(ComputerEntity entity) {
        ComputerDto computerDto = new ComputerDto();

        computerDto.setId(entity.getId());
        computerDto.setType(entity.getType());
        computerDto.setSerialNumber(entity.getDetails().getSerialNumber());
        computerDto.setProducer(entity.getDetails().getProducer());
        computerDto.setCost(entity.getDetails().getCost());
        computerDto.setCountInStock(entity.getDetails().getCountInStock());

        return computerDto;
    }
}

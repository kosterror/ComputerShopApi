package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.kosterror.computershopapi.model.enumeration.ComputerType;

@AllArgsConstructor
@Getter
@Setter
public class CreateComputerDto {

    private String producer;

    private Long price;

    private Long countInStock;

    private ComputerType computerType;
}

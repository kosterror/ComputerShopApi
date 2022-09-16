package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kosterror.computershopapi.model.enumeration.ComputerType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUpdateComputerDto {

    private Long id;

    private String producer;

    private Long price;

    private Long countInStock;

    private ComputerType computerType;
}

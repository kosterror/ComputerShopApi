package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kosterror.computershopapi.model.enumeration.ComputerType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUpdateComputerDto {

    private Long id;

    private String producer;

    private Long price;

    private Long countInStock;

    private ComputerType computerType;
}

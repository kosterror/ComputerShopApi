package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kosterror.computershopapi.model.enumeration.ComputerType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputerDto {

    private Long id;
    private ComputerType type;
    private String serialNumber;
    private String producer;
    private int cost;
    private int countInStock;

}

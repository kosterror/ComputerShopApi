package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kosterror.computershopapi.model.enumeration.LaptopType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDto {

    private Long id;
    private LaptopType type;
    private String serialNumber;
    private String producer;
    private int cost;
    private int countInStock;
}

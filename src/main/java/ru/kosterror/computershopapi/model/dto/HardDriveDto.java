package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardDriveDto {

    private Long id;
    private int size;
    private String serialNumber;
    private String producer;
    private int cost;
    private int countInStock;

}

package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUpdateHardDriveDto {

    private Long id;

    private Long seriesNumber;

    private String producer;

    private Long price;

    private Long countInStock;

    private Long size;

}

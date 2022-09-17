package ru.kosterror.computershopapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kosterror.computershopapi.model.enumeration.LaptopType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUpdateLaptopDto {

    private Long id;

    private Long seriesNumber;

    private String producer;

    private Long price;

    private Long countInStock;

    private LaptopType laptopType;

}

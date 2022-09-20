package ru.kosterror.computershopapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kosterror.computershopapi.model.enumeration.LaptopType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class LaptopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LaptopType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id")
    private ProductEntity details;

}

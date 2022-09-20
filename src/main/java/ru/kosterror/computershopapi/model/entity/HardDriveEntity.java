package ru.kosterror.computershopapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class HardDriveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id")
    private ProductEntity details;

}

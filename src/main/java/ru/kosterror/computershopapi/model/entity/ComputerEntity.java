package ru.kosterror.computershopapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kosterror.computershopapi.model.enumeration.ComputerType;

import javax.persistence.*;

@Entity
@Table(name = "desktop_computer")
@Data
@NoArgsConstructor
public class ComputerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "count_in_stock")
    private Long countInStock;

    @Column(name = "type", nullable = false)
    private ComputerType computerType;

}


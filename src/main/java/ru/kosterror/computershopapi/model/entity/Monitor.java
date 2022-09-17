package ru.kosterror.computershopapi.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "monitor")
@Data
@NoArgsConstructor
public class Monitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "series_number", nullable = false)
    private Long seriesNumber;

    @Column(name = "producer", nullable = false)
    private String producer;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "count_in_stock", nullable = false)
    private Long countInStock;

    @Column(name = "diagonal", nullable = false)
    private Long diagonal;

}

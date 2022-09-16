package ru.kosterror.computershopapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.LaptopEntity;

import java.util.List;

public interface LaptopRepository extends CrudRepository<LaptopEntity, Long> {
    LaptopEntity getById(Long id);

    List<LaptopEntity> getAll();
}

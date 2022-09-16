package ru.kosterror.computershopapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.LaptopEntity;

public interface LaptopRepository extends CrudRepository<LaptopEntity, Long> {

}

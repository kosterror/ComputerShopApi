package ru.kosterror.computershopapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;

public interface ComputerRepository extends CrudRepository<ComputerEntity, Long> {

    ComputerEntity getComputerEntityById(Long id);


}

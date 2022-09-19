package ru.kosterror.computershopapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.ComputerEntity;

public interface ComputerRepository extends CrudRepository<ComputerEntity, Long> {
}

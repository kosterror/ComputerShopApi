package ru.kosterror.computershopapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.ComputerEntity;

import java.util.List;

public interface ComputerRepository extends CrudRepository<ComputerEntity, Long> {

    ComputerEntity getById(Long id);

    List<ComputerEntity> getAll();

}

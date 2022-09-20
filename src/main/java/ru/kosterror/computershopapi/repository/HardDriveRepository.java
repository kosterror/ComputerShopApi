package ru.kosterror.computershopapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.HardDriveEntity;

public interface HardDriveRepository extends CrudRepository<HardDriveEntity, Long> {
    HardDriveEntity getHardDriveEntityById(Long id);
}

package ru.kosterror.computershopapi.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kosterror.computershopapi.model.entity.HardDriveEntity;

public interface HardDriveRepository extends JpaRepository<HardDriveEntity, Long> {

    HardDriveEntity getHardDriveEntityById(Long id);

}

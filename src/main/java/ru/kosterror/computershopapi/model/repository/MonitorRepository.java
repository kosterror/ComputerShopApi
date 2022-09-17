package ru.kosterror.computershopapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kosterror.computershopapi.model.entity.MonitorEntity;

public interface MonitorRepository extends JpaRepository<MonitorEntity, Long> {

    MonitorEntity getMonitorEntityById(Long id);

}

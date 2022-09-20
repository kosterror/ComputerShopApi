package ru.kosterror.computershopapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.MonitorEntity;

public interface MonitorRepository extends CrudRepository<MonitorEntity, Long> {
    MonitorEntity getMonitorEntityById(Long id);
}

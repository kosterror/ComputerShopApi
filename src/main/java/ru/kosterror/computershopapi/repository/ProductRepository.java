package ru.kosterror.computershopapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kosterror.computershopapi.model.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}

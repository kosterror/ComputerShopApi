package ru.kosterror.computershopapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kosterror.computershopapi.model.ComputerEntity;
import ru.kosterror.computershopapi.repository.ComputerRepository;
import ru.kosterror.computershopapi.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ProductRepository productRepository;
    private final ComputerRepository computerRepository;

    public ComputerEntity create(ComputerEntity computer){
        return computerRepository.save(computer);
    }

}

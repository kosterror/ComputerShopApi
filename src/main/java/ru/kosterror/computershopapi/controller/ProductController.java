package ru.kosterror.computershopapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.computershopapi.model.dto.CreateComputerDto;
import ru.kosterror.computershopapi.model.dto.GetUpdateComputerDto;
import ru.kosterror.computershopapi.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create/computer")
    public GetUpdateComputerDto createComputer(@RequestBody CreateComputerDto createComputerDto){
        return productService.createComputer(createComputerDto);
    }

    @GetMapping("/computer/{id}")
    public GetUpdateComputerDto getComputerById(@PathVariable Long id){
        return productService.getComputerById(id);
    }

    @GetMapping("/computer/")
    public List<GetUpdateComputerDto> getAllComputers(){
        return productService.GetAllComputers();
    }
}

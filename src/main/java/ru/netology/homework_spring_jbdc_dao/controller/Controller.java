package ru.netology.homework_spring_jbdc_dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.homework_spring_jbdc_dao.product.Product;
import ru.netology.homework_spring_jbdc_dao.repository.Repository;

import java.util.List;

@RestController
public class Controller {
    Repository repository = new Repository();

    @GetMapping("/products/fetch-product")
    public List<Product> getProductName(@RequestParam("name") String name) {
        return repository.getProductName(name);
    }
}
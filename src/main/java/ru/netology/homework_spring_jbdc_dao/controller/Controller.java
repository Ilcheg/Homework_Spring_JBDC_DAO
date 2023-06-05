package ru.netology.homework_spring_jbdc_dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.homework_spring_jbdc_dao.product.Product;
import ru.netology.homework_spring_jbdc_dao.repository.Repository;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class Controller {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    Repository repository = new Repository();

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        return repository.getProductName(name, namedParameterJdbcTemplate);
    }
}
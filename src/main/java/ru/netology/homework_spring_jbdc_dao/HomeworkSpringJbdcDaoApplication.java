package ru.netology.homework_spring_jbdc_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.netology.homework_spring_jbdc_dao.customer.Customer;
import ru.netology.homework_spring_jbdc_dao.product.Product;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class HomeworkSpringJbdcDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkSpringJbdcDaoApplication.class, args);
    }
}
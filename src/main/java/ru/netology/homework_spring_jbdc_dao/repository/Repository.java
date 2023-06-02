package ru.netology.homework_spring_jbdc_dao.repository;

import jakarta.annotation.sql.DataSourceDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import ru.netology.homework_spring_jbdc_dao.HomeworkSpringJbdcDaoApplication;
import ru.netology.homework_spring_jbdc_dao.customer.Customer;
import ru.netology.homework_spring_jbdc_dao.product.Product;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;


@org.springframework.stereotype.Repository
public class Repository {

    private final String myScript = read("myScript.sql");
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getProductName(String name) {

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.query(myScript, sqlParameterSource, (
                (rs, rowNum) -> new Product(rs.getString("product_name"))));

    }
}
package ru.netology.homework_spring_jbdc_dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.netology.homework_spring_jbdc_dao.product.Product;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String myScript = read("myScript.sql");

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
        return namedParameterJdbcTemplate.query(myScript, sqlParameterSource, ((rs, rowNum) -> new Product(
                rs.getString("product_name"))));
    }
}
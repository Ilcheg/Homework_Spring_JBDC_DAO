package ru.netology.homework_spring_jbdc_dao;

import jakarta.persistence.JoinTable;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
public class HomeworkSpringJbdcDaoApplication {
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String myScript = read("myScript.sql");

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeworkSpringJbdcDaoApplication.class, args);

        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", "Alexey");
        List<Product> products = namedParameterJdbcTemplate.query(myScript, sqlParameterSource, (
                (rs, rowNum) -> new Product(rs.getString("product_name"))));
        products.forEach(System.out::println);
    }

    //            List<Customer> customers = namedParameterJdbcTemplate.query("select name from netology.customers where name = 'Alexey'", (
//                (rs, rowNum) -> new Customer(rs.getString("name"))));
//        customers.forEach(System.out::println);
//    }
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
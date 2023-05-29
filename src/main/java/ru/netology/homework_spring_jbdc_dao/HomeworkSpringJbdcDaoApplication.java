package ru.netology.homework_spring_jbdc_dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.netology.homework_spring_jbdc_dao.customer.Customer;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class HomeworkSpringJbdcDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkSpringJbdcDaoApplication.class, args);
    }
}

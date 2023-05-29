package ru.netology.homework_spring_jbdc_dao.customer;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

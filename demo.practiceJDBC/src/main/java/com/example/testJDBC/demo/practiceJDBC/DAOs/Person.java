package com.example.testJDBC.demo.practiceJDBC.DAOs;


public class Person {

    private int id;
    private String name;
    private int age;
    private int street;
    private String city;

    public Person(int id, String name, int age, int street, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.street = street;
        this.city = city;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

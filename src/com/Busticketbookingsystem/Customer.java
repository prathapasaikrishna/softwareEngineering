package com.Busticketbookingsystem;

public class Customer {
    private int CustomerId;
    private String name;
    private String password;
    private int age;
    private String gender;


    public Customer(int customerId,String name,String password,int age,String gender){
        super();
        this.CustomerId=customerId;
        this.name=name;
        this.password=password;
        this.age=age;
        this.gender=gender;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
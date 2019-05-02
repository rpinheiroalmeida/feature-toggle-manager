package com.toggle.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private long id;
    private double salary;

    public Employee() {}

    public Employee(long id, double salary) {
        this.id = id;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
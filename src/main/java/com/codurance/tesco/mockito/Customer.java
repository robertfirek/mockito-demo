package com.codurance.tesco.mockito;

import java.util.Objects;

public class Customer {
    private String firstName;
    private String surname;


    public Customer(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) &&
                Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname);
    }
}

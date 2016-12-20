package com.codurance.tesco.mockito;

import java.util.List;

public class CustomersRepository {
//    private List<Customer> customers = new ArrayList<>();

    public List<Customer> allCustomers() {
//        return new ArrayList<>(customers);
        return null;
    }

    public void storeCustomer(Customer customer) {
//        customers.add(customer);
        throw new RuntimeException("Cannot connect to database");

    }

    public void removeCustomer(Customer customer) {
//        customers.remove(customer);
        throw new RuntimeException("Cannot connect to database");
    }
}

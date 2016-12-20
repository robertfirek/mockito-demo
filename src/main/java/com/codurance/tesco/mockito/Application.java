package com.codurance.tesco.mockito;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> allCustomers() {
        return new ArrayList<>(customers);
    }

    public void storeCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
}

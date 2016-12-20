package com.codurance.tesco.mockito;

import java.util.List;

public class Application {
    private final CustomersRepository customersRepository;

    public Application(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }


    public List<Customer> allCustomers() {
        return customersRepository.allCustomers();
    }

    public void storeCustomer(Customer customer) {
        customersRepository.storeCustomer(customer);
    }

    public void removeCustomer(Customer customer) {
        customersRepository.removeCustomer(customer);
    }
}

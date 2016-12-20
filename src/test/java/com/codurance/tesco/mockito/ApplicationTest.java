package com.codurance.tesco.mockito;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;

public class ApplicationTest {

    @Test
    public void shouldStoreInformationAboutClient(){
        Application application = new Application();
        Customer customer = new Customer("Robert", "Firek");

        application.storeCustomer(customer);
        List<Customer> allCustomers = application.allCustomers();

        assertThat(allCustomers, containsInAnyOrder(customer));
    }

    @Test
    public void shouldRemoveCustomerFromStore(){
        Application application = new Application();
        Customer customer = new Customer("Robert", "Firek");

        application.storeCustomer(customer);
        List<Customer> allCustomers = application.allCustomers();
        application.removeCustomer(customer);
        List<Customer> allCustomersAfterRemove = application.allCustomers();

        assertThat(allCustomers, containsInAnyOrder(customer));
        assertThat(allCustomersAfterRemove, is(empty()));
    }


}
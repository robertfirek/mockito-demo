package com.codurance.tesco.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private CustomersRepository customersRepository;

    @Test
    public void shouldStoreInformationAboutClient(){
        Application application = new Application(customersRepository);
        Customer customer = new Customer("Robert", "Firek");
        when(customersRepository.allCustomers()).thenReturn(Arrays.asList(customer));

        application.storeCustomer(customer);
        List<Customer> allCustomers = application.allCustomers();

        assertThat(allCustomers, containsInAnyOrder(customer));
    }

    @Test
    public void shouldRemoveCustomerFromStore(){
        Customer customer = new Customer("Robert", "Firek");
        Application application = new Application(customersRepository);
        when(customersRepository.allCustomers())
                .thenReturn(Arrays.asList(customer))
                .thenReturn(Arrays.asList());

        application.storeCustomer(customer);
        List<Customer> allCustomers = application.allCustomers();
        application.removeCustomer(customer);
        List<Customer> allCustomersAfterRemove = application.allCustomers();

        InOrder inOrder = Mockito.inOrder(customersRepository);
        inOrder.verify(customersRepository).storeCustomer(customer);
        inOrder.verify(customersRepository).allCustomers();
        inOrder.verify(customersRepository).removeCustomer(customer);
        inOrder.verify(customersRepository).allCustomers();
        inOrder.verifyNoMoreInteractions();
        assertThat(allCustomers, containsInAnyOrder(customer));
        assertThat(allCustomersAfterRemove, is(empty()));
    }


}
package repositories;

import models.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import patterns.CustomerBuilder;

/**
 * Created on 07/10/2016.
 */
public class CustomerRepoTest {
    @Test
    public void testSave() throws Exception {
        Customer customer = bootstrap();
        Long phoneNumber = customer.getPhoneNumber();
        Long expectedPhoneNumber = 1122666002123L;

        Assert.assertEquals(expectedPhoneNumber, phoneNumber);
    }

    @Test
    public void testFetchAllCustomers() throws Exception {

    }

    @Test
    public void testFindCustomerById() throws Exception {


    }

    @Test
    public void testUpdateCustomer() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        //bootstrap();
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindCustomerByEmail() throws Exception {
        Customer customer = new CustomerBuilder("John", "Pill")
                .withEmail("john@pill.com")
                .withPhone(331122666002123L)
                .build();
        CustomerRepo.save(customer);
        customer = CustomerRepo.findCustomerByEmail("john@pill.com");
        String email = customer.getEmail();
        String expectedEmail = "john@pill.com";
        Assert.assertEquals(expectedEmail, email);
        CustomerRepo.delete(customer);

    }

    public static Customer bootstrap(){
        Customer customer = new CustomerBuilder("Tim", "Pills")
                .withEmail("tim@pill.com")
                .withPhone(1122666002123L)
                .build();
        return CustomerRepo.findCustomerById(CustomerRepo.save(customer));
    }
    public static void downstrap(Customer customer){
        CustomerRepo.delete(customer);
    }
}
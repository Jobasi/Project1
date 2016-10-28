package repositories;

import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created on 07/10/2016.
 */
public class CustomerRepo {
    public CustomerRepo() {
    }

    //Reusable Session Factory Object
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        //Create a standard registry Object!!
        final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        return new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public static long save(Customer customer){

        //Open a session
        Session session = sessionFactory.openSession();
        //Begin Transaction
        session.beginTransaction();
        //Use the session to save the customer
        long personId = (long)session.save(customer);
        //Commit the transaction
        session.getTransaction().commit();
        //Close the session
        session.close();
        return personId;

    }
    @SuppressWarnings("unchecked")
    public static List<Customer> fetchAllCustomers(){
        //Open a session
        Session session = sessionFactory.openSession();
        // Create a criteria object
        Criteria criteria = session.createCriteria(Customer.class);
        //Get a list of all Customers according to the Criteria Object
        List<Customer> customer = criteria.list();
        //Close the session
        session.close();

        return customer;
    }

    public static Customer findCustomerById(long id){
        //Open a session
        Session session = sessionFactory.openSession();
        // Retrieve the persistent object (or null if not found)
        Customer customer = session.get(Customer.class, id);
        //Close the session
        session.close();
        //Return the object
        return customer;

    }

    public static void updateCustomer(Customer customer){
        //Open a session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Use the session to save the customer
        session.update(customer);
        //Commit the transaction
        session.getTransaction().commit();
        //Close the session
        session.close();
    }

    public static void delete(Customer customer){
        //Open a session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(customer);
        //Commit the transaction
        session.getTransaction().commit();
        session.close();
    }

    public static Customer findCustomerByEmail(String email){
        Session session = sessionFactory.openSession();
        Object object = session.getNamedQuery("findCustomerByEmail")
                .setParameter("email", email)
                .uniqueResult();
        return (Customer) object;
    }
}

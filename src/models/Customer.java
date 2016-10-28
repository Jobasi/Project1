package models;

import patterns.CustomerBuilder;

import javax.persistence.*;

/**
 * Created on 07/10/2016.
 */

@NamedQueries({
        @NamedQuery(
                name = "findCustomerByEmail",
                query = "from Customer c where c.email = :email"
        )
})
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private Long phoneNumber;


    public Customer(){
        super();
    }

    public Customer(CustomerBuilder customerBuilder) {
        super();
        this.firstName = customerBuilder.getFirstName();
        this.lastName = customerBuilder.getLastName();
        this.email = customerBuilder.getEmail();
        this.phoneNumber = customerBuilder.getPhoneNumber();
    }



    public Long getPersonId() {
        return personId;
    }



    public void setPersonId(Long personId) {
        this.personId = personId;
    }



    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public Long getPhoneNumber() {
        return phoneNumber;
    }



    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", personId=" + personId +
                '}';
    }
}

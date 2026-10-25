package com.customer;

import java.util.HashSet;
import java.util.Iterator;

public class CustomerOperations {
    private HashSet<Customer> customers = new HashSet<>();

    public CustomerOperations() {
        customers.add(new Customer(101, "Rahul", "Sharma", 'M'));
        customers.add(new Customer(102, "Priya", "Reddy", 'F'));
        customers.add(new Customer(103, "Arjun", "Kumar", 'M'));
        customers.add(new Customer(104, "Sneha", "Rao", 'F'));
        customers.add(new Customer(105, "Kiran", "Patel", 'M'));
    }

    public boolean addCustomer(int id, String firstname, String lastname, char gender) {
        return customers.add(new Customer(id, firstname, lastname, gender));
    }

    public boolean updateCustomer(int customerId, String firstname, String lastname, char gender) {
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            return false;
        }
        // Remove before changing: editing an object inside a HashSet changes its hash code
        customers.remove(customer);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setGender(gender);
        customers.add(customer);
        return true;
    }

    public boolean deleteCustomer(int customerId) {
        Iterator<Customer> it = customers.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == customerId) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public Customer findCustomerById(int customerId) {
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                return c;
            }
        }
        return null;
    }

    public Customer findCustomerByFirstname(String firstname) {
        for (Customer c : customers) {
            if (c.getFirstname().equals(firstname)) {
                return c;
            }
        }
        return null;
    }
}

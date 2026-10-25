package com.customer;

public class CustomerTest {
    public static void main(String[] args) {
        CustomerOperations ops = new CustomerOperations();

        System.out.println("1. Initial customers:");
        ops.getCustomers().forEach(System.out::println);

        System.out.println("\n2. Add Ananya Verma (106): " + ops.addCustomer(106, "Ananya", "Verma", 'F'));
        System.out.println("3. Add same customer again: " + ops.addCustomer(106, "Ananya", "Verma", 'F'));

        System.out.println("\n4. Update 103: " + ops.updateCustomer(103, "Arjun", "Reddy", 'M'));
        System.out.println("5. Delete 104: " + ops.deleteCustomer(104));

        System.out.println("\n6. Find ID 102: " + ops.findCustomerById(102));
        System.out.println("7. Find first name Kiran: " + ops.findCustomerByFirstname("Kiran"));

        Customer missing = ops.findCustomerById(999);
        if (missing == null) {
            System.out.println("8. Customer with ID 999 not found.");
        } else {
            System.out.println("8. Found: " + missing);
        }

        System.out.println("\n9. Final customers:");
        for (Customer c : ops.getCustomers()) {
            System.out.println(c);
        }
    }
}

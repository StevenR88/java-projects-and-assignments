package ca.bcit.comp2522.labs.lab07;

import java.util.ArrayList;

public class Driver {

    /**
     * Helper method to create Customers and add them to an ArrayList.
     * @return ArrayList<Customer>
     */
    public static ArrayList<Customer> createCustomers() {
        Customer c1 = new Customer(
                new Customer.Address("3700 Willindon Avenue", "E3N 1C4"), 123,
                "Arron", "Ferguson", 23.5);
        Customer c2 = new Customer(
                new Customer.Address("1640 Riverside Drive", "H3E 9E0"), 342,
                "Emmet", "Brown", 1000);
        Customer c3 = new Customer(
                new Customer.Address("1630 Revello Drive", "H4C 0X0"), 7643,
                "Buffy", "Summers", 30000);
        Customer c4 = new Customer(
                new Customer.Address("31 Spooner Street", "L1E 6T0"), 964,
                "Peter", "Griffin", 45);
        Customer c5 = new Customer(
                new Customer.Address("711 Maple Street", "M6C 1C0"), 23468,
                "Jon", "Arbuckle", 32000);
        Customer c6 = new Customer(
                new Customer.Address("9764 Jeopardy Lane", "L9Z 9J4"), 6532,
                "Al", "Bundy", 5);
        Customer c7 = new Customer(
                new Customer.Address("1313 Mockingbird Lane", "G6C 0C5"), 652,
                "Herman", "Munster", 39829262);
        Customer c8 = new Customer(
                new Customer.Address("221B Baker Street", "B2G 6G7"), 775433,
                "Sherlock", "Holmes", 0);
        Customer c9 = new Customer(
                new Customer.Address("124 Conch Street", "V4V 8C8"), 43579,
                "Spongebob", "Squarepants", 876559);
        Customer c10 = new Customer(
                new Customer.Address("344 Clinton Street", "T1M 6A1"), 975430,
                "Clark", "Kent", 298429);
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);
        customerList.add(c4);
        customerList.add(c5);
        customerList.add(c6);
        customerList.add(c7);
        customerList.add(c8);
        customerList.add(c9);
        customerList.add(c10);

        return customerList;
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        ArrayList<Customer> customerList = createCustomers();
        System.out.println("1) search based a first name 'Herman'");
        SearchAction.search(customerList,
                customer -> customer.getFirstName().equals("Herman"),
                customer -> customer.printCustomer(customer));
        System.out.println();

        System.out.println("2) search on balance > $400 dollars");
        SearchAction.search(customerList,
                customer -> customer.getBalance() > 400,
                customer -> customer.printCustomer(customer));
        System.out.println();

        System.out.println("3) search on balance > $10 < $100");
        SearchAction.search(customerList,
                customer -> customer.getBalance() > 10
                            && customer.getBalance() < 100,
                customer -> customer.printCustomer(customer));
        System.out.println();

        System.out.println("4) search based on either first name or last "
                + "name contains 'et' in it");
        SearchAction.search(customerList,
                customer -> customer.getFirstName().contains("et")
                            || customer.getLastName().contains("et"),
                customer -> customer.printCustomer(customer));
        System.out.println();

        System.out.println("5) search based on if the customer is on a street"
                + " (versus avenue, drive, or lane)");
        SearchAction.search(customerList,
                customer -> customer.getAddress().getAddress()
                            .contains("Street"),
                customer -> customer.printCustomer(customer));
        System.out.println();
    }

}

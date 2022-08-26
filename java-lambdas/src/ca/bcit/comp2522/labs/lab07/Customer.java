package ca.bcit.comp2522.labs.lab07;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final int id;
    private final double balance;
    private final Address address;

    /**
     * Instantiates a new Customer.
     *
     * @param newAddress   the new address
     * @param newId        the new id
     * @param newFirstName the new first name
     * @param newLastName  the new last name
     * @param newBalance   the new balance
     */
    public Customer(final Address newAddress, final int newId,
                    final String newFirstName, final String newLastName,
                    final double newBalance) {
        firstName = newFirstName;
        lastName = newLastName;
        id = newId;
        balance = newBalance;
        address = newAddress;
    }

    @Override
    public boolean equals(final Object newO) {
        if (this == newO) {
            return true;
        }
        if (!(newO instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) newO;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }
    /**
     * toString method for Customer object.
     * @return String of Customer variables
     */
    public String toString() {
        NumberFormat currency = NumberFormat
                                .getCurrencyInstance(Locale.CANADA);
        String formattedBalance = currency.format(balance);
        return id + " "
                + firstName + " " + lastName
                + ", " + formattedBalance + ", "
                + address.address + " "
                + address.postalCode;
    }

    /**
     * Print customer.
     *
     * @param customer the customer
     */
    public void printCustomer(final Customer customer) {
        System.out.println(customer.toString());
    }
    public static class Address {
        private final String address;
        private final String postalCode;

        /**
         * Instantiates a new Address.
         * @param newAddress    the new address
         * @param newPostalCode the new postal code
         */
        public Address(final String newAddress, final String newPostalCode) {
            address = newAddress;
            postalCode = newPostalCode;
        }

        @Override
        public boolean equals(final Object newO) {
            if (this == newO) {
                return true;
            }
            if (!(newO instanceof Address)) {
                return false;
            }
            Address address1 = (Address) newO;
            return Objects.equals(postalCode, address1.postalCode)
                    && Objects.equals(address, address1.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(address, postalCode);
        }

        /**
         * Gets address.
         *
         * @return the address
         */
        public String getAddress() {
            return address;
        }

        /**
         * Gets postal code.
         *
         * @return the postal code
         */
        public String getPostalCode() {
            return postalCode;
        }
    }
}

package ca.bcit.comp2522.labs.lab07;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class SearchAction {

    /**
     * Search.
     * @param customers the customers
     * @param condition the condition
     * @param outputter the outputter
     */
    public static void search(
            final List<Customer> customers,
            final Predicate<Customer> condition,
            final Consumer<Customer> outputter
            ) {

        for (Customer customer : customers) {
            if (condition.test(customer)) {
                outputter.accept(customer);
            }
        }
    }
}

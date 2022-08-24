package ca.bcit.COMP2522.assignments.assignment01;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class RentalItem extends InventoryItem
        implements java.io.Serializable {
    private Condition currentCondition;
    private List<Rental> items;
    private long rentalItemID;
    private double rentalPrice;
    private boolean sellable;
    @Serial
    private static final long serialVersionUID = -1549313959845738050L;
    private boolean sold;

    /**
     * Constructor for RentalItem object.
     * @param newSKU as a long
     * @param newRentalItemID as a long
     */
    public RentalItem(long newSKU,  long newRentalItemID) {
        super(newSKU);
        this.items = new ArrayList<>();
        this.rentalItemID = newRentalItemID;
    }

    /**
     * Getter for currentCondition variable.
     * @return current currentCondition variable
     */
    public Condition getCurrentCondition() {
        return currentCondition;
    }

    /**
     * Getter for items variable.
     * @return current items variable
     */
    public List<Rental> getItems() {
        return items;
    }

    /**
     * Getter for rentalID variable.
     * @return current rentalID variable
     */
    public long getRentalItemID() {
        return rentalItemID;
    }

    /**
     * Getter for rentalPrice variable.
     * @return current rentalPrice
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Returns boolean indicating if RentalItem is sellable.
     * @return boolean
     */
    public boolean isSellable() {
        return sellable;
    }

    /**
     * Returns boolean indicating if RentalItem is sold.
     * @return boolean
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Setter for currentCondition variable.
     * @param newCurrentCondition as a Condition
     */
    public void setCurrentCondition(final Condition newCurrentCondition) {
        if (newCurrentCondition == null) {
            throw new NullPointerException();
        } else {
            this.currentCondition = newCurrentCondition;
        }
    }

    /**
     * Setter for items variable.
     * @param newItems as a List<Rental>
     */
    public void setItems(final List<Rental> newItems) {
        this.items = newItems;
    }

    /**
     * Setter for rentalItemID variable.
     * @param newRentalItemID as a long
     */
    public void setRentalItemID(long newRentalItemID) {
        this.rentalItemID = newRentalItemID;
    }

    /**
     * Setter for rentalPrice variable.
     * @param newRentalPrice as a double
     */
    public void setRentalPrice(double newRentalPrice) {
        this.rentalPrice = newRentalPrice;
    }

    /**
     * Setter for sellable variable.
     * @param state as a boolean
     */
    public void setSellable(boolean state) {
        this.sellable = state;
    }

    /**
     * Setter for sold variable.
     * @param newSold as a boolean
     */
    public void setSold(boolean newSold) {
        if (!newSold) {
            throw new RuntimeException();
        } else {
            this.sold = true;
        }
    }

    /**
     * Adds a rental item to Rental[].
     * @param rental as a Rental object
     */
    public void addRental(final Rental rental) {
        if (rental == null) {
            throw new NullPointerException();
        } else {
            items.add(rental);
        }
    }

    /**
     * Calculates total rental cost of all objects in Rental[] array.
     * @return totalRentalCost as a double
     */
    public double getTotalRentalCost() {
        double totalRentalCost = 0;
        for (Rental rental : items) {
            totalRentalCost = totalRentalCost + rental.getCostOfRental();
        }
        return totalRentalCost;
    }

    /**
     * toString method for RentalItem object.
     * @return String
     */
    @Override
    public String toString() {
        return "RentalItem{"
                + "currentCondition=" + currentCondition
                + ", items=" + items.toString()
                + ", rentalID=" + rentalItemID
                + ", rentalPrice=" + rentalPrice
                + ", sellable=" + sellable
                + ", sold=" + sold + '}';
    }
    /**
     * CompareTo method from Comparable Interface.
     * @param item as a RentalItem object
     * @return integer representing comparison
     */
    public int compareTo(final RentalItem item) {
        return Long.compare(rentalItemID, item.rentalItemID);
    }
}

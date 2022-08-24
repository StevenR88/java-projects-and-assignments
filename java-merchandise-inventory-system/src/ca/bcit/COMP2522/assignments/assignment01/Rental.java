package ca.bcit.COMP2522.assignments.assignment01;

import java.io.Serial;
import java.util.Date;
import java.util.Objects;

public class Rental implements java.io.Serializable {
    private String comments;
    private double costOfRental;
    private Condition conditionAfter;
    private Condition conditionBefore;
    private final Date date;
    private long rentalID;
    private final long rentalItemID;
    @Serial
    private static final long serialVersionUID = 7286861306564682416L;

    /**
     * Constructor for Rental object.
     * @param newRentalID as a long
     * @param newRentalItemID as a long
     * @param newDate as a Date
     */
    public Rental(long newRentalID, long newRentalItemID, final Date newDate) {
        this.rentalID = newRentalID;
        this.rentalItemID = newRentalItemID;
        this.date = newDate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rental)) {
            return false;
        }
        Rental rental = (Rental) o;
        return getRentalID() == rental.getRentalID()
                && getRentalItemID() == rental.getRentalItemID()
                && Objects.equals(date, rental.date);
    }

    /**
     * Getter for comments variable.
     * @return current comments variable
     */
    public String getComments() {
        return comments;
    }

    /**
     * Getter for costOfRental variable.
     * @return current comments variable
     */
    public double getCostOfRental() {
        return costOfRental;
    }

    /**
     * Getter for ConditionAfter variable.
     * @return current ConditionAfter variable
     */
    public Condition getConditionAfter() {
        return conditionAfter;
    }

    /**
     * Getter for ConditionBefore variable.
     * @return current ConditionBefore variable
     */
    public Condition getConditionBefore() {
        return conditionBefore;
    }

    /**
     * Getter for Date variable.
     * @return current Date variable
     */
    public Date getDateRented() {
        return date;
    }

    /**
     * Getter for RentalID variable.
     * @return current RentalID variable
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Getter for RentalItemID variable.
     * @return current RentalItemID variable
     */
    public long getRentalItemID() {
        return rentalItemID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, rentalID, rentalItemID);
    }

    /**
     * Setter for Comments variable.
     * @param newComments as a String
     */
    public void setComments(final String newComments) {
        if (newComments == null) {
            throw new NullPointerException();
        } else {
            this.comments = newComments;
        }
    }
    /**
     * Setter for costOfRental variable.
     * @param newCostOfRental as a double
     */
    public void setCostOfRental(final double newCostOfRental) {
        this.costOfRental = newCostOfRental;
    }

    /**
     * Setter for ConditionAfter variable.
     * @param newConditionAfter as a Condition
     */
    public void setConditionAfter(final Condition newConditionAfter) {
        if (newConditionAfter == null) {
            throw new NullPointerException();
        } else {
            this.conditionAfter = newConditionAfter;
        }
    }
    /**
     * Setter for ConditionBefore variable.
     * @param newConditionBefore as a Condition
     */
    public void setConditionBefore(final Condition newConditionBefore) {
        if (newConditionBefore == null) {
            throw new NullPointerException();
        } else {
            this.conditionBefore = newConditionBefore;
        }
    }

    /**
     * Setter for RentalID variable.
     * @param newRentalID as a long
     */
    public void setRentalID(long newRentalID) {
        this.rentalID = newRentalID;
    }

    /**
     * toString method for Rental object.
     * @return String
     */
    @Override
    public String toString() {
        return "Rental{"
                + "comments='" + comments + '\''
                + ", costOfRental=" + costOfRental
                + ", conditionAfter=" + conditionAfter
                + ", conditionBefore=" + conditionBefore
                + ", date=" + date + ", rentalID=" + rentalID
                + ", rentalItemID=" + rentalItemID + '}';
    }


}

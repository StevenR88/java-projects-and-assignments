package ca.bcit.COMP2522.assignments.assignment01;


import java.io.Serial;
import java.util.Objects;

public class SalesItem extends InventoryItem
        implements java.io.Serializable {
    private double salePrice;
    private long salesID;
    private boolean sellable;
    @Serial
    private static final long serialVersionUID = -3040231446872312819L;
    private boolean sold;

    /**
     * Constructor for SalesItem object.
     * @param sku as a long
     * @param newSalesID as a long
     */
    public SalesItem(long sku, long newSalesID) {
        super(sku);
        this.salesID = newSalesID;
    }

    /**
     * Overridden equals method.
     * @param o as an Object
     * @return boolean representing comparison
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SalesItem)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        SalesItem salesItem = (SalesItem) o;
        return Double.compare(salesItem.getSalePrice(),
                getSalePrice()) == 0 && getSalesID()
                == salesItem.getSalesID();
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Getter for salePrice variable.
     * @return current salePrice variable
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Getter for salesID variable.
     * @return current salesID variable
     */
    public long getSalesID() {
        return salesID;
    }

    /**
     * Returns boolean representing if an object is sellable.
     * @return boolean
     */
    public boolean isSellable() {
        return sellable;
    }

    /**
     * Returns boolean representing if an object is sold.
     * @return boolean
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Setter for salePrice variable.
     * @param newSalePrice as a double
     */
    public void setSalePrice(double newSalePrice) {
        this.salePrice = newSalePrice;
    }

    /**
     * Setter for salesID variable.
     * @param newSalesID as a long
     */
    public void setSalesID(long newSalesID) {
        this.salesID = newSalesID;
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
        this.sold = newSold;
    }

    /**
     * toString method for SalesItem object.
     * @return String
     */
    @Override
    public String toString() {
        return "SalesItem{"
                + "salePrice=" + salePrice
                + ", salesID=" + salesID
                + ", sellable=" + sellable
                + ", sold=" + sold
                + '}';
    }
    /**
     * Implementation of compareTo method.
     * @param item as a SalesItem
     * @return int representing comparison
     */
    public int compareTo(final SalesItem item) {
        return Long.compare(salesID, item.salesID);
    }
}

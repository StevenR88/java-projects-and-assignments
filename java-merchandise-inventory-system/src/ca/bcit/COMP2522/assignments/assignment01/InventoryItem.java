package ca.bcit.COMP2522.assignments.assignment01;

import java.io.Serial;
import java.util.Date;
import java.util.Objects;

public abstract class InventoryItem implements Comparable<InventoryItem>,
            java.io.Serializable, Sellable {

    private Date IPD;
    private long SKU;
    private String desc;
    private String name;
    private double purchasePrice;
    @Serial
    private static final long serialVersionUID = 8619750081357241957L;
    private String type;

    /**
     * Constructor for InventoryItem object.
     * @param newSKU as a long
     */
    public InventoryItem(long newSKU) {
        this.SKU = newSKU;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InventoryItem)) {
            return false;
        }
        InventoryItem that = (InventoryItem) o;
        return this.compareTo(that) == 0;
    }

    /**
     * Getter for desc variable.
     * @return current desc variable
     */
    public String getDescription() {
        return desc;
    }

    /**
     * Getter for IPD variable.
     * @return current IPD variable
     */
    public Date getIPD() {
        return IPD;
    }

    /**
     * Getter for Name variable.
     * @return current Name variable
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for purchasePrice variable.
     * @return current purchasePrice variable
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Getter for SKU variable.
     * @return current SKU variable
     */
    public long getSKU() {
        return SKU;
    }

    /**
     * Getter for type variable.
     * @return current type variable
     */
    public String getType() {
        return type;
    }

    /**
     * Overridden hashCode method.
     * @return int hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getIPD(), getSKU(), getDescription(),
                getName(), getPurchasePrice(), getType());
    }

    /**
     * Setter for description variable.
     * @param description as a String
     */
    public void setDescription(final String description) {
        if (description == null) {
            throw new NullPointerException();
        } else {
            this.desc = description;
        }
    }

    /**
     * Setter for IPD variable.
     * @param ipd as a Date
     */
    public void setIPD(final Date ipd) {
        this.IPD = ipd;
    }

    /**
     * Setter for name variable.
     * @param nameOf as a String
     */
    public void setName(final String nameOf) {
        this.name = nameOf;
    }

    /**
     * Setter for purchasePrice variable.
     * @param purchasedPrice as a double
     */
    public void setPurchasePrice(double purchasedPrice) {
        this.purchasePrice = purchasedPrice;
    }

    /**
     * Setter for SKU variable.
     * @param sku as a long
     */
    public void setSKU(long sku) {
        this.SKU = sku;
    }

    /**
     * Setter for type variable.
     * @param typeOf as a String
     */
    public void setType(final String typeOf) {
        this.type = typeOf;
    }

    @Override
    public String toString() {
        return "InventoryItem{"
                + "IPD= " + IPD
                + ", SKU= " + SKU
                + ", desc= '" + desc + '\''
                + ", name= '" + name + '\''
                + ", purchasePrice= " + purchasePrice
                + ", type= '" + type + '\''
                + '}';
    }

    /**
     * Overridden compareTo method.
     * @param item as an InventoryItem
     * @return int representing comparison
     */
    @Override
    public int compareTo(final InventoryItem item) {
        return Long.compare(SKU, item.SKU);
    }
}

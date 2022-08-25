package ca.bcit.comp2522.assignment3;

public class Price {
    private String currency;
    private String priceAmount;

    /**
     * Instantiates a new Price.
     * @param newCurrency    the new currency
     * @param newPriceAmount the new price amount
     */
    public Price(final String newCurrency, final String newPriceAmount) {
        currency = newCurrency;
        priceAmount = newPriceAmount;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param newCurrency the new currency
     */
    public void setCurrency(final String newCurrency) {
        currency = newCurrency;
    }

    /**
     * Gets price amount.
     *
     * @return the price amount
     */
    public String getPriceAmount() {
        return priceAmount;
    }

    /**
     * Sets price amount.
     *
     * @param newPriceAmount the new price amount
     */
    public void setPriceAmount(final String newPriceAmount) {
        priceAmount = newPriceAmount;
    }
}

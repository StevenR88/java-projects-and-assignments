package ca.bcit.comp2522.assignment3;

public class Stock {
    private String category;
    private String subCategory;
    private int copiesInStock;
    private String coverImage;
    private int availability;

    /**
     * Constructor for new Stock.
     *
     * @param newCategory      the new category
     * @param newSubCategory   the new sub category
     * @param newCopiesInStock the new copies in stock
     * @param newCoverImage    the new cover image
     * @param newAvailability  the new availability
     */
    public Stock(final String newCategory, final String newSubCategory,
                 final int newCopiesInStock, final String newCoverImage,
                 final int newAvailability) {
        category = newCategory;
        subCategory = newSubCategory;
        copiesInStock = newCopiesInStock;
        coverImage = newCoverImage;
        availability = newAvailability;
    }

    /**
     * Constructor for new Stock.
     *
     * @param newCategory      the new category
     * @param newCopiesInStock the new copies in stock
     * @param newCoverImage    the new cover image
     * @param newAvailability  the new availability
     */
    public Stock(final String newCategory, final int newCopiesInStock,
                 final String newCoverImage, final int newAvailability) {
        category = newCategory;
        subCategory = "";
        copiesInStock = newCopiesInStock;
        coverImage = newCoverImage;
        availability = newAvailability;
    }

    /**
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param newCategory the new category
     */
    public void setCategory(final String newCategory) {
        category = newCategory;
    }

    /**
     * Gets sub category.
     *
     * @return the sub category
     */
    public String getSubCategory() {
        return subCategory;
    }

    /**
     * Sets sub category.
     *
     * @param newSubCategory the new sub category
     */
    public void setSubCategory(final String newSubCategory) {
        subCategory = newSubCategory;
    }

    /**
     * Gets copies in stock.
     *
     * @return the copies in stock
     */
    public int getCopiesInStock() {
        return copiesInStock;
    }

    /**
     * Sets copies in stock.
     *
     * @param newCopiesInStock the new copies in stock
     */
    public void setCopiesInStock(final int newCopiesInStock) {
        copiesInStock = newCopiesInStock;
    }

    /**
     * Gets cover image.
     *
     * @return the cover image
     */
    public String getCoverImage() {
        return coverImage;
    }

    /**
     * Sets cover image.
     *
     * @param newCoverImage the new cover image
     */
    public void setCoverImage(final String newCoverImage) {
        coverImage = newCoverImage;
    }

    /**
     * Gets availability.
     *
     * @return the availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Sets availability.
     *
     * @param newAvailability the new availability
     */
    public void setAvailability(final int newAvailability) {
        availability = newAvailability;
    }
}

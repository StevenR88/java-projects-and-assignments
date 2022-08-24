package ca.bcit.COMP2522.assignments.assignment01;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.junit.Assert.*;

public class InventoryItemsTest {

    private Rental rental1;
    private Rental rental2;
    private Rental rental3;
    private Date date1;
    private String comment;
    private long rentalID;
    private long SKU;
    private long SKU2;
    private long rentalItemID;
    private long rentalItemID2;
    private double rentalCost;
    private RentalItem rentalItem1;
    private RentalItem rentalItem2;
    private SalesItem salesItem1;
    private SalesItem salesItem2;
//    @Rule
//    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        comment = "XYZ Zibblefritz Deluxe Blender";
        date1 = new Date();
        rentalID = 1;
        SKU = 42;
        SKU2 = 54;
        rentalItemID = 2;
        rentalItemID2 = 4;
        rentalCost = 49.99;
        rental1 = new Rental(rentalID, rentalItemID, date1);
        rental1.setComments(comment);
        rental1.setCostOfRental(rentalCost);
        rental1.setConditionBefore(Condition.EXCELLENT);
        rental1.setConditionAfter(Condition.UNDEFINED);

        rental2 = new Rental(rentalID, rentalItemID, date1);
        rental2.setComments("XYZ Zibblefritz Standard Blender");
        rental2.setCostOfRental(rentalCost);
        rental2.setConditionBefore(Condition.EXCELLENT);
        rental2.setConditionAfter(Condition.UNDEFINED);

        rental3 = new Rental(77, rentalItemID2, date1);
        rental3.setComments("Batmobile");
        rental3.setCostOfRental(4999.99);
        rental3.setConditionBefore(Condition.EXCELLENT);
        rental3.setConditionAfter(Condition.UNDEFINED);

        rentalItem1 = new RentalItem(SKU, rentalItemID);
        rentalItem1.setCurrentCondition(Condition.EXCELLENT);
        rentalItem1.setDescription("ABC");
        rentalItem1.setSold(true);
        rentalItem1.addRental(rental1);
        rentalItem1.addRental(rental2);
        rentalItem1.addRental(rental3);

        rentalItem2 = new RentalItem(SKU, rentalItemID);
        rentalItem2.setCurrentCondition(Condition.EXCELLENT);
        rentalItem2.setDescription("ABC");
        rentalItem2.setSold(true);
        rentalItem2.addRental(rental1);
        rentalItem2.addRental(rental2);
        rentalItem2.addRental(rental3);

        salesItem1 = new SalesItem(SKU, 99);
        salesItem1.setPurchasePrice(49.99);
        salesItem1.setDescription("ABC TV Stand");

        salesItem2 = new SalesItem(SKU, 98);
        salesItem2.setPurchasePrice(49.99);
        salesItem2.setDescription("ABC TV Stand");

    }

    @Test(expected = NullPointerException.class)
    public void salesItemSetToNull() {
        salesItem1.setDescription(null);
    }

    @Test
    public void testSalesItemEqualsFalse() {
        assertFalse(salesItem1.equals(salesItem2));
    }

    @Test
    public void testSalesToSalesHashcode() {
        assertTrue(salesItem1.hashCode() == salesItem2.hashCode());
    }

    @Test
    public void testRentalItemEquality() {
        assertEquals(new RentalItem(44, 55), new RentalItem(44, 55));
    }

    @Test
    public void testRentalItemRentalsCount() {
        assertEquals(rentalItem1.getTotalRentalCost(), (rentalCost * 2) + 4999.99, 0.0002);
    }

    @Test(expected = NullPointerException.class)
    public void rentalItemDescriptionSetToNull() {
        rentalItem1.setDescription(null);
    }

    @Test(expected = NullPointerException.class)
    public void rentalItemAddNullRental() {
        rentalItem1.addRental(null);
    }

    @Test(expected = NullPointerException.class)
    public void rentalItemConditionSetToNull() {
        rentalItem1.setCurrentCondition(null);
    }

    @Test(expected = RuntimeException.class)
    public void testRentalItemSoldMoreThanOnce() {
        rentalItem1.setSold(false);
    }

    @Test
    public void testRentalItemIsSellable() {
        assertTrue(rentalItem1.isSellable() == false);
    }

    @Test
    public void testRentalItemCondition() {
        assertTrue(rentalItem1.getCurrentCondition() == Condition.EXCELLENT);
    }

    @Test
    public void testRentalItemDesc() {
        assertTrue(rentalItem1.getDescription().equals("ABC"));
    }

    @Test
    public void testRentalRentalItemSKU() {
        assertTrue(rentalItem1.getSKU() == 42);
    }

    @Test
    public void testRentalRentalItemID() {
        System.out.println(rentalItem1.getRentalItemID());
        assertTrue(rentalItem1.getRentalItemID() == 2);
    }


    @Test(expected = NullPointerException.class)
    public void rentalConditionBeforeSetToNull() {
            rental3.setConditionBefore(null);
    }

    @Test(expected = NullPointerException.class)
    public void rentalConditionAfterSetToNull() {
        rental3.setConditionAfter(null);
    }

    @Test(expected = NullPointerException.class)
    public void rentalCommentsSetToNull()  {
        rental3.setComments(null);
    }

    @Test
    public void testRentaltoRentalEqualityEQUAL() {
        assertTrue(rental1.equals(rental2));

    }

    @Test
    public void testRentaltoRentalEqualityNOTEQUAL() {
        assertFalse(rental1.equals(rental3));

    }

    @Test
    public void testRentaltoRentalHashcode() {
        assertTrue(rental1.hashCode() == rental2.hashCode());
    }

    @Test
    public void testRentalComment() {
        assertEquals(rental1.getComments(), comment);
    }

    @Test
    public void testRentalDate() {
        assertEquals(rental1.getDateRented(), date1);
    }

    @Test
    public void testRentalID() {
        assertEquals(rental1.getRentalID(), rentalID);
    }

    @Test
    public void testRentalCost() {
        assertEquals(rental1.getCostOfRental(), rentalCost, 0.0001);
    }

    @Test
    public void testRentalsRentalItemID() {
        assertEquals(rental1.getRentalItemID(), rentalItemID);
    }


    @Test
    public void testRentalConditionBefore() {
        assertEquals(rental1.getConditionBefore(), Condition.EXCELLENT);
    }

    @Test
    public void testRentalConditionAfter() {
        assertEquals(rental1.getConditionAfter(), Condition.UNDEFINED);
    }



};

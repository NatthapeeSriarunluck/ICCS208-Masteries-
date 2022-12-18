import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonFoodProductTest {

    @Test
    void getBarcode() {
        NonFoodProduct item1 = new NonFoodProduct("123", 1.2, 0.05);
        assertEquals("123", item1.getBarcode());
    }

    @Test
    void getAfterTaxPrice() {
        double price = 1.2;
        double tax = 0.04;
        NonFoodProduct item1 = new NonFoodProduct("123", price, tax);
        assertEquals(price * (1 + tax), item1.getAfterTaxPrice(), 1e-4);
    }
}

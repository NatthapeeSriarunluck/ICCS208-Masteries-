import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {

    @Test
    void getBarcode() {
        FoodProduct item1 = new FoodProduct("123", 5.6);
        assertEquals("123", item1.getBarcode());
    }

    @Test
    void getAfterTaxPrice() {
        FoodProduct item1 = new FoodProduct("123", 5.6);
        assertEquals(5.6, item1.getAfterTaxPrice(), 1e-4);
    }
}

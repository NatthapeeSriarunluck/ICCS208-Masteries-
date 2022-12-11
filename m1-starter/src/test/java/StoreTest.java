import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void addSellable() {
        assertDoesNotThrow(() -> {
            Store s = new Store();
            s.addSellable(new FoodProduct("123", 1.0));
        });

        assertThrows(DuplicateBarcodeException.class, () -> {
            Store s = new Store();
            s.addSellable(new FoodProduct("123", 1.0));
            s.addSellable(new FoodProduct("123", 1.0));
        });
    }

    @Test
    void findSellableByBarcode() {
        Store store = new Store();
        store.addSellable(new FoodProduct("123", 1.0));
        store.addSellable(new FoodProduct("124", 2.0));


        Sellable item1 = store.findSellableByBarcode("123");
        assertEquals(1.0, item1.getAfterTaxPrice(), 1e-4);

        Sellable item2 = store.findSellableByBarcode("124");
        assertEquals(2.0, item2.getAfterTaxPrice(), 1e-4);

        assertThrows(ItemNotExistException.class, () -> {
            Store s = new Store();
            s.findSellableByBarcode("5678");
        });

    }

    @Test
    void getSize() {
        Store store = new Store();
        store.addSellable(new FoodProduct("123", 1.0));
        store.addSellable(new FoodProduct("124", 2.0));
        assertEquals(2, store.getSize());
    }

}

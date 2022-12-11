import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    /* UNCOMMENT ME TO ACTIVATE

    @Test
    void addItem() {
        Store s = createStore();
        Cart cart = new Cart(s);
        assertEquals(0, cart.getItemCount());
        cart.addItem("123");
        assertEquals(1, cart.getItemCount());
        cart.addItem("456");
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void getTotal() {
        Store s = createStore();
        Cart cart = new Cart(s);
        cart.addItem("123");
        cart.addItem("323");
        assertEquals(5*1.08 + 1, cart.getTotal(), 1e-4);
        cart.addItem("125");
        cart.addItem("125");
        assertEquals(5*1.08 + 1 + 1.6*2, cart.getTotal(), 1e-4);
        cart.addItem("326");
        cart.addItem("326");
        assertEquals(5*1.08 + 1 + 1.6*2 + 2*10*1.04, cart.getTotal(), 1e-4);
    }


    @Test
    void getUniqueItemCount() {
        Store s = createStore();
        Cart cart = new Cart(s);
        cart.addItem("123");
        cart.addItem("323");
        assertEquals(2, cart.getUniqueItemCount());
        cart.addItem("123");
        cart.addItem("323");
        assertEquals(2, cart.getUniqueItemCount());
        cart.addItem("125");
        cart.addItem("125");
        assertEquals(3, cart.getUniqueItemCount());
        cart.addItem("789");
        cart.addItem("1023");
        assertEquals(3, cart.getUniqueItemCount());
    }

    private Store createStore() {
        Store s = new Store();
        FoodProduct carrot = new FoodProduct("123", 1.0);
        FoodProduct lettuce = new FoodProduct("124", 1.5);
        FoodProduct milk = new FoodProduct("125", 1.6);
        NonFoodProduct detergent = new NonFoodProduct("323", 5, 0.08);
        NonFoodProduct spoon = new NonFoodProduct("327", 2.0, 0.08);
        NonFoodProduct recyclablePlate = new NonFoodProduct("326", 10, 0.04);
        s.addSellable(carrot);
        s.addSellable(lettuce);
        s.addSellable(milk);
        s.addSellable(detergent);
        s.addSellable(spoon);
        s.addSellable(recyclablePlate);
        return s;
    }
    */

}

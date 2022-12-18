import java.util.ArrayList;
import java.util.HashSet;

public class Cart {
    ArrayList<Sellable> cart;
    Store market;

    public Cart(Store store) {
        cart = new ArrayList<>();
        market = store;
    }

    public void addItem(String barcode) {
        try {
            Sellable p = market.findSellableByBarcode(barcode);
            cart.add(p);
        } catch (ItemNotExistException e) {
            return;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (Sellable product : cart) {
            total += product.getAfterTaxPrice();
        }
        return total;
    }

    public int getItemCount() {
        return cart.size();
    }

    public int getUniqueItemCount() {
        HashSet<Sellable> cartSet = new HashSet<>(cart);
        return cartSet.size();
    }
}




public class Cart {
    Store cart;

    public Cart(Store store) {
        cart = store;
    }

    public void addItem(String barcode) {
        Sellable p = cart.findSellableByBarcode(barcode);
        cart.addSellable(p);

    }

    public double getTotal() {
        for (int i = 0; i < cart.getSize(); i++) {
        }
        return 2;
    }

    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < cart.getSize(); i++) {

        }
        return size;
    }

    public int getUniqueItemCount() {
        int size = 0;
        for (int i = 0; i < cart.getSize(); i++) {

        }
        return 0;
    }

}

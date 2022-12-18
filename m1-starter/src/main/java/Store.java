import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Store {
    HashSet<Sellable> products = new HashSet<>();
    HashSet<String> barcodes = new HashSet<>();

    public void addSellable(Sellable a) {
        if (!barcodes.contains(a.getBarcode())) {
            products.add(a);
            barcodes.add(a.getBarcode());
        } else {
            throw new DuplicateBarcodeException("Barcode already exists");
        }
    }

    public Sellable findSellableByBarcode(String barcode) {
        for (Sellable product : products) {
            if (Objects.equals(product.getBarcode(), barcode)) {
                return product;
            }
        }
        throw new ItemNotExistException("Barcode does not exist");
    }

    public int getSize() {
        return products.size();
    }

    public static void main(String[] args) {
        Store test = new Store();
        test.addSellable(new FoodProduct("123", 1.0));
        test.addSellable(new FoodProduct("123", 1.0));
    }
}


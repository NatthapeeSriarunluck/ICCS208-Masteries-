import java.util.ArrayList;
import java.util.Objects;

public class Store {
    ArrayList<Sellable> products = new ArrayList<>();

    public void addSellable(Sellable a) {
        for (Sellable product : products) {
            if (!Objects.equals(product.getBarcode(), a.getBarcode())) {
                products.add(a);
            }
        }
        throw new DuplicateBarcodeException("Same Sellable");
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
}


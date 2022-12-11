// TODO
public class FoodProduct implements Sellable {
    String Barcode;
    double Price;
    public FoodProduct(String barcode, double price) {
        this.Barcode = barcode;
        this.Price = price;
    }

    @Override
    public String getBarcode() {
        return this.Barcode;
    }

    @Override
    public double getAfterTaxPrice() {
        return this.Price;
    }
}


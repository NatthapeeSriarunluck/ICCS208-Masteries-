// TODO
public class NonFoodProduct implements Sellable {
    String Barcode;
    double Price;
    double TaxRate;
    public NonFoodProduct(String barCode, double price, double taxRate) {
        this.Barcode = barCode;
        this.Price = (price * taxRate) + price;
        this.TaxRate = taxRate;
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

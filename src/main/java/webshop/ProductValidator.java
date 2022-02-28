package webshop;

public class ProductValidator {
    public void validateProduct(String productName, int price) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name is empty!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be greater than zero!");
        }
    }
}

package webshop;

public class Product {
    private final long id;
    private final String productName;
    private final int price;
    private final int stock;

    public Product(long id, String productName, int price, int stock) {
        new ProductValidator().validateProduct(productName, price);
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}

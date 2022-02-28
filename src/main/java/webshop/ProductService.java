package webshop;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new IllegalArgumentException(String.format("Invalid product id(%d)!", id));
        }
        if (product.getStock() >= amount) {
            productRepository.updateProductStock(id, amount);
        } else {
            throw new IllegalArgumentException(
                    String.format("Stock (%d) is less than requested amount (%d)!", product.getStock(), amount));
        }
    }
}

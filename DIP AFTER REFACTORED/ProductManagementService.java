// DIP: Abstraction for managing products

public interface ProductManagementService {
    // All the things you can do with products
    void removeSoldOutProducts();
    void removeProduct();
    void removeProductType();
    void increaseProductQuantity();
    void decreaseProductQuantity();
    void addProduct();
}
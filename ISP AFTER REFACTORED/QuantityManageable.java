/// Interface for products with quantity that can be changed
/// Only product-related classes use this
public interface QuantityManageable {
    
    /// Get current quantity in stock
    int getQuantity();
    
    /// Add more items to stock
    void increaseQuantity(int quantity);
    
    /// Remove items from stock (selling or removing)
    void decreaseQuantity(int quantity);
}
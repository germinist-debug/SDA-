/**
 * Factory interface for creating products.
 * Open for extension - add new product types by implementing this interface.
 */
public interface ProductFactory {
    
    /**
     * Creates a new product instance
     */
    Product createProduct(String name, String size, String color, int quantity, int price);
    
    /**
     * Returns the type of product (e.g., "topWear", "bottomWear")
     */
    String getProductType();
    
    /**
     * Checks if this factory supports the given product name
     */
    boolean supports(String name);
    
    /**
     * Returns all valid product names for this factory
     */
    java.util.List<String> getValidNames();
}
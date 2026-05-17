import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Registry that manages all product factories.
 * Open for extension - register new factories without modifying existing code.
 */
public class ProductFactoryRegistry {
    
    private List<ProductFactory> factories = new ArrayList<>();
    
    public ProductFactoryRegistry() {
        // Register existing factories - TO ADD NEW PRODUCT TYPE, JUST ADD NEW FACTORY HERE
        registerFactory(new TopWearFactory());
        registerFactory(new BottomWearFactory());
    }
    
    /**
     * Register a new product factory
     */
    public void registerFactory(ProductFactory factory) {
        factories.add(factory);
    }
    
    /**
     * Get the appropriate factory for a product name
     */
    public ProductFactory getFactoryFor(String productName) {
        return factories.stream()
            .filter(f -> f.supports(productName))
            .findFirst()
            .orElse(null);
    }
    
    /**
     * Get all valid product names from all registered factories
     */
    public List<String> getAllProductNames() {
        return factories.stream()
            .flatMap(f -> f.getValidNames().stream())
            .collect(Collectors.toList());
    }
    
    /**
     * Get the product type for a given product name
     */
    public String getProductType(String name) {
        ProductFactory factory = getFactoryFor(name);
        return factory != null ? factory.getProductType() : null;
    }
    
    /**
     * Check if a product name is valid
     */
    public boolean isValidProductName(String name) {
        return getFactoryFor(name) != null;
    }
    
    /**
     * Get all registered factories
     */
    public List<ProductFactory> getFactories() {
        return new ArrayList<>(factories);
    }
}
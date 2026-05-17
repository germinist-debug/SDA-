import java.util.Arrays;
import java.util.List;

/**
 * Factory for creating TopWear products
 */
public class TopWearFactory implements ProductFactory {
    
    private static final List<String> VALID_NAMES = Arrays.asList(
        "TSHIRT", "SHIRT", "BLOUSE", "SWEATER", "HOODIE", "CARDIGAN", "JACKET", "COAT"
    );
    
    @Override
    public Product createProduct(String name, String size, String color, int quantity, int price) {
        return new TopWear(name, size, color, quantity, price);
    }
    
    @Override
    public String getProductType() {
        return "topWear";
    }
    
    @Override
    public boolean supports(String name) {
        return VALID_NAMES.contains(name);
    }
    
    @Override
    public List<String> getValidNames() {
        return VALID_NAMES;
    }
}
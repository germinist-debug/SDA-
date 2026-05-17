import java.util.Arrays;
import java.util.List;

/**
 * Factory for creating BottomWear products
 */
public class BottomWearFactory implements ProductFactory {
    
    private static final List<String> VALID_NAMES = Arrays.asList(
        "JEANS", "SHORTS", "PANTS", "SKIRT"
    );
    
    @Override
    public Product createProduct(String name, String size, String color, int quantity, int price) {
        return new BottomWear(name, size, color, quantity, price);
    }
    
    @Override
    public String getProductType() {
        return "bottomWear";
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
import java.util.ArrayList;

/// Utility class that works with ANY AttributeCheckable object
/// This shows the power of ISP - we don't care if it's Client, Owner, or Product
public class ValidationUtils {
    
    /// Validate multiple objects at once
    /// Works with Client, Owner, Product - anything that implements AttributeCheckable
    public static void validateAll(AttributeCheckable... items) throws Exception {
        for(AttributeCheckable item : items) {
            System.out.println("Validating: " + item.getClass().getSimpleName());
            item.checkAttributes();
            System.out.println("✓ Valid!");
        }
    }
    
    /// Print info from multiple objects
    public static void printAllInfo(InfoProvider... providers) {
        for(InfoProvider provider : providers) {
            System.out.println("Information: " + provider.getInfo());
        }
    }
    
    /// Example: Only works with products (specific to QuantityManageable)
    public static void addStockToAll(QuantityManageable... products) {
        for(QuantityManageable product : products) {
            product.increaseQuantity(5);
            System.out.println("Added 5 stock. New quantity: " + product.getQuantity());
        }
    }
}
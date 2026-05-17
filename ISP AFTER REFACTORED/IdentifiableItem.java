/// Interface for items that have identity attributes
/// Helps find and compare products
public interface IdentifiableItem {
    
    /// Get product name (JEANS, TSHIRT, etc.)
    String getName();
    
    /// Get size (S, M, L, XL, etc.)
    String getSize();
    
    /// Get color (RED, BLUE, BLACK, etc.)
    String getColor();
}
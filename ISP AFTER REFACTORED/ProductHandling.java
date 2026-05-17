/// ProductHandling interface - NOW extends smaller, focused interfaces
/// A product can be identified, have quantity, have price, be validated, and be compared
public interface ProductHandling extends 
    IdentifiableItem,      // For name, size, color
    QuantityManageable,    // For quantity operations
    PricedItem,           // For price operations
    AttributeCheckable,   // For validation
    Comparable<ProductHandling> {  // For sorting
    
    /// toString is inherited from Object
    String toString();
    
    /// equals is inherited from Object
    boolean equals(Object obj);
}
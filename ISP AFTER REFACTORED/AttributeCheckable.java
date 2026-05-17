/// Interface for objects that can validate their own attributes
/// Any class that needs validation (Client, Owner, Product) will use this
public interface AttributeCheckable {
    
    /// Check if all attributes are valid
    /// Throws exception if something is wrong
    void checkAttributes() throws InvalidPersonAttribute, InvalidProductAttribute;
}
/// Interface for items that cost money
/// Both products and anything else with a price can use this
public interface PricedItem {
    
    /// Get the current price
    int getPrice();
    
    /// Change the price
    void setPrice(int price);
}
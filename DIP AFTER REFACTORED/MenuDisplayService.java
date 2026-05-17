// DIP: Abstraction for displaying store information

public interface MenuDisplayService {
    void displayStoreState(OnlineStore store);
    void displayGroupedProducts(OnlineStore store);
    void displayProductCount(OnlineStore store);
}
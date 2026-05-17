import java.util.ArrayList;
import java.util.Map;

// CHANGE: New name + implements interface
public class StoreDisplayServiceImpl implements MenuDisplayService {  // <-- CHANGED
    
    private OutputWriter output;    // CHANGE: OutputWriter instead of ConsoleOutputWriter
    
    // CHANGE: Constructor uses interface
    public StoreDisplayServiceImpl(OutputWriter output) {  // <-- CHANGED
        this.output = output;
    }
    
    @Override  // <-- ADD THIS
    public void displayStoreState(OnlineStore store) {
        output.printLine("\n=== STORE STATE ===");
        output.printStore(store);
    }
    
    @Override  // <-- ADD THIS
    public void displayGroupedProducts(OnlineStore store) {
        output.printLine("\n=== PRODUCTS GROUPED BY TYPE ===");
        Map<String, ArrayList<Product>> grouped = store.groupProductsByType();
        
        for(Map.Entry<String, ArrayList<Product>> entry : grouped.entrySet()) {
            output.printLine("\n" + entry.getKey() + ":");
            for(Product product : entry.getValue()) {
                output.printLine("  - " + product.getName() + " | Size: " + product.getSize() + " | Price: $" + product.getPrice());
            }
        }
    }
    
    @Override  // <-- ADD THIS
    public void displayProductCount(OnlineStore store) {
        Map<String, Integer> counts = store.countProducts();
        output.printLine("\n=== PRODUCT COUNTS ===");
        int total = 0;
        for(Map.Entry<String, Integer> entry : counts.entrySet()) {
            output.printLine(entry.getKey() + ": " + entry.getValue() + " products");
            total += entry.getValue();
        }
        output.printLine("Total products: " + total);
    }
}
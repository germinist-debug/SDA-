import java.util.ArrayList;
import java.util.Objects;

// CHANGE: New name + implements interface
public class ProductServiceImpl implements ProductManagementService {  // <-- CHANGED
    
    private OnlineStore store;
    private InputReader input;      // CHANGE: InputReader instead of ConsoleInputReader
    private OutputWriter output;    // CHANGE: OutputWriter instead of ConsoleOutputWriter
    
    // CHANGE: Constructor uses interfaces
    public ProductServiceImpl(OnlineStore store, InputReader input, OutputWriter output) {  // <-- CHANGED
        this.store = store;
        this.input = input;
        this.output = output;
    }
    
    @Override  // <-- ADD THIS
    public void removeSoldOutProducts() {
        int before = store.getProductList().length;
        store.removeSoldOutProducts();
        int after = store.getProductList().length;
        output.printLine("Removed " + (before - after) + " sold out products");
    }
    
    @Override  // <-- ADD THIS
    public void removeProduct() {
        displayProductsWithNumbers();
        output.printLine("Enter product number to remove: ");
        int index = input.readInt() - 1;
        
        if(index >= 0 && index < store.getProductList().length) {
            Product removed = store.getProductList()[index];
            store.removeProductIdx(index);
            output.printLine("Removed: " + removed.getName());
        } else {
            output.printLine("Invalid product number");
        }
    }
    
    @Override  // <-- ADD THIS
    public void removeProductType() {
        output.printLine("Enter product type to remove (e.g., JEANS, TSHIRT): ");
        String type = input.readLine().toUpperCase();
        
        ArrayList<String> existingTypes = store.getProductTypes();
        if(!existingTypes.contains(type)) {
            output.printLine("Product type not found");
            return;
        }
        
        store.removeProductType(type);
        output.printLine("Removed all products of type: " + type);
    }
    
    @Override  // <-- ADD THIS
    public void increaseProductQuantity() {
        displayProductsWithNumbers();
        output.printLine("Enter product number: ");
        int index = input.readInt() - 1;
        
        if(index >= 0 && index < store.getProductList().length) {
            output.printLine("Enter quantity to add: ");
            int quantity = input.readInt();
            store.increaseProductQuantity(index, quantity);
            output.printLine("Added " + quantity + " units");
        } else {
            output.printLine("Invalid product number");
        }
    }
    
    @Override  // <-- ADD THIS
    public void decreaseProductQuantity() {
        displayProductsWithNumbers();
        output.printLine("Enter product number: ");
        int index = input.readInt() - 1;
        
        if(index >= 0 && index < store.getProductList().length) {
            output.printLine("Enter quantity to remove: ");
            int quantity = input.readInt();
            store.decreaseProductQuantity(index, quantity);
            output.printLine("Removed " + quantity + " units");
        } else {
            output.printLine("Invalid product number");
        }
    }
    
    @Override  // <-- ADD THIS
    public void addProduct() {
        output.printLine("\n=== ADD NEW PRODUCT ===");
        
        output.printLine("Enter product name (JEANS, TSHIRT, etc.): ");
        String name = input.readLine().toUpperCase();
        
        String size = input.readSize();
        String color = input.readColor();
        int price = input.readPrice();
        int quantity = input.readQuantity();
        
        Product product;
        if(isBottomWear(name)) {
            product = new BottomWear(name, size, color, quantity, price);
        } else {
            product = new TopWear(name, size, color, quantity, price);
        }
        
        store.addProduct(product);
        output.printLine("Product added successfully!");
    }
    
    // This method stays exactly the same
    private void displayProductsWithNumbers() {
        output.printLine("\n=== CURRENT PRODUCTS ===");
        Product[] products = store.getProductList();
        for(int i = 0; i < products.length; i++) {
            output.printLine((i+1) + ". " + products[i].getName() + " | Size: " + products[i].getSize() + 
                           " | Stock: " + products[i].getQuantity() + " | Price: $" + products[i].getPrice());
        }
    }
    
    // This method stays exactly the same
    private boolean isBottomWear(String name) {
        String[] bottomTypes = {"JEANS", "SHORTS", "PANTS", "SKIRT"};
        for(String type : bottomTypes) {
            if(type.equals(name)) return true;
        }
        return false;
    }
}
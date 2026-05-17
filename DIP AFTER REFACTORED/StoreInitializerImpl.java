import java.util.ArrayList;

// CHANGE: New name + implements interface
public class StoreInitializerImpl implements StoreInitializerService {  // <-- CHANGED
    
    private InputReader input;      // CHANGE: InputReader instead of ConsoleInputReader
    private OutputWriter output;    // CHANGE: OutputWriter instead of ConsoleOutputWriter
    private RandomProductGenerator randomGenerator;
    
    // CHANGE: Constructor uses interfaces
    public StoreInitializerImpl(InputReader input, OutputWriter output) {  // <-- CHANGED
        this.input = input;
        this.output = output;
        this.randomGenerator = new RandomProductGenerator();
    }
    
    @Override  // <-- ADD THIS
    public OnlineStore createStoreFromScratch() {
        output.printLine("\nDo you want to generate a dummy owner? (y/n)");
        String answer = input.readLine();
        
        Owner owner;
        if(answer.equalsIgnoreCase("y")) {
            owner = new Owner("John Doe", "1234567890", "john@example.com");
        } else {
            owner = createOwnerFromInput();
        }
        
        OnlineStore store = new OnlineStore(owner);
        
        output.printLine("\nDo you want to generate random products? (y/n)");
        answer = input.readLine();
        
        if(answer.equalsIgnoreCase("y")) {
            ArrayList<Product> products = randomGenerator.generateRandomProducts();
            for(Product product : products) {
                store.addProduct(product);
            }
            output.printLine("Added " + products.size() + " random products");
        }
        
        return store;
    }
    
    @Override  // <-- ADD THIS
    public OnlineStore createEmptyStore() {
        output.printLine("Enter owner details:");
        Owner owner = createOwnerFromInput();
        return new OnlineStore(owner);
    }
    
    // This method stays exactly the same
    private Owner createOwnerFromInput() {
        String name = input.readName();
        String phone = input.readPhoneNumber();
        String email = input.readEmail();
        return new Owner(name, phone, email);
    }
}
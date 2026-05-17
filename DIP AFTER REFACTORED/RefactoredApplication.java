// CHANGE: This is now MUCH simpler - it just uses the config
public class RefactoredApplication {
    
    private ApplicationConfig config;  // CHANGE: Use config instead of direct creation
    
    public RefactoredApplication() {
        this.config = new ApplicationConfig();  // Create the config
    }
    
    public void run(String[] args) {
        OutputWriter output = config.getOutputWriter();  // Get output from config
        
        output.printLine("=== ONLINE STORE MANAGEMENT SYSTEM (DIP Applied) ===");
        
        // Determine which mode to use
        String mode = "empty";
        if(args.length > 0 && args[0].equals("scratch")) {
            mode = "scratch";
            output.printLine("\nCreating store from scratch...");
        } else {
            output.printLine("\nCreating empty store...");
        }
        
        // Create store using config (config decides how)
        OnlineStore store = config.createStore(mode);
        
        // Setup services with the store
        config.setupServices(store);
        
        // Create and run menu handler
        MenuHandler menuHandler = config.createMenuHandler(store);
        menuHandler.runOwnerMenu();
    }
    
    public static void main(String[] args) {
        RefactoredApplication app = new RefactoredApplication();
        app.run(args);
    }
}
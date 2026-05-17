// DIP: This is the "brain" that puts everything together
// It decides WHICH concrete classes to use

public class ApplicationConfig {
    
    // Store the dependencies (the things we need)
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private StoreInitializerService storeInitializer;
    private MenuDisplayService menuDisplayService;
    private ProductManagementService productManagementService;
    
    // Constructor - decides which implementations to use
    public ApplicationConfig() {
        // WE CHOOSE the concrete implementations here!
        // Want to use file input instead? Change ConsoleInputReader to FileInputReader!
        this.inputReader = new ConsoleInputReader();    // Using console input
        this.outputWriter = new ConsoleOutputWriter();  // Using console output
    }
    
    // Method to create a store based on mode
    public OnlineStore createStore(String mode) {
        // Create the store initializer with our chosen input/output
        this.storeInitializer = new StoreInitializerImpl(inputReader, outputWriter);
        
        if(mode.equals("scratch")) {
            return storeInitializer.createStoreFromScratch();
        } else {
            return storeInitializer.createEmptyStore();
        }
    }
    
    // Method to setup all services with the store
    public void setupServices(OnlineStore store) {
        this.menuDisplayService = new StoreDisplayServiceImpl(outputWriter);
        this.productManagementService = new ProductServiceImpl(store, inputReader, outputWriter);
    }
    
    // Method to create the menu handler with all dependencies
    public MenuHandler createMenuHandler(OnlineStore store) {
        return new MenuHandler(
            inputReader,           // Give it the input reader
            outputWriter,          // Give it the output writer  
            menuDisplayService,    // Give it the display service
            productManagementService, // Give it the product service
            store                  // Give it the store
        );
    }
    
    // Getters (in case someone needs them)
    public InputReader getInputReader() { return inputReader; }
    public OutputWriter getOutputWriter() { return outputWriter; }
}
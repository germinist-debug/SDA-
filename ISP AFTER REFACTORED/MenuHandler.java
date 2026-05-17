public class MenuHandler {
    
    private ConsoleInputReader input;
    private ConsoleOutputWriter output;
    private MenuRegistry menuRegistry;
    private OnlineStore store;
    
    /**
     * Constructor - creates menu handler with command pattern
     * OCP: Commands are registered here, open for extension
     */
    public MenuHandler(ConsoleInputReader input, ConsoleOutputWriter output, 
                       StoreDisplayService displayService, ProductService productService,
                       OnlineStore store) {
        this.input = input;
        this.output = output;
        this.menuRegistry = new MenuRegistry();
        this.store = store;
        
        // Register all commands - Using ShowStoreCommand (not DisplayStoreCommand)
        registerCommands(displayService, productService);
    }
    
    /**
     * Register all menu commands
     * To add a new menu item, just add a new command here
     */
    private void registerCommands(StoreDisplayService displayService, ProductService productService) {
        // Command 1: Display store state - USING ShowStoreCommand
        menuRegistry.registerCommand(new ShowStoreCommand(displayService, store));
        
        // Command 2: Group products by type
        menuRegistry.registerCommand(new GroupProductsCommand(displayService, store));
        
        // Command 3: Count products
        menuRegistry.registerCommand(new CountProductsCommand(displayService, store));
        
        // Command 4: Remove sold out products
        menuRegistry.registerCommand(new RemoveSoldOutCommand(productService));
        
        // Command 5: Remove a specific product
        menuRegistry.registerCommand(new RemoveProductCommand(productService));
        
        // Command 6: Remove all products of a type
        menuRegistry.registerCommand(new RemoveProductTypeCommand(productService));
        
        // Command 7: Increase product quantity
        menuRegistry.registerCommand(new IncreaseQuantityCommand(productService));
        
        // Command 8: Decrease product quantity
        menuRegistry.registerCommand(new DecreaseQuantityCommand(productService));
        
        // Command 9: Add new product
        menuRegistry.registerCommand(new AddProductCommand(productService));
        
        // Command 10: Exit application
        menuRegistry.registerCommand(new ExitCommand(output));
    }
    
    /**
     * Run the main owner menu loop
     */
    public void runOwnerMenu() {
        boolean running = true;
        
        while(running) {
            // Display the menu using the registry
            menuRegistry.displayMenu(output);
            output.print("Choose option: ");
            
            int choice = input.readInt();
            
            // Get and execute the command
            MenuCommand command = menuRegistry.getCommand(choice);
            if(command != null) {
                command.execute();
                
                // Check if we need to exit
                if(command instanceof ExitCommand) {
                    running = false;
                }
            } else {
                output.printLine("Invalid option. Please try again.");
            }
        }
    }
}
public class CountProductsCommand implements MenuCommand {
    
    private StoreDisplayService displayService;
    private OnlineStore store;
    
    public CountProductsCommand(StoreDisplayService displayService, OnlineStore store) {
        this.displayService = displayService;
        this.store = store;
    }
    
    @Override
    public void execute() {
        displayService.displayProductCount(store);
    }
    
    @Override
    public String getDescription() {
        return "Count products";
    }
}
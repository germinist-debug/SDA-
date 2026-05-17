public class GroupProductsCommand implements MenuCommand {
    
    private StoreDisplayService displayService;
    private OnlineStore store;
    
    public GroupProductsCommand(StoreDisplayService displayService, OnlineStore store) {
        this.displayService = displayService;
        this.store = store;
    }
    
    @Override
    public void execute() {
        displayService.displayGroupedProducts(store);
    }
    
    @Override
    public String getDescription() {
        return "Group products by type";
    }
}
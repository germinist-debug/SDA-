/**
 * Command to display the current state of the store.
 * Alternative name for DisplayStoreCommand
 */
public class ShowStoreCommand implements MenuCommand {
    
    private StoreDisplayService displayService;
    private OnlineStore store;
    
    public ShowStoreCommand(StoreDisplayService displayService, OnlineStore store) {
        this.displayService = displayService;
        this.store = store;
    }
    
    @Override
    public void execute() {
        displayService.displayStoreState(store);
    }
    
    @Override
    public String getDescription() {
        return "Display store state";
    }
}
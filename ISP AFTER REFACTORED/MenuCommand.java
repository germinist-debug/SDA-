/**
 * Command interface for menu actions.
 * Open for extension - add new menu items by implementing this interface.
 */
public interface MenuCommand {
    
    /**
     * Execute the command
     */
    void execute();
    
    /**
     * Get the description shown in the menu
     */
    String getDescription();
}
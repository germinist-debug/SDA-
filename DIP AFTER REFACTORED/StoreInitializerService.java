// DIP: Abstraction for creating stores

public interface StoreInitializerService {
    // Create a store with random/dummy data
    OnlineStore createStoreFromScratch();
    
    // Create an empty store with just owner
    OnlineStore createEmptyStore();
}
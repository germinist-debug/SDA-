import java.util.ArrayList;

/// Interface for objects that can provide their info as a list
/// Only classes that need to show their info in list form use this
public interface InfoProvider {
    
    /// Get all information as ArrayList (name, phone, email)
    ArrayList<String> getInfo();
}
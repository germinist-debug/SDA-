import java.util.ArrayList;

/// Person interface - NOW only defines what EVERY person MUST have
/// It EXTENDS smaller interfaces instead of having all methods inside
public interface Person extends AttributeCheckable, InfoProvider {
    
    /// Every person has a name
    String getName();
    
    /// Every person has a phone number
    String getPhoneNumber();
    
    /// Every person has an email
    String getEmail();
    
    /// Every person can be represented as string
    String toString();
}
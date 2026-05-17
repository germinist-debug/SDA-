// DIP: This is an ABSTRACTION (the "interface" that everyone agrees on)
// Any class that wants to be an "input reader" must have these methods

public interface InputReader {
    // Basic reading methods
    String readLine();
    int readInt();
    
    // Specific reading methods with validation
    String readEmail();
    String readPassword();
    String readName();
    String readPhoneNumber();
    String readSize();
    String readColor();
    int readPrice();
    int readQuantity();
}
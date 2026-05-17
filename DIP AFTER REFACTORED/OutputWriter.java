// DIP: This is an ABSTRACTION for writing/output

public interface OutputWriter {
    // Basic writing methods
    void print(Object message);
    void printLine(Object message);
    
    // Complex writing methods
    void printStore(OnlineStore store);
    void printMenu(String[] options);
}
public class InvalidNotationFormatException extends Exception {
    
    // Constructor that accepts a message
    public InvalidNotationFormatException(String message) {
        super(message);  // Call the parent class (Exception) constructor with the message
    }

    // Optional: You could also provide a constructor that accepts both a message and a cause
    public InvalidNotationFormatException(String message, Throwable cause) {
        super(message, cause);  // Pass the message and cause to the parent class constructor
    }
}

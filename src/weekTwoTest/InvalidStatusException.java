package weekTwoTest;

public class InvalidStatusException extends Exception{
    public InvalidStatusException() {
        super("Invalid test.Order Status. Must be 'Open' or 'Closed'.");
    }


}

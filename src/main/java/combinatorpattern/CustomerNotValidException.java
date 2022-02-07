package combinatorpattern;

public class CustomerNotValidException extends Exception{

    public CustomerNotValidException(String errorMessage) {
        super("Customer data not valid -> "+errorMessage);
    }

}

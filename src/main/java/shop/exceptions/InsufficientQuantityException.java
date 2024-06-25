package shop.exceptions;

public class InsufficientQuantityException extends Exception{
    public InsufficientQuantityException(String errorMessage){
        super(errorMessage);
    }
}

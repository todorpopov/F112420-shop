package shop.exceptions;

public class ItemSoldOutException extends Exception{
    public ItemSoldOutException(String errorMessage){
        super(errorMessage);
    }
}

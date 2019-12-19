package org.temoinjehova;

/**
 * Exception class for filter
 */
public class FilterException extends Exception{
    /**
     * Launch exception when a filter cannot be applied
     * @param message message of the exception
     */
public FilterException(String message){
    super (message);

}

    /**
     * Launch exception when a filter cannot be applied
     * @param message message of the exception
     * @param e exception catched
     */
    public FilterException(String message, Throwable e){
    super(message,e);
}

}
package org.temoinjehova;

public class FilterException extends Exception{
public FilterException(String message){
    super (message);

}
public FilterException(String message, Throwable e){
    super(message,e);
}

}
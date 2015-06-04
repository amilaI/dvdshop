package com.dvdshop.portello.exception;

/**
 * Created by dinusha on 5/13/14.
 */
public class RedisException extends Exception {

    public  RedisException(){

    }

    public RedisException(String msg){
        super(msg);
    }

    public RedisException(String msg,Throwable throwable){
        super(msg,throwable);
    }
}

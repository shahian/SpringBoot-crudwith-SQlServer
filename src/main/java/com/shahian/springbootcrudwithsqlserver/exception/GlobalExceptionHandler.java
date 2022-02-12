package com.shahian.springbootcrudwithsqlserver.exception;

public class GlobalExceptionHandler extends RuntimeException{

    public GlobalExceptionHandler(String msg){
        super(msg);
    }
}

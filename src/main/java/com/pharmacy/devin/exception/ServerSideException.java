package com.pharmacy.devin.exception;


public class ServerSideException extends RuntimeException{


    ServerSideException(String message){
        super(message);

    }

    ServerSideException(){
        super();
    }
}

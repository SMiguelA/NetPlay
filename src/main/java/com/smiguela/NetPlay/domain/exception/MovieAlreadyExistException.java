package com.smiguela.NetPlay.domain.exception;

public class MovieAlreadyExistException extends RuntimeException{
    public MovieAlreadyExistException(String name){
        super("Movie with name " + name + " already exists, try again with a different movie.");
    }
}

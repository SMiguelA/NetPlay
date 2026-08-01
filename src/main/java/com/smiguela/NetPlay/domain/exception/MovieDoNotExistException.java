package com.smiguela.NetPlay.domain.exception;

public class MovieDoNotExistException extends RuntimeException {
    public MovieDoNotExistException(long id) {
        super("Movie with ID "+id+" does not exist.");
    }
}

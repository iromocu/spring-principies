package com.devriro.play.domain.exceptions;

public class MovieAlreadyExistException extends RuntimeException{
    public MovieAlreadyExistException(String title){
        super("The movie" + title + " is already exist ");
    }
}

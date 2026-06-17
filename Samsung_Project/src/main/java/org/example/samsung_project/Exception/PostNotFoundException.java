package org.example.samsung_project.Exception;

// PostNotFoundException.java
public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String message){
        super(message);
    }
}
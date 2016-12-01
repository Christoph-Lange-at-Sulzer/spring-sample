package de.sulzer.stgt.sample.springboot.exception;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String msg) {
        super(msg);
    }
}

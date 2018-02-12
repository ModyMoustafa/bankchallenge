package com.bank.quote.caluclations.Exceptions;

/**
 * 
 * @author Ahmed Mostafa
 * 
 * @Description Create custom exception for the application for invalid request amount
 *
 */
public class InvalidRequestAmountException extends RuntimeException {
    private static final long serialVersionUID = -5836180738846127210L;
    private final String message;

    /**
     * @param message
     */
    public InvalidRequestAmountException(String message) {
        this.message = message;
    }

    /**
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}

package com.nicai.exception;

/**
 * My Exception
 *
 * @author nicai
 */
public class NicaiException extends RuntimeException {

    public NicaiException(Exception e) {
        super(e);
    }

    public NicaiException() {
        super();
    }

    public NicaiException(String message) {
        super(message);
    }

    public NicaiException(String message, Exception e) {
        super(message, e);
    }
}

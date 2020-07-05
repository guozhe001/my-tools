package com.nicai.experience.exception;

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
}

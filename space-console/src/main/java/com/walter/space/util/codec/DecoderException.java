package com.walter.space.util.codec;

/**
 * @since 1.0.0
 * Created Time: 2016-10-24 19:53
 */
public class DecoderException extends Exception {
    /**
     * Declares the Serial Version Uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with null as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to initCause.
     */
    public DecoderException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
     * be initialized by a call to initCause.
     *
     * @param message
     *            The detail message which is saved for later retrieval by the getMessage() method.
     */
    public DecoderException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * Note that the detail message associated with cause is not automatically incorporated into this
     * exception's detail message.
     *
     * @param message
     *            The detail message which is saved for later retrieval by the getMessage() method.
     * @param cause
     *            The cause which is saved for later retrieval by the getCause() method. A null
     *            value is permitted, and indicates that the cause is nonexistent or unknown.
     */
    public DecoderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of cause==null ?
     * null : cause.toString())(which typically contains the class and detail message of cause).
     * This constructor is useful for exceptions that are little more than wrappers for other throwables.
     *
     * @param cause
     *            The cause which is saved for later retrieval by the getCause() method. A null
     *            value is permitted, and indicates that the cause is nonexistent or unknown.
     */
    public DecoderException(final Throwable cause) {
        super(cause);
    }
}

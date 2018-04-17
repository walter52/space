package com.walter.space.util.codec;

/**
 * Thrown when there is a failure condition during the encoding process. This exception is thrown when an
 * Encoder encounters a encoding specific exception such as invalid data, inability to calculate a checksum,
 * characters outside of the expected range.
 *
 * @since 1.0.0
 * Created Time: 2016-10-24 19:53
 */
public class EncoderException extends Exception {
    /**
     * Declares the Serial Version Uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with null as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to initCause.
     */
    public EncoderException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
     * be initialized by a call to initCause.
     *
     * @param message
     *            a useful message relating to the encoder specific error.
     */
    public EncoderException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * Note that the detail message associated with cause is not automatically incorporated into this
     * exception's detail message.
     *
     * @param message
     *            The detail message which is saved for later retrieval by the getMessage() method.
     * @param cause
     *            The cause which is saved for later retrieval by the getCause() method. A null
     *            value is permitted, and indicates that the cause is nonexistent or unknown.
     */
    public EncoderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of (cause==null ?
     * null : cause.toString()) (which typically contains the class and detail message of cause).
     * This constructor is useful for exceptions that are little more than wrappers for other throwables.
     *
     * @param cause
     *            The cause which is saved for later retrieval by the getCause() method. A null
     *            value is permitted, and indicates that the cause is nonexistent or unknown.
     */
    public EncoderException(final Throwable cause) {
        super(cause);
    }
}

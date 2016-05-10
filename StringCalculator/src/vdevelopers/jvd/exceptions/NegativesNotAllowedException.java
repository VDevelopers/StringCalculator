package vdevelopers.jvd.exceptions;

public class NegativesNotAllowedException extends Exception {

    private static final long serialVersionUID = 6013269710339755291L;

    public NegativesNotAllowedException(String message) {
        super(message);
    }
}

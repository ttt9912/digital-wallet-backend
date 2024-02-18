package ch.thts.digitalwalletbackend.natwestclient.account.exception;

public class CreditDebitIndicatorUnknownException extends RuntimeException {
    public CreditDebitIndicatorUnknownException(final String message) {
        super(message);
    }
}

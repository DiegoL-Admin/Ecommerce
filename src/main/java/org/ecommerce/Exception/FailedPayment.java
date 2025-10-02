package org.ecommerce.Exception;

public class FailedPayment extends RuntimeException {
    public FailedPayment(String message) {
        super(message);
    }
}

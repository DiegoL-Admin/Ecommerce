package org.ecommerce.Payment;

public interface PaymentProcessor {

    void paymentInit(double monto);

    boolean paymentVerify();

    void paymentConfirm();
}

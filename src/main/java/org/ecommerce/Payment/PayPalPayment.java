package org.ecommerce.Payment;

public class PayPalPayment implements PaymentProcessor{
    @Override
    public void paymentInit(double monto) {
        System.out.println("Iniciando pago con PayPal por $" + monto);
    }

    @Override
    public boolean paymentVerify() {
        System.out.println("Verificando fondos de la PayPal por $...");
        return true; // Simulación
    }

    @Override
    public void paymentConfirm() {
        System.out.println("Pago con PayPal confirmado.");
    }
}

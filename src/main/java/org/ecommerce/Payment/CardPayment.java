package org.ecommerce.Payment;
import org.ecommerce.Exception.FailedPayment;
public class CardPayment implements PaymentProcessor {
    @Override
    public void paymentInit(double monto) {
        System.out.println("Iniciando pago con tarjeta por $" + monto);
    }

    @Override
    public boolean paymentVerify() throws FailedPayment {
        try {
            System.out.println("🔍 Verificando fondos de la tarjeta...");
            return true;
        } catch (Exception e) {
            System.out.println("Error al verificar el pago: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void paymentConfirm() {
        System.out.println("Pago con tarjeta confirmado.");
    }
}

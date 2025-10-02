package org.ecommerce.Observer;

public class InventoryNotifier implements Observer {

    @Override
    public void refresh(String evento, String mensaje) {
        System.out.println("[Inventario] Evento: " + evento + " - " + mensaje);
    }
}

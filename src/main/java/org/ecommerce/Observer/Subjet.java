package org.ecommerce.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subjet {
    private final List<Observer> observadores = new ArrayList<>();

    public void suscribe(Observer observador) {
        observadores.add(observador);
    }

    public void unSuscribe(Observer observador) {
        observadores.remove(observador);
    }

    public void notify(String evento, String mensaje) {
        for (Observer o : observadores) {
            o.refresh(evento, mensaje);
        }
    }
}
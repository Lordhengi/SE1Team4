package Aufgabe_12;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Multiton {
    private static final ConcurrentMap<Fahrzeug, Multiton> multitons = new ConcurrentHashMap<Fahrzeug, Multiton>();

    private final Fahrzeug key;
    private Multiton(Fahrzeug key) { this.key = key; }

    public static Multiton getInstance(final Fahrzeug key) {
        return multitons.computeIfAbsent(key, Multiton::new);
    }
}
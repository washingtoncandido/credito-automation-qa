package org.example.core.rest;

public final class Endpoints {

    // Construtor privado para evitar instaciação (Classe utilitária de constantes)
    private Endpoints() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }

    public static final String SIMULATIONS = "http://localhost:3000/api/credito/simular";
    public static final String SIMULATINS_SALDO = "http://localhost:3000/api/saldo";
}
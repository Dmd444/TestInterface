package com.dmd.testinterface;

public class Contador {

    private int numeroClics;

    public Contador() {
        this.numeroClics = 0;
    }

    public Contador(int numeroClics) {
        this.numeroClics = numeroClics;
    }

    public int getNumeroClics() {
        return numeroClics;
    }

    public void setNumeroClics(int numeroClics) {
        this.numeroClics = numeroClics;
    }

    public void incrementarClic() {
        this.numeroClics = this.numeroClics + 1;
    }
}

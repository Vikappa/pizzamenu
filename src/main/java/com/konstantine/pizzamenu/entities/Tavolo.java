package com.konstantine.pizzamenu.entities;

import java.util.ArrayList;

public class Tavolo {

    public enum statoTavolo {
        LIBERO, OCCUPATO;
    }
    private int numeroTavolo;
    ArrayList<Alimento> ordinazioni;
    private int posti;
    private statoTavolo statoTavolo;

    public Tavolo(int numeroTavolo, ArrayList<Alimento> ordinazioni, int posti, Tavolo.statoTavolo statoTavolo) {
        this.numeroTavolo = numeroTavolo;
        this.ordinazioni = ordinazioni;
        this.posti = posti;
        this.statoTavolo = statoTavolo;
    }

    public Tavolo(int numeroTavolo,  int posti, Tavolo.statoTavolo statoTavolo) {
        this.numeroTavolo = numeroTavolo;
        this.ordinazioni = null;
        this.posti = posti;
        this.statoTavolo = statoTavolo;
    }

    public int getNumeroTavolo() {
        return numeroTavolo;
    }

    public void setNumeroTavolo(int numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public ArrayList<Alimento> getOrdinazioni() {
        return ordinazioni;
    }

    public void setOrdinazioni(ArrayList<Alimento> ordinazioni) {
        this.ordinazioni = ordinazioni;
    }

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public Tavolo.statoTavolo getStatoTavolo() {
        return statoTavolo;
    }

    public void setStatoTavolo(Tavolo.statoTavolo statoTavolo) {
        this.statoTavolo = statoTavolo;
    }
}

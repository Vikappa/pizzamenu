package com.konstantine.pizzamenu.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ordine {

    private static int nOrdini = 0;

    public void addAlimento(Alimento alimentoScelto) {
        this.ordinazioni.add(alimentoScelto);
    }


    public enum StatoOrdine {
        IN_CORSO, PRONTO, SERVITO;
    }

    @Setter
    @Getter
    private int idOrdine;
    @Setter
    @Getter
    private StatoOrdine statoOrdine;
    @Getter
    @Setter
    private Tavolo tavoloOrdine;
    @Setter
    @Getter
    private LocalDate oraAquisizione;
    @Setter
    @Getter
    private int coperti;

    private ArrayList<Alimento> ordinazioni;

    public Ordine() {
        this.oraAquisizione = LocalDate.now();
        this.idOrdine = nOrdini++;
        this.statoOrdine = StatoOrdine.IN_CORSO;
        this.ordinazioni = new ArrayList<Alimento>();
    }

    public Ordine(StatoOrdine statoOrdine, Tavolo tavoloOrdine, int coperti) {
        this.idOrdine = nOrdini++;
        this.statoOrdine = statoOrdine;
        this.tavoloOrdine = tavoloOrdine;
        this.coperti = coperti;
        this.oraAquisizione = LocalDate.now();
        this.ordinazioni = new ArrayList<Alimento>();
    }

    public double calcolaConto(double costoCoperto){
        int conto = 0;
        for (Alimento alimento : getTavoloOrdine().getOrdinazioni()) {
            conto += alimento.getPrezzo();
        }
        conto+= costoCoperto*this.tavoloOrdine.getPosti();
        return conto;
    }

    public ArrayList<Alimento> getOrdinazioni() {
        if (this.ordinazioni == null) {
            this.ordinazioni = new ArrayList<Alimento>();
        }
        return this.ordinazioni;
    }

    public void setOrdinazioni(ArrayList<Alimento> ordinazioni) {
        this.ordinazioni = ordinazioni;
    }
}

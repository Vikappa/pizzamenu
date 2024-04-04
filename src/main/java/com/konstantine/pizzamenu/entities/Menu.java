package com.konstantine.pizzamenu.entities;

import java.util.ArrayList;

public class Menu {
    ArrayList<Alimento> menu;


    public Menu() {
        this.menu = new ArrayList<>();
    }

    public void addAlimento(Alimento alimento) {
        this.menu.add(alimento);
    }

    public void stampaMenu(){
        menu.forEach(alimento -> System.out.println(alimento));
    }

    public void stampaMenuPerOrdinazioni() {
        int riga = 1;
        for (Alimento alimento : menu) {
            if (!(alimento instanceof Topping)) {
                System.out.println(riga + ". " + alimento);
                riga++;
            }
        }
    }

    public Alimento getAlimenti(int sceltaAlimento) {
        return menu.get(sceltaAlimento - 1);
    }

    public ArrayList<Alimento> getMenuArrayList() {
        return this.menu;
    }
}

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

}
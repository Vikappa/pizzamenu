package com.konstantine.pizzamenu.entities;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Alimento {

    @Getter
    private List<Topping> ingredienti;
    private Size size;

    public Pizza() {
        super();
    }

    public enum Size {
        GRANDE, MEDIO, PICCOLA
    }

    public Pizza(String nome, double prezzo, int calorie, List<Topping> ingredienti, Size size) {
        super(nome, prezzo, calorie);
        this.ingredienti = new ArrayList<>(ingredienti);
        this.size = size;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + nome + " Taglia: " + size + " calorie " + calorie + " €" + prezzo;
    }

    public String getSize() {
        return this.size.toString();
    }

    public void addTopping(Topping topping) {
        this.ingredienti.add(topping);
    }
}

package com.konstantine.pizzamenu.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Alimento {
    protected String nome;
    protected double prezzo;
    protected int calorie;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " " + nome + " calorie " + calorie + " €" + prezzo;
    }

    public Alimento() {
    }
}



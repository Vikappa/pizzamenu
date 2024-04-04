package com.konstantine.pizzamenu;
import com.konstantine.pizzamenu.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;

@Configuration
@PropertySource("application.properties")
public class MenuConfig {

    @Bean
    public Topping pomodoro() {
        return new Topping("pomodoro", 0.69, 40);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("mozzarella", 0.69, 92);
    }

    @Bean
    public Topping cipolla() {
        return new Topping("Cipolla", 0.69, 22);
    }


    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 0.79, 24);
    }
    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 0.99, 35);
    }

    @Bean
    public Topping salame() {
        return new Topping("Salame", 0.79, 86);
    }


    @Bean
    public Topping ventricinaPiccante() {
        return new Topping("Ventricina piccante", 0.79, 92);
    }


    @Bean
    public Topping extraMozzarella() {
        return new Topping("Extra Mozzarella", 0.69, 92);
    }

    @Bean
    public Pizza pizzaMargherita() {
        ArrayList<Topping> ingredientiMargherita = new ArrayList<>();
        ingredientiMargherita.add(pomodoro());
        ingredientiMargherita.add(mozzarella());
        Pizza pizza = new Pizza("Margherita media", 4.99, 1104, ingredientiMargherita, Pizza.Size.MEDIO);
        return pizza;
    }

    @Bean
    public Pizza pizzaMargheritaGrande() {
        ArrayList<Topping> ingredientiMargherita = new ArrayList<>();
        ingredientiMargherita.add(pomodoro());
        ingredientiMargherita.add(mozzarella());
        Pizza pizza = new Pizza("Margherita grande", 8.99, 2200, ingredientiMargherita, Pizza.Size.GRANDE);
        return pizza;
    }

    @Bean
    public Pizza pizzaHawaii() {
    ArrayList<Topping> ingredientiHawaii = new ArrayList<>();
        ingredientiHawaii.add(pomodoro());
        ingredientiHawaii.add(mozzarella());
        ingredientiHawaii.add(ananas());
        Pizza pizza = new Pizza("Hawaii", 6.49, 1024, ingredientiHawaii, Pizza.Size.MEDIO);
        return pizza;
    }

    @Bean
    public Pizza pizzaSalame() {
    ArrayList<Topping> ingredientiSalame = new ArrayList<>();
        ingredientiSalame.add(pomodoro());
        ingredientiSalame.add(mozzarella());
        ingredientiSalame.add(prosciutto());
        Pizza pizza = new Pizza("Salame", 6.49, 1024, ingredientiSalame, Pizza.Size.MEDIO);
        return pizza;
    }

    @Bean
    public Pizza pizzaDiavola() { //VINCENZO'S FAVOURITE
        ArrayList<Topping> ingredientiDiavola = new ArrayList<>();
        ingredientiDiavola.add(pomodoro());
        ingredientiDiavola.add(mozzarella());
        ingredientiDiavola.add(salame());
        ingredientiDiavola.add(cipolla());
        Pizza pizza = new Pizza("Diavola", 6.49, 1024, ingredientiDiavola, Pizza.Size.MEDIO);
        return pizza;
    }

    @Bean
    public Drink limonata03() {
        return new Drink("Limonata 0.3", 1.29, 128);
    }

    @Bean
    public Drink acqua() {
        return new Drink("Acqua 0.5", 1.29, 0);
    }

    @Bean
    public Drink vino() {
        return new Drink("Vino 0.75 13%", 7.49, 607);
    }

    @Bean
    Tavolo tavolo1() {return new Tavolo(1,2, Tavolo.statoTavolo.LIBERO);}
    @Bean
    Tavolo tavolo2() {return new Tavolo(2,4, Tavolo.statoTavolo.LIBERO);}
    @Bean
    Tavolo tavolo3() {return new Tavolo(3,5, Tavolo.statoTavolo.LIBERO);}
    @Bean
    Tavolo tavolo4() {return new Tavolo(4,3, Tavolo.statoTavolo.LIBERO);}
    @Bean
    Tavolo tavolo5() {return new Tavolo(5,2, Tavolo.statoTavolo.OCCUPATO);}

    @Bean
    public ArrayList<Tavolo> tavoli() {
        ArrayList<Tavolo> tavoli = new ArrayList<>();
        tavoli.add(tavolo1());
        tavoli.add(tavolo2());
        tavoli.add(tavolo3());
        tavoli.add(tavolo4());
        tavoli.add(tavolo5());
        return tavoli;
    }

    @Bean
    public Menu menu() {
        Menu menu = new Menu();
        menu.addAlimento(pizzaMargherita());
        menu.addAlimento(pizzaMargheritaGrande());
        menu.addAlimento(pizzaHawaii());
        menu.addAlimento(pizzaSalame());
        menu.addAlimento(pizzaDiavola());
        menu.addAlimento(limonata03());
        menu.addAlimento(acqua());
        menu.addAlimento(vino());
        menu.addAlimento(pomodoro());
        menu.addAlimento(mozzarella());
        menu.addAlimento(cipolla());
        menu.addAlimento(ananas());
        menu.addAlimento(prosciutto());
        menu.addAlimento(salame());
        menu.addAlimento(ventricinaPiccante());
        menu.addAlimento(extraMozzarella());
        return menu;
    }
}

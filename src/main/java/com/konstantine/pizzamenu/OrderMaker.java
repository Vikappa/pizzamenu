package com.konstantine.pizzamenu;

import com.konstantine.pizzamenu.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

//@Component
public class OrderMaker implements CommandLineRunner {

    @Value("${ordine.costoCoperto}")
    private double costoCoperto;
    @Autowired
    private Menu menu;
    @Autowired
    ArrayList<Tavolo> tavoli;

    @Override
    public void run(String... args) throws Exception {
                try (Scanner scanner = new Scanner(System.in)) {
                    boolean continua = true;
                    while (continua) {
                        System.out.println("Scegli un'opzione:");
                        System.out.println("1. Visualizza il menu");
                        System.out.println("2. Visualizza i tavoli");
                        System.out.println("3. Crea un nuovo ordine");
                        System.out.println("0. Esci");

                        String scelta = scanner.nextLine();
                        switch (scelta) {
                            case "1":
                                menu.stampaMenu();
                                break;
                            case "2":
                                tavoli.forEach(tavolo -> System.out.println("Tavolo numero: " + tavolo.getNumeroTavolo() + " - Stato: " + tavolo.getStatoTavolo()));
                                break;
                            case "3":
                                System.out.println("Scegli un tavolo libero:");
                                tavoli.stream()
                                        .filter(tavolo -> tavolo.getStatoTavolo() == Tavolo.statoTavolo.LIBERO)
                                        .forEach(tavolo -> System.out.println("Tavolo numero: " + tavolo.getNumeroTavolo()));

                                int numeroTavolo = scanner.nextInt();
                                scanner.nextLine();
                                Tavolo tavoloScelto = tavoli.stream()
                                        .filter(tavolo -> tavolo.getNumeroTavolo() == numeroTavolo && tavolo.getStatoTavolo() == Tavolo.statoTavolo.LIBERO)
                                        .findFirst()
                                        .orElse(null);

                                if (tavoloScelto == null) {
                                    System.out.println("Numero di tavolo non valido o tavolo non è libero.");
                                    break;
                                }

                                Ordine ordine = new Ordine();
                                ordine.setTavoloOrdine(tavoloScelto);
                                ordine.setStatoOrdine(Ordine.StatoOrdine.IN_CORSO);

                                boolean aggiungiAlimenti = true;
                                while (aggiungiAlimenti) {
                                    menu.stampaMenuPerOrdinazioni();
                                    System.out.println("Digita il numero di un elemento da aggiungere all'ordine o 0 per concludere:");
                                    int sceltaAlimento = scanner.nextInt();
                                    scanner.nextLine();

                                    if (sceltaAlimento == 0) {
                                        aggiungiAlimenti = false;
                                    } else {
                                        Alimento alimentoScelto = menu.getAlimenti(sceltaAlimento);
                                        if (alimentoScelto != null) {
                                            ordine.addAlimento(alimentoScelto);
                                            System.out.println("Elemento aggiunto all'ordine.");
                                        } else {
                                            System.out.println("Selezione non valida.");
                                        }
                                    }
                                }

                                double costoTotale = ordine.calcolaConto(costoCoperto);
                                System.out.println("Ordine completato. Costo totale: €" + costoTotale);
                                tavoloScelto.setStatoTavolo(Tavolo.statoTavolo.OCCUPATO);
                                break;

                            case "0":
                                System.out.println("Uscita dall'applicazione.");
                                continua = false;
                                break;
                            default:
                                System.out.println("Scelta non valida.");
                                break;
                        }

                    }
            }
        }
    }

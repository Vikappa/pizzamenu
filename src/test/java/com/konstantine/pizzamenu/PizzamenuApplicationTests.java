package com.konstantine.pizzamenu;
import com.konstantine.pizzamenu.entities.Alimento;
import com.konstantine.pizzamenu.entities.Menu;
import com.konstantine.pizzamenu.entities.Ordine;
import com.konstantine.pizzamenu.entities.Tavolo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PizzamenuApplicationTests {

	@Autowired
	private Menu menu;

	@Autowired
	ArrayList<Tavolo> tavoli;

	@Value("${ordine.costoCoperto}")
	private double costoCoperto;

	@Test
	public void checkConfigCostoCoperto() {
        assertEquals(costoCoperto, 1.5);
    }

	@Test
	public void testStringaAlimenti() {
		// Salva il vecchio System.out
		PrintStream oldOut = System.out;

		// Crea un nuovo stream di output per catturare l'output
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		try {
			// Esegue il metodo che stampa al System.out
			menu.stampaMenu();
		} finally {
			// Ripristina il vecchio System.out
			System.setOut(oldOut);
		}

		// Converte l'output catturato in una stringa, poi conta le righe
		String printedOutput = outContent.toString();
		long lineCount = printedOutput.lines().count();
		System.out.println("Il metodo stampaMenu() ha stampato " + lineCount + " righe. Il menu è composto di " + menu.getMenuArrayList().size() + " elementi");


		// Asserzione per verificare il numero di righe stampate
		assertEquals(menu.getMenuArrayList().size(), lineCount);
	}


	@Test
    public void testStampaMenuPerOrdinazioni() {

			// Salva il vecchio System.out
			PrintStream oldOut = System.out;

			// Crea un nuovo stream di output per catturare l'output
			ByteArrayOutputStream outContent = new ByteArrayOutputStream();
			System.setOut(new PrintStream(outContent));

			try {
				// Esegue il metodo che stampa al System.out
				menu.stampaMenuPerOrdinazioni();
			} finally {
				// Ripristina il vecchio System.out
				System.setOut(oldOut);
			}
			// Converte l'output catturato in una stringa, poi conta le righe
			String printedOutput = outContent.toString();
			long lineCount = printedOutput.lines().count();

			System.out.println("Il metodo stampaMenuPerOrdinazioni() ha stampato " + lineCount + " righe.");

			// Asserzione per verificare il numero di righe stampate
		assertEquals(8, lineCount);

		}


    @Test
	public void testCalcolaOrdine() {
		Ordine ordine = new Ordine();

		ordine.addAlimento(menu.getAlimenti(1));
		ordine.addAlimento(menu.getAlimenti(2));
		ordine.addAlimento(menu.getAlimenti(3));
		ordine.setTavoloOrdine(tavoli.get(0));

		Alimento alimento1 = menu.getAlimenti(1);
		Alimento alimento2 = menu.getAlimenti(2);
		Alimento alimento3 = menu.getAlimenti(3);

		double costoOrdine = (tavoli.get(0).getPosti() * costoCoperto) + (alimento1.getPrezzo() + alimento2.getPrezzo() + alimento3.getPrezzo());

		assertEquals(costoOrdine, ordine.calcolaConto(costoCoperto));
	}



}

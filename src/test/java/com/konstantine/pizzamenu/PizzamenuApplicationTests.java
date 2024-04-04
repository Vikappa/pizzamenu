package com.konstantine.pizzamenu;
import com.konstantine.pizzamenu.entities.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PizzamenuApplicationTests {

	@Autowired
	private Menu menu;

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




}

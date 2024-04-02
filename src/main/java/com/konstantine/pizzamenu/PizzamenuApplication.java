package com.konstantine.pizzamenu;

import com.konstantine.pizzamenu.entities.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class PizzamenuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzamenuApplication.class);
				Menu menu = ctx.getBean(Menu.class);
				        menu.stampaMenu();
	}


}
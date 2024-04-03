package com.konstantine.pizzamenu;

import com.konstantine.pizzamenu.entities.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class PizzamenuApplication {


	public static void main(String[] args) {
		SpringApplication.run(PizzamenuApplication.class, args);
		SpringApplication.run(OrderMaker.class, args);
	}

}
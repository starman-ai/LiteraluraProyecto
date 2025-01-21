package com.alura.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal de la aplicacion Literalura.
 * Configura y ejecuta la aplicacion Spring Boot.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.alura.literalura")
public class literaluraApplication implements CommandLineRunner {

	// Inyección de dependencia para la clase Principal.
	@Autowired
	private final com.alura.literalura.principal.Principal principal;

	/**
	 * Constructor de la clase literaluraApplication.
	 * Inicializa la aplicacion con una instancia de Principal.
	 *
	 * @param principal Instancia de la clase Principal inyectada automaticamente.
	 */
	public literaluraApplication(com.alura.literalura.principal.Principal principal) {
		this.principal = principal;
	}

	/**
	 * Metodo principal que inicia la aplicacion Spring Boot.
	 *
	 * @param args Argumentos de la linea de comandos.
	 */
	public static void main(String[] args) {
		SpringApplication.run(literaluraApplication.class, args);
	}

	/**
	 * Metodo que se ejecuta automaticamente después de que la aplicacion ha iniciado.
	 * Aqui se llama al metodo mostrarMenu() de la clase Principal1 para mostrar
	 * el menu principal de la aplicación.
	 *
	 * @param args Argumentos de la linea de comandos.
	 * @throws Exception Si ocurre algun error durante la ejecucion.
	 */
	@Override
	public void run(String... args) throws Exception {
		principal.mostrarMenu();
	}
}

package compiladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

	public static String pila = "ɅS";
	public static int k = 0;
	Scanner entrada = new Scanner(System.in);
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	public static void main(String args[]) throws IOException {
		
		String O;
		int op;

		while (true) {

			// Basura
			System.out.println("\n\n-- Bienvenido compañero de la CUR --");
			System.out.println("\n\n-- Menu de opciones del Analizador de Cadena --");
			// Opciones
			System.out.println("\n1. Validar Cadena");
			System.out.println("\n2. Salir del programa");
			// Eleccion
			System.out.print("\nDigite opcion -> ");
			
			O = br.readLine();
			op = Integer.parseInt(O);

			if (op == 1) {
				//Llama al metodo para ejecutar el programa
				compiladores.Funcionalidad.analizador();
			}
			if (op == 3) {
				// Se sale de este chocoro
				System.out.println("\n\n FIN..\n\n");
				break;
			}

		}
		
	

	}
	
			
}
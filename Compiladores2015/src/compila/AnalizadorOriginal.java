package compila;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AnalizadorOriginal {

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
				analizador();
			}
			if (op == 3) {
				// Se sale de este chocoro
				System.out.println("\n\n FIN..\n\n");
				break;
			}

		}
		
	

	}
	
	public static void analizador() throws IOException{
		
		String cadena = ""; // cadena que se ingresa para validar
		String[] spl; // valida que haya identificador variables Iv (se ve mas adelante)
		String l1 = ""; // guarda los tokens de la cadena para validarlo con los simbolos de la pila
		
		System.out.println("\n Por favor ingresar la cadena a validar -> ");
		
		cadena = br.readLine(); // captura la cadena
		
		cadena = cadena.substring(0).replace(" ", ""); // Esto quita los espacios que se vayan por accidente en la cadena, ya que
		
		spl = cadena.split("="); // separa la cadena cuando encuentre el primero igual

		// Valida que si haya identificador variables en caso de que el tamaño del vector spl sea menor que 2 quiere decir que no hay igual (=) //
		
		if (spl.length < 2) 
		{
			System.out.println(cadena + " \n No cumple los criterios minimos: Se rechaza la cadena ingreada \n");
			return;
		} else {
			
// ----------------------------------------------------------------------------------------------------------------------------------//
			
			while (k < cadena.length()) {
				
				l1 = "" + cadena.charAt(k);
				
				if (pila.substring(pila.length() - 1).equalsIgnoreCase("S")) 
				{compila.Metodos.replaceR("D", "=", "I");} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("I")) 
				{compila.Metodos.desapileA();}
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("D")) 	
				{
					if (l1.equals("=")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("+")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("-")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("*")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("/")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals(")")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("¬")) {compila.Metodos.error(cadena);return;}
					else {compila.Metodos.replaceR("V", "T", "");}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("V")) 
				{ 
					if (l1.equals("=")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("*")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("/")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("(")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("+")) {compila.Metodos.replaceA("V", "T");}
					else if (l1.equals("-")) {compila.Metodos.replaceA("V", "T");}
					else if (l1.equals(")")) {compila.Metodos.desapileR();} 
					else if (l1.equals("¬")) {compila.Metodos.desapileR();}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("T")) 
					
				{	
					if (l1.equals("=")) {compila.Metodos.error(cadena);	return;}
					else if (l1.equals("+")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("-")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("*")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("/")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals(")")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("¬")) {compila.Metodos.error(cadena);return;} 
					else {compila.Metodos.replaceR("Q", "P", "");}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("P")) 
				
				{
					if (l1.equals("=")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("+")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("-")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("*")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("/")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals(")")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("¬")) {compila.Metodos.error(cadena);return;} 
					else{compila.Metodos.replaceR("Y", "", "");}
				}
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Q")) 
				
				{	
					if (l1.equals("*")) { compila.Metodos.replaceA("Q", "P");} 
					else if (l1.equals("/")) {compila.Metodos.replaceA("Q", "P");} 
					else if (l1.equals("+")) {compila.Metodos.desapileR();} 
					else if (l1.equals("-")) {compila.Metodos.desapileR();}
					else if (l1.equals(")")) {compila.Metodos.desapileR();}
					else if (l1.equals("¬")) {compila.Metodos.desapileR();}
					else {compila.Metodos.error(cadena);return;}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Y")) 
				{ 
					if 		(l1.equals("(")) {compila.Metodos.replaceA(")", "D");}
					else if (l1.equals("=")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("+")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("-")) {compila.Metodos.error(cadena);return;}
					else if (l1.equals("*")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("/")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals(")")) {compila.Metodos.error(cadena);return;} 
					else if (l1.equals("¬")) {compila.Metodos.error(cadena);return;} 
					else {compila.Metodos.desapileA();}
				} 
		
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("="))
				
				{
					if (l1.equals("=")) {compila.Metodos.desapileA();} 
					else {compila.Metodos.error(cadena);return;}
				} 
				
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase(")")) 
				
				{ 
					
					if (l1.equals(")")) 
					{ 
						compila.Metodos.desapileA(); 
					} 
					else 
					{
						compila.Metodos.error(cadena); 
						return;
					}
				}
				
				k++;
			
			}
			
			// --------------------------------------------------------------------------------//
			
			if (pila.length() < 2) 
			{
				compila.Metodos.aceptacion(cadena);
			} else 
			{
				compila.Metodos.error(cadena);
			}
		}
		
	}
			
}
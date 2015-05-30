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
			
			// ciclo para validar la cadena ingresada con los simbolos de la pila y simbolos de entrada//
			while (k < cadena.length()) { // mientras que k sea menor que el tamaño de la cadena...

				l1 = "" + cadena.charAt(k); // guardamos cada token de la cadena
				
				if (pila.substring(pila.length() - 1).equalsIgnoreCase("S")) 
				{compila.metodos.replaceR("D", "=", "I");} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("I")) 
				{compila.metodos.desapileA();}
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("D")) 	
				{
					if 		(l1.equals("=")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("+")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("-")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("*")) {compila.metodos.error(cadena);return;} 
					else if (l1.equals("/")) {compila.metodos.error(cadena);return;} 
					else if (l1.equals(")")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("¬")) {compila.metodos.error(cadena);return;}
					// Si ninguna de las anteriores validaciones fue correcta, reemplazamoos el tope de la pila por VT (ɅVT)
					else {compila.metodos.replaceR("V", "T", "");}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("V")) 
				{ // preguntamos si el simbolo de la pila en que estamos es V Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					if (l1.equals("=")) {
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("*")) {
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("/")) {
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("(")) {
						compila.metodos.error(cadena);
						return;
		
						
					} else if (l1.equals("+")) 
					{ // Si el simbolo que viene es +
						compila.metodos.replaceA("V", "T"); // Se reemplaza el tope de la pila por VT y avanza (ɅVT)
					} else if (l1.equals("-")) 
					{ // Si el simbolo que viene es -
						compila.metodos.replaceA("V", "T"); // Se reemplaza el tope de la pila por VT y avanza (ɅVT)
					} else if (l1.equals(")")) 
					{ // Si el simbolo que viene es )
						compila.metodos.desapileR(); // Desapilla el tope y retiene (ɅV)
					} else if (l1.equals("¬")) 
					{ // Si el simbolo que viene es ¬
						compila.metodos.desapileR(); // Desapilla el tope y retiene (ɅV)
					}
					
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("T")) 
					
				{ // preguntamos si el simbolo de la pila en que estamos es T
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					
					if (l1.equals("=")) 
					{
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("+")) 
					{
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("-")) 
					{
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("*"))
					{
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("/")) 
					{
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals(")")) 
					{
						compila.metodos.error(cadena);
						return;
					} else if (l1.equals("¬")) 
					
					{
						compila.metodos.error(cadena);
						return;
						
						// ---------------------------------------------------------------------------//
					} 
					
					else 
					
					{
						compila.metodos.replaceR("Q", "P", ""); // Se reemplaza el tope de la pila por VT y retiene (ɅVQP)
					}
				} 
				
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("P")) 
				
				{ // preguntamos si el simbolo de la pila en que estamos es P
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					if (l1.equals("=")) {
						compila.metodos.error(cadena);
						return;
					} 
					
					else if (l1.equals("+")) {
						compila.metodos.error(cadena);
						return;
					} 
					
					else if (l1.equals("-")) {
						compila.metodos.error(cadena);
						return;
					} 
					
					else if (l1.equals("*")) {
						compila.metodos.error(cadena);
						return;
					} 
					
					else if (l1.equals("/")) {
						compila.metodos.error(cadena);
						return;
					} 
					
					else if (l1.equals(")")) {
						compila.metodos.error(cadena);
						return;
					} 
					
					else if (l1.equals("¬")) {
						compila.metodos.error(cadena);
						return;
						
						// ---------------------------------------------------------------------------//
					} 
					
					else
					
					{
						compila.metodos.replaceR("Y", "", ""); // Se reemplaza el tope de la pila por Y (en la notas es II yo lo llame Y para mejor manejo) y retiene (ɅVQY) ||(ɅVQII)
					}
				}
				
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Q")) 
				
				{ // preguntamos si el simbolo de la pila en que estamos es Q
					
					if (l1.equals("*")) 
					{ // Si el simbolo que viene es *
						compila.metodos.replaceA("Q", "P"); // Se reemplaza el tope de la pila por QP y avanza (ɅVQP)
					} 
					
					else if (l1.equals("/")) 
					
					{ // Si el simbolo que viene es /
						compila.metodos.replaceA("Q", "P"); // Se reemplaza el tope de la pila por QP y avanza (ɅVQP)
					} 
					
					else if (l1.equals("+")) 
					
					{ // Si el simbolo que viene es +
						compila.metodos.desapileR(); // Se desapila el tope y retiene
					} 
					
					else if (l1.equals("-")) 
					
					{ // Si el simbolo que viene es -
						compila.metodos.desapileR(); // Se desapila el tope y retiene
					} 
					
					else if (l1.equals(")")) 
					
					{ // Si el simbolo que viene es )
						compila.metodos.desapileR(); // Se desapila el tope y retiene
					}
					
					else if (l1.equals("¬")) 
					
					{ // Si el simbolo que viene es ¬
						compila.metodos.desapileR(); // Se desapila el tope y retiene
					}
					
					else 
					
					{
						compila.metodos.error(cadena); // Si no es ninguna de la validaciones anteriores es error
						return;
					}
				} 
				
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Y")) 
				{ 
					if (l1.equals("(")) {compila.metodos.replaceA(")", "D");}
					else if (l1.equals("=")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("+")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("-")) {compila.metodos.error(cadena);return;}
					else if (l1.equals("*")) {compila.metodos.error(cadena);return;} 
					else if (l1.equals("/")) {compila.metodos.error(cadena);return;} 
					else if (l1.equals(")")) {compila.metodos.error(cadena);return;} 
					else if (l1.equals("¬")) {compila.metodos.error(cadena);return;} 
					// si no es ninguna de las validaciones anteriores desapila el tope y avanza (ɅVQ))
					else{compila.metodos.desapileA();}
				} 
		
				
				else if 
				
				(pila.substring(pila.length() - 1).equalsIgnoreCase("="))
				
				{ // preguntamos si el simbolo de la pila en que estamos es =
					if (l1.equals("=")) 
					
					{// Si el simbolo que viene en =
						compila.metodos.desapileA(); // Desapile el tope y avance (ɅVQ)
					} 
					
					else 
					
					{
						compila.metodos.error(cadena);// si no es igual (=) debe mandar un error diciendo que la cadena es de rechazo
						return;
					}
				} 
				
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase(")")) 
				
				{ // preguntamos si el simbolo de la pila en que estamos es )
					
					if (l1.equals(")")) 
					{ // Si el simbolo que viene es )
						compila.metodos.desapileA(); // Desapila el tope y avanza (ɅV)
					} 
					else 
					{
						compila.metodos.error(cadena); // si no es parentesis ()) debe mandar un error diciendo que la cadena es de rechazo
						return;
					}
				}
				
				k++; // variable para aumentar el ciclo de la cadena
			}
			// --------------------------------------------------------------------------------//
			
			if (pila.length() < 2) 
			{
				compila.metodos.aceptacion(cadena);
			} else 
			{
				compila.metodos.error(cadena);
			}
		}
		
	}
			
}
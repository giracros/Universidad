package compiladores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Funcionalidad {
		
	public static String pila = "ɅS";
	public static int k = 0;
	Scanner entrada = new Scanner(System.in);
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
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
				{compiladores.Funcionalidad.replaceR("D", "=", "I");} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("I")) 
				{compiladores.Funcionalidad.desapileA();}
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("D")) 	
				{
					if (l1.equals("=")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("+")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("-")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("*")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("/")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals(")")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("¬")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else {compiladores.Funcionalidad.replaceR("V", "T", "");}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("V")) 
				{ 
					if (l1.equals("=")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("*")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("/")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("(")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("+")) {compiladores.Funcionalidad.replaceA("V", "T");}
					else if (l1.equals("-")) {compiladores.Funcionalidad.replaceA("V", "T");}
					else if (l1.equals(")")) {compiladores.Funcionalidad.desapileR();} 
					else if (l1.equals("¬")) {compiladores.Funcionalidad.desapileR();}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("T")) 
					
				{	
					if (l1.equals("=")) {compiladores.Funcionalidad.rechazo(cadena);	return;}
					else if (l1.equals("+")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("-")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("*")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("/")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals(")")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("¬")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else {compiladores.Funcionalidad.replaceR("Q", "P", "");}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("P")) 
				
				{
					if (l1.equals("=")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("+")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("-")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("*")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("/")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals(")")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("¬")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else{compiladores.Funcionalidad.replaceR("Y", "", "");}
				}
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Q")) 
				
				{	
					if (l1.equals("*")) { compiladores.Funcionalidad.replaceA("Q", "P");} 
					else if (l1.equals("/")) {compiladores.Funcionalidad.replaceA("Q", "P");} 
					else if (l1.equals("+")) {compiladores.Funcionalidad.desapileR();} 
					else if (l1.equals("-")) {compiladores.Funcionalidad.desapileR();}
					else if (l1.equals(")")) {compiladores.Funcionalidad.desapileR();}
					else if (l1.equals("¬")) {compiladores.Funcionalidad.desapileR();}
					else {compiladores.Funcionalidad.rechazo(cadena);return;}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Y")) 
				{ 
					if 		(l1.equals("(")) {compiladores.Funcionalidad.replaceA(")", "D");}
					else if (l1.equals("=")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("+")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("-")) {compiladores.Funcionalidad.rechazo(cadena);return;}
					else if (l1.equals("*")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("/")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals(")")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else if (l1.equals("¬")) {compiladores.Funcionalidad.rechazo(cadena);return;} 
					else {compiladores.Funcionalidad.desapileA();}
				} 
		
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("="))
				
				{
					if (l1.equals("=")) {compiladores.Funcionalidad.desapileA();} 
					else {compiladores.Funcionalidad.rechazo(cadena);return;}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase(")")) 
				
				{ 	
					if (l1.equals(")")) {compiladores.Funcionalidad.desapileA(); } 
					else {compiladores.Funcionalidad.rechazo(cadena); return;}
				}
				
				k++;
			
			}
			
			// --------------------------------------------------------------------------------//
			
			if (pila.length() < 2) 
			{
				compiladores.Funcionalidad.aceptacion(cadena);
			} else 
			{
				compiladores.Funcionalidad.rechazo(cadena);
			}
		}
		
	}
	public static void replaceR(String l1, String l2, String opci) 
	{
		if (!opci.equals("")) 
		{
			compiladores.Menu.pila = compiladores.Menu.pila.charAt(0) + l1 + l2 + opci;
		} 
		else if (l2.equals("")) 
		{
			compiladores.Menu.pila = compiladores.Menu.pila.substring(0, compiladores.Menu.pila.length() - 1) + l1;
		}
		else 
		{
			compiladores.Menu.pila = compiladores.Menu.pila.substring(0, compiladores.Menu.pila.length() - 1) + l1 + l2;
		}
		compiladores.Menu.k--;
		
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void replaceA(String l1, String l2) 
	{
		compiladores.Menu.pila = compiladores.Menu.pila.substring(0, compiladores.Menu.pila.length() - 1) + l1 + l2;
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void desapileR() 
	{
		compiladores.Menu.pila = compiladores.Menu.pila.substring(0, compiladores.Menu.pila.length() - 1);
		compiladores.Menu.k--;
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void desapileA() 
	{
		compiladores.Menu.pila = compiladores.Menu.pila.substring(0, compiladores.Menu.pila.length() - 1);
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void rechazo(String cadena) 
	{
		System.out.println(cadena + " = Rechazo");
		//lblResultado.setText("Aceptacion");
	}

	public static void aceptacion(String cadena) 
	{
		System.out.println(cadena + " = Aceptacion");
	}
}

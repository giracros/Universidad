package compiladores;

import java.io.IOException;


public class Funcionalidad {
		
	public static int k = 0;
	public static String pila = "ɅS";
	
	public static void aceptacion(String cadena) 
	{
		compiladores.FrmMenu.getTxtResultado().setText("Aceptacion");
	}
	
	public static void analizador() throws IOException{
		
		String[] spl; // valida que haya identificador variables Iv (se ve mas adelante)
		String l1 = ""; // guarda los tokens de la cadena para validarlo con los simbolos de la pila
		String cadena=compiladores.FrmMenu.getTxtValidar().getText();
		@SuppressWarnings("unused")
		int tamano=cadena.length();
		cadena = cadena.substring(0).replace(" ", ""); // Esto quita los espacios que se vayan por accidente en la cadena, ya que
		
		spl = cadena.split("="); // separa la cadena cuando encuentre el primero igual

		// Valida que si haya identificador variables en caso de que el tamaño del vector spl sea menor que 2 quiere decir que no hay igual (=) //
		
		if (spl.length < 2) 
		{
			compiladores.FrmMenu.getTxtPasos().setText("Invalido");
			return;
		} else {
			
// ----------------------------------------------------------------------------------------------------------------------------------//
			
			while (k < cadena.length()) {
				
				l1 = "" + cadena.charAt(k);
				
				if (pila.substring(pila.length() - 1).equalsIgnoreCase("S")) 
				{replaceR("D", "=", "I");} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("I")) 
				{desapileA();}
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("D")) 	
				{
					if (l1.equals("=")) {rechazo(cadena);return;}
					else if (l1.equals("+")) {rechazo(cadena);return;}
					else if (l1.equals("-")) {rechazo(cadena);return;}
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;} 
					else if (l1.equals(")")) {rechazo(cadena);return;}
					else if (l1.equals("¬")) {rechazo(cadena);return;}
					else {replaceR("V", "T", "");}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("V")) 
				{ 
					if (l1.equals("=")) {rechazo(cadena);return;} 
					else if (l1.equals("*")) {rechazo(cadena);return;}
					else if (l1.equals("/")) {rechazo(cadena);return;}
					else if (l1.equals("(")) {rechazo(cadena);return;}
					else if (l1.equals("+")) {replaceA("V", "T");}
					else if (l1.equals("-")) {replaceA("V", "T");}
					else if (l1.equals(")")) {desapileR();} 
					else if (l1.equals("¬")) {desapileR();}
				} 
				
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("T")) 
					
				{	
					if (l1.equals("=")) {rechazo(cadena);	return;}
					else if (l1.equals("+")) {rechazo(cadena);return;}
					else if (l1.equals("-")) {rechazo(cadena);return;}
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;}
					else if (l1.equals(")")) {rechazo(cadena);return;}
					else if (l1.equals("¬")) {rechazo(cadena);return;} 
					else {replaceR("Q", "P", "");}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("P")) 
				
				{
					if (l1.equals("=")) {rechazo(cadena);return;} 
					else if (l1.equals("+")) {rechazo(cadena);return;} 
					else if (l1.equals("-")) {rechazo(cadena);return;} 
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;} 
					else if (l1.equals(")")) {rechazo(cadena);return;} 
					else if (l1.equals("¬")) {rechazo(cadena);return;} 
					else{replaceR("Y", "", "");}
				}
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Q")) 
				
				{	
					if (l1.equals("*")) { replaceA("Q", "P");} 
					else if (l1.equals("/")) {replaceA("Q", "P");} 
					else if (l1.equals("+")) {desapileR();} 
					else if (l1.equals("-")) {desapileR();}
					else if (l1.equals(")")) {desapileR();}
					else if (l1.equals("¬")) {desapileR();}
					else {rechazo(cadena);return;}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Y")) 
				{ 
					if 		(l1.equals("(")) {replaceA(")", "D");}
					else if (l1.equals("=")) {rechazo(cadena);return;}
					else if (l1.equals("+")) {rechazo(cadena);return;}
					else if (l1.equals("-")) {rechazo(cadena);return;}
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;} 
					else if (l1.equals(")")) {rechazo(cadena);return;} 
					else if (l1.equals("¬")) {rechazo(cadena);return;} 
					else {desapileA();}
				} 
		
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("="))
				
				{
					if (l1.equals("=")) {desapileA();} 
					else {rechazo(cadena);return;}
				} 
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase(")")) 
				
				{ 	
					if (l1.equals(")")) {desapileA(); } 
					else {rechazo(cadena); return;}
				}
				
				k++;
			
			}
			
			// --------------------------------------------------------------------------------//
			
			if (pila.length() < 2) 
			{
				aceptacion(cadena);
			} else 
			{
				rechazo(cadena);
			}
		}
		
	}

	public static void desapileA() 
	{
		pila = pila.substring(0, pila.length() - 1);
		compiladores.FrmMenu.getTxtPasos().setText(pila);
	}

	public static void desapileR() 
	{
		pila = pila.substring(0, pila.length() - 1);
		k--;
		compiladores.FrmMenu.getTxtPasos().setText(pila);
	}

	public static void rechazo(String cadena) 
	{
		compiladores.FrmMenu.getTxtResultado().setText("Rechazo");
	}

	public static void replaceA(String l1, String l2) 
	{
		pila = pila.substring(0, pila.length() - 1) + l1 + l2;
		compiladores.FrmMenu.getTxtPasos().setText(pila);
	}

	public static void replaceR(String l1, String l2, String opcion) 
	{
		if (!opcion.equals("")) 
		{
			pila = pila.charAt(0) + l1 + l2 + opcion;
		} 
		else if (l2.equals("")) 
		{
			pila = pila.substring(0, pila.length() - 1) + l1;
		}
		else 
		{
			pila = pila.substring(0, pila.length() - 1) + l1 + l2;
		}
		k--;
		
		compiladores.FrmMenu.getTxtPasos().setText(pila);
	}
}

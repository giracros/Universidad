package compila;


public class metodos {
	

	public static void replaceR(String l1, String l2, String opci) 
	{
		if (!opci.equals("")) 
		{
			compila.AnalizadorOriginal.pila = compila.AnalizadorOriginal.pila.charAt(0) + l1 + l2 + opci;
		} 
		else if (l2.equals("")) 
		{
			compila.AnalizadorOriginal.pila = compila.AnalizadorOriginal.pila.substring(0, compila.AnalizadorOriginal.pila.length() - 1) + l1;
		}
		else 
		{
			compila.AnalizadorOriginal.pila = compila.AnalizadorOriginal.pila.substring(0, compila.AnalizadorOriginal.pila.length() - 1) + l1 + l2;
		}
		compila.AnalizadorOriginal.k--;
		
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void replaceA(String l1, String l2) 
	{
		compila.AnalizadorOriginal.pila = compila.AnalizadorOriginal.pila.substring(0, compila.AnalizadorOriginal.pila.length() - 1) + l1 + l2;
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void desapileR() 
	{
		compila.AnalizadorOriginal.pila = compila.AnalizadorOriginal.pila.substring(0, compila.AnalizadorOriginal.pila.length() - 1);
		compila.AnalizadorOriginal.k--;
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void desapileA() 
	{
		compila.AnalizadorOriginal.pila = compila.AnalizadorOriginal.pila.substring(0, compila.AnalizadorOriginal.pila.length() - 1);
		//System.out.println(compila.AnalizadorOriginal.pila);
	}

	public static void error(String cadena) 
	{
		System.out.println(cadena + " = Rechazo");
	}

	public static void aceptacion(String cadena) 
	{
		System.out.println(cadena + " = Aceptacion");
	}
}

package compiladores;

import java.io.IOException;

import javax.swing.JOptionPane;


public class Funcionalidad {
		
	public static int k = 0;
	
	public static String pila = "ɅS";
	
	public static void analizador() throws IOException{
		
		String[] spl;
		
		String l1 = "";
		
		// Le paso la cadena que ingrese al textbox
		String cadena=compiladores.FrmMenu.getTxtValidar().getText();
		// Valida el tamaño de la cadena
		int tamano=cadena.length();
		//Remplaza los espacios en blanco que tenga la cadena que ingrese
		cadena = cadena.substring(0).replace(" ", "");
		// Para iniciar la validacion de la cadena esta debe ser igualada
		spl = cadena.split("=");
		//Si la longitud es menor a dor, genera un error en la cadena
		
		if (spl.length < 2) {compiladores.FrmMenu.getTxtResultado().setText("Rechazo");return;}
		
		// Si la longitud es mayor inicia la validacion de la pila
		else { while (k < cadena.length()) {
				
				l1 = "" + cadena.charAt(k); // Se guarda el token de la cadena
				
				// Preguntamos si el simbolo de la pila en que estamos es S
				if (pila.substring(pila.length() - 1).equalsIgnoreCase("S")) 
				{replaceR("D", "=", "I");
				JOptionPane.showMessageDialog(null, "Reemplazamos S por D=I (ɅD=I)");} // Reemplazamos S por D=I (ɅD=I)
				
				// Preguntamos si el simbolo de la pila en que estamos es I
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("I")) 
				{desapileA(); 
				JOptionPane.showMessageDialog(null, "Desapilamos I y Avanzamos (ɅD=)");} // Desapilamos I y Avanzamos (ɅD=)
				
				// Preguntamos si el simbolo de la pila en que estamos es D 
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("D")) 	
				{	
					JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es D ");
					
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					if (l1.equals("=")) {rechazo(cadena);return;}
					else if (l1.equals("+")) {rechazo(cadena);return;}
					else if (l1.equals("-")) {rechazo(cadena);return;}
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;} 
					else if (l1.equals(")")) {rechazo(cadena);return;}
					else if (l1.equals("¬")) {rechazo(cadena);return;}
					
					// Si ninguna de las anteriores validaciones fue correcta, reemplazamoos el tope de la pila por VT (ɅVT)
					else {replaceR("V", "T", "");
					JOptionPane.showMessageDialog(null, "Si ninguna de las anteriores validaciones fue correcta, reemplazamoos el tope de la pila por VT (ɅVT)");}
				} 
				
				// Preguntamos si el simbolo de la pila en que estamos es V
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("V")) 
				{ 
					JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es V ");
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					if (l1.equals("=")) {rechazo(cadena);return;} 
					else if (l1.equals("*")) {rechazo(cadena);return;}
					else if (l1.equals("/")) {rechazo(cadena);return;}
					else if (l1.equals("(")) {rechazo(cadena);return;}
					
					// Si el simbolo que viene es + Se reemplaza el tope de la pila por VT y avanza (ɅVT)
					else if (l1.equals("+")) {replaceA("V", "T");
					JOptionPane.showMessageDialog(null,"Si el simbolo que viene es + Se reemplaza el tope de la pila por VT y avanza (ɅVT)");}
					// Si el simbolo que viene es - Se reemplaza el tope de la pila por VT y avanza (ɅVT)
					else if (l1.equals("-")) {replaceA("V", "T");
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es - Se reemplaza el tope de la pila por VT y avanza (ɅVT)");}
					// Si el simbolo que viene es ) Desapilla el tope y retiene (ɅV)
					else if (l1.equals(")")) {desapileR();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es ) Desapilla el tope y retiene (ɅV)");} 
					// Si el simbolo que viene es ¬ Desapilla el tope y retiene (ɅV)
					else if (l1.equals("¬")) {desapileR();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es ¬ Desapilla el tope y retiene (ɅV)");}
				} 
				
				// Preguntamos si el simbolo de la pila en que estamos es T
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("T")) 
					
				{	JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es T ");
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					if (l1.equals("=")) {rechazo(cadena);return;}
					else if (l1.equals("+")) {rechazo(cadena);return;}
					else if (l1.equals("-")) {rechazo(cadena);return;}
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;}
					else if (l1.equals(")")) {rechazo(cadena);return;}
					else if (l1.equals("¬")) {rechazo(cadena);return;} 
					// Se reemplaza el tope de la pila por VT y retiene (ɅVQP)
					else {replaceR("Q", "P", "");
					JOptionPane.showMessageDialog(null, "Se reemplaza el tope de la pila por VT y retiene (ɅVQP)");
					}
				} 
				
				// Preguntamos si el simbolo de la pila en que estamos es P
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("P")) 
				
				{	JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es P ");
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					if (l1.equals("=")) {rechazo(cadena);return;} 
					else if (l1.equals("+")) {rechazo(cadena);return;} 
					else if (l1.equals("-")) {rechazo(cadena);return;} 
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;} 
					else if (l1.equals(")")) {rechazo(cadena);return;} 
					else if (l1.equals("¬")) {rechazo(cadena);return;} 
					// Se reemplaza el tope de la pila por Y y retiene (ɅVQY) ||(ɅVQII)
					else{replaceR("Y", "", "");
					JOptionPane.showMessageDialog(null, "Se reemplaza el tope de la pila por Y y retiene (ɅVQY) ||(ɅVQII)");
					}
				}
				
				// Preguntamos si el simbolo de la pila en que estamos es Q
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Q")) 
				
				{	JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es Q ");
					// Si el simbolo que viene es * Se reemplaza el tope de la pila por QP y avanza (ɅVQP)
					if (l1.equals("*")) { replaceA("Q", "P");
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es * Se reemplaza el tope de la pila por QP y avanza (ɅVQP)");
					} 
					// Si el simbolo que viene es / Se reemplaza el tope de la pila por QP y avanza (ɅVQP)
					else if (l1.equals("/")) {replaceA("Q", "P");
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es / Se reemplaza el tope de la pila por QP y avanza (ɅVQP)");
					} 
					// Si el simbolo que viene es + Se desapila el tope y retiene
					else if (l1.equals("+")) {desapileR();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es + Se desapila el tope y retiene");
					}
					// Si el simbolo que viene es - Se desapila el tope y retiene
					else if (l1.equals("-")) {desapileR();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es - Se desapila el tope y retiene");
					}
					// Si el simbolo que viene es ) Se desapila el tope y retiene
					else if (l1.equals(")")) {desapileR();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es ) Se desapila el tope y retiene");
					}
					 // Si el simbolo que viene es ¬ Se desapila el tope y retiene
					else if (l1.equals("¬")) {desapileR();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es ¬ Se desapila el tope y retiene");
					}
					// Si no se cumple la condicion dira que la cadena es de rechazo //
					else {rechazo(cadena);return;}
				} 
				
				// Preguntamos si el simbolo de la pila en que estamos es Y
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("Y")) 
				{ 
					JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es Y ");
					// Si el simbolo que viene es ( Se reemplaza el tope de la pila por )D y avanza (ɅVQ)D)
					if (l1.equals("(")) {replaceA(")", "D");
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es ( Se reemplaza el tope de la pila por )D y avanza (ɅVQ)D)");}
					// Si es alguno de los siguientes simbolos nos dira que la cadena es de rechazo //
					else if (l1.equals("=")) {rechazo(cadena);return;}
					else if (l1.equals("+")) {rechazo(cadena);return;}
					else if (l1.equals("-")) {rechazo(cadena);return;}
					else if (l1.equals("*")) {rechazo(cadena);return;} 
					else if (l1.equals("/")) {rechazo(cadena);return;} 
					else if (l1.equals(")")) {rechazo(cadena);return;} 
					else if (l1.equals("¬")) {rechazo(cadena);return;}
					
					// Si no es ninguna de las validaciones anteriores desapila el tope y avanza (ɅVQ))
					else {desapileA();
					JOptionPane.showMessageDialog(null, "Desapila el tope y avanza (ɅVQ))");}
				} 
		
				
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase("="))
				
				{	JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es = ");
					// Preguntamos si el simbolo de la pila en que estamos es = Desapile el tope y avance (ɅVQ)	
					if (l1.equals("=")) {desapileA();} 
					// Si no se cumple la condicion dira que la cadena es de rechazo //
					else {rechazo(cadena);return;}
				}
				
				// Preguntamos si el simbolo de la pila en que estamos es ) 
				else if (pila.substring(pila.length() - 1).equalsIgnoreCase(")")) 
				
				{ 	
					JOptionPane.showMessageDialog(null, "Preguntamos si el simbolo de la pila en que estamos es ) ");
					// Si el simbolo que viene es ) Desapila el tope y avanza (ɅV)
					if (l1.equals(")")) {desapileA();
					JOptionPane.showMessageDialog(null, "Si el simbolo que viene es ) Desapila el tope y avanza (ɅV) "); } 
					// Si no se cumple la condicion dira que la cadena es de rechazo //
					else {rechazo(cadena); return;}
				}
				
				k++; // Variable que aumentar el ciclo de la cadena
			
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

	public static void aceptacion(String cadena) 
	{
		compiladores.FrmMenu.getTxtResultado().setText("Aceptacion");
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
			compiladores.FrmMenu.getTxtPasos().setText(pila);
		} 
		else if (l2.equals("")) 
		{
			pila = pila.substring(0, pila.length() - 1) + l1;
			compiladores.FrmMenu.getTxtPasos().setText(pila);
		}
		else 
		{
			pila = pila.substring(0, pila.length() - 1) + l1 + l2;
			compiladores.FrmMenu.getTxtPasos().setText(pila);
		}
		k--;
		
		compiladores.FrmMenu.getTxtPasos().setText(pila);
	}

}

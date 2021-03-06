package cosas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class metodos {
	public static int k = 0; // validacion de ciclo
	public static String pila = "ɅS"; // Pila con condición inicial

	public static void anuar() throws IOException {

		// ------------- //
		String[] spl; 
		String l1 = "";
		String cadena=cosas.frm.getTxtIngresar().getText();
		int tamano=cadena.length();
		cadena = cadena.substring(0).replace(" ", ""); // quita los espacios que
														// hay entre la cadena
		spl = cadena.split("="); // separa la cadena cuando encuentre el primero
									// igual
		// valida que si haya identificador variables en caso de que el tamaño
		// del vector spl sea menor que 2 quiere decir que no hay igual (=)//
		if (spl.length < 2) {
			cosas.frm.getTxtDato().setText("Rechazo");
			return;
		} else {
			// ----------------------------------------------------------------------------------------------------------------------------------
			// //
			// ciclo para validar la cadena ingresada con los simbolos de la
			// pila y simbolos de entrada//
			while (k < cadena.length()) { // mientras que k sea menor que el
											// tamaño de la cadena...

				l1 = "" + cadena.charAt(k); // guardamos cada token de la cadena
				if (pila.substring(pila.length() - 1).equalsIgnoreCase("S")) { // preguntamos
																				// si
																				// el
																				// simbolo
																				// de
																				// la
																				// pila
																				// en
																				// que
																				// estamos
																				// es
																				// S
					replaceR("D", "=", "I"); // reemplazamos s por D=I (ɅD=I)
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"I")) { // preguntamos si el simbolo de la pila en que
								// estamos es I
					desapileA(); // desapilamos I y avanzamos (ɅD=)
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"D")) { // preguntamos si el simbolo de la pila en que
								// estamos es D
					// Si es alguno de los siguientes simbolos nos dira que la
					// cadena es de rechazo //
					// Nota: Error es un metodo que imprime la cadena de
					// rechazo, al final se explica mejor//
					if (l1.equals("=")) {
						error(cadena);
						return;
					} else if (l1.equals("+")) {
						error(cadena);
						return;
					} else if (l1.equals("-")) {
						error(cadena);
						return;
					} else if (l1.equals("*")) {
						error(cadena);
						return;
					} else if (l1.equals("/")) {
						error(cadena);
						return;
					} else if (l1.equals(")")) {
						error(cadena);
						return;
					} else if (l1.equals("¬")) {
						error(cadena);
						return;
						// ---------------------------------------------------------------------------
						// //
					} else {
						replaceR("V", "T", ""); // Si ninguna de las anteriores
												// validaciones fue correcta,
												// reemplazamoos el tope de la
												// pila por VT (ɅVT)
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"V")) { // preguntamos si el simbolo de la pila en que
								// estamos es V
					// Si es alguno de los siguientes simbolos nos dira que la
					// cadena es de rechazo //
					if (l1.equals("=")) {
						error(cadena);
						return;
					} else if (l1.equals("*")) {
						error(cadena);
						return;
					} else if (l1.equals("/")) {
						error(cadena);
						return;
					} else if (l1.equals("(")) {
						error(cadena);
						return;
						// ---------------------------------------------------------------------------
						// //
					} else if (l1.equals("+")) { // Si el simbolo que viene es +
						replaceA("V", "T"); // Se reemplaza el tope de la pila
											// por VT y avanza (ɅVT)
					} else if (l1.equals("-")) { // Si el simbolo que viene es -
						replaceA("V", "T"); // Se reemplaza el tope de la pila
											// por VT y avanza (ɅVT)
					} else if (l1.equals(")")) { // Si el simbolo que viene es )
						desapileR(); // Desapilla el tope y retiene (ɅV)
					} else if (l1.equals("¬")) { // Si el simbolo que viene es ¬
						desapileR(); // Desapilla el tope y retiene (ɅV)
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"T")) { // preguntamos si el simbolo de la pila en que
								// estamos es T
					// Si es alguno de los siguientes simbolos nos dira que la
					// cadena es de rechazo //
					if (l1.equals("=")) {
						error(cadena);
						return;
					} else if (l1.equals("+")) {
						error(cadena);
						return;
					} else if (l1.equals("-")) {
						error(cadena);
						return;
					} else if (l1.equals("*")) {
						error(cadena);
						return;
					} else if (l1.equals("/")) {
						error(cadena);
						return;
					} else if (l1.equals(")")) {
						error(cadena);
						return;
					} else if (l1.equals("¬")) {
						error(cadena);
						return;
						// ---------------------------------------------------------------------------
						// //
					} else {
						replaceR("Q", "P", ""); // Se reemplaza el tope de la
												// pila por VT y retiene (ɅVQP)
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"P")) { // preguntamos si el simbolo de la pila en que
								// estamos es P
					// Si es alguno de los siguientes simbolos nos dira que la
					// cadena es de rechazo //
					if (l1.equals("=")) {
						error(cadena);
						return;
					} else if (l1.equals("+")) {
						error(cadena);
						return;
					} else if (l1.equals("-")) {
						error(cadena);
						return;
					} else if (l1.equals("*")) {
						error(cadena);
						return;
					} else if (l1.equals("/")) {
						error(cadena);
						return;
					} else if (l1.equals(")")) {
						error(cadena);
						return;
					} else if (l1.equals("¬")) {
						error(cadena);
						return;
						// ---------------------------------------------------------------------------
						// //
					} else {
						replaceR("Y", "", ""); // Se reemplaza el tope de la
												// pila por Y (en la notas es II
												// yo lo llame Y para mejor
												// manejo) y retiene (ɅVQY) ||
												// (ɅVQII)
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"Q")) { // preguntamos si el simbolo de la pila en que
								// estamos es Q
					if (l1.equals("*")) { // Si el simbolo que viene es *
						replaceA("Q", "P"); // Se reemplaza el tope de la pila
											// por QP y avanza (ɅVQP)
					} else if (l1.equals("/")) { // Si el simbolo que viene es /
						replaceA("Q", "P"); // Se reemplaza el tope de la pila
											// por QP y avanza (ɅVQP)
					} else if (l1.equals("+")) { // Si el simbolo que viene es +
						desapileR(); // Se desapila el tope y retiene
					} else if (l1.equals("-")) { // Si el simbolo que viene es -
						desapileR(); // Se desapila el tope y retiene
					} else if (l1.equals(")")) { // Si el simbolo que viene es )
						desapileR(); // Se desapila el tope y retiene
					} else if (l1.equals("¬")) { // Si el simbolo que viene es ¬
						desapileR(); // Se desapila el tope y retiene
					} else {
						error(cadena); // Si no es ninguna de la validaciones
										// anteriores es error
						return;
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"Y")) { // preguntamos si el simbolo de la pila en que
								// estamos es Y
					if (l1.equals("(")) { // Si el simbolo que viene es (
						replaceA(")", "D"); // Se reemplaza el tope de la pila
											// por )D y avanza (ɅVQ)D)
						// Si es alguno de los siguientes simbolos nos dira que
						// la cadena es de rechazo //
					} else if (l1.equals("=")) {
						error(cadena);
						return;
					} else if (l1.equals("+")) {
						error(cadena);
						return;
					} else if (l1.equals("-")) {
						error(cadena);
						return;
					} else if (l1.equals("*")) {
						error(cadena);
						return;
					} else if (l1.equals("/")) {
						error(cadena);
						return;
					} else if (l1.equals(")")) {
						error(cadena);
						return;
					} else if (l1.equals("¬")) {
						error(cadena);
						return;
						// ---------------------------------------------------------------------------
						// //
					} else {
						desapileA(); // si no es ninguna de las validaciones
										// anteriores desapila el tope y avanza
										// (ɅVQ))
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						"=")) { // preguntamos si el simbolo de la pila en que
								// estamos es =
					if (l1.equals("=")) {// Si el simbolo que viene en =
						desapileA(); // Desapile el tope y avance (ɅVQ)
					} else {
						error(cadena);// si no es igual (=) debe mandar un error
										// diciendo que la cadena es de rechazo
						return;
					}
				} else if (pila.substring(pila.length() - 1).equalsIgnoreCase(
						")")) { // preguntamos si el simbolo de la pila en que
								// estamos es )
					if (l1.equals(")")) { // Si el simbolo que viene es )
						desapileA(); // Desapila el tope y avanza (ɅV)
					} else {
						error(cadena); // si no es parentesis ()) debe mandar un
										// error diciendo que la cadena es de
										// rechazo
						return;
					}
				}
				k++; // variable para aumentar el ciclo de la cadena
			}
			// --------------------------------------------------------------------------------
			// //
			if (pila.length() < 2) {
				aceptacion(cadena);
			} else {
				error(cadena);
			}
		}
	}

	public static void replaceA(String l1, String l2) {
		pila = pila.substring(0, pila.length() - 1) + l1 + l2;
		// System.out.println(pila);
		JOptionPane.showMessageDialog(null, pila);
	}

	public static void desapileA() {
		pila = pila.substring(0, pila.length() - 1);
		// System.out.println(pila);
		JOptionPane.showMessageDialog(null, pila);
	}

	public static void desapileR() {
		pila = pila.substring(0, pila.length() - 1);
		k--;
		// System.out.println(pila);
		JOptionPane.showMessageDialog(null, pila);
	}
	
	public static void replaceR(String l1, String l2, String opci) {
		if (!opci.equals("")) {
			pila = pila.charAt(0) + l1 + l2 + opci;
		} else if (l2.equals("")) {
			pila = pila.substring(0, pila.length() - 1) + l1;
			// pila = pila.charAt(0)+l1;
		} else {
			pila = pila.substring(0, pila.length() - 1) + l1 + l2;
		}
		k--;
		// JOptionPane.showMessageDialog(null, "hola");
		// System.out.println(pila);
		JOptionPane.showMessageDialog(null, pila);
	}
	
	public static void aceptacion(String cadena) {
		cosas.frm.getTxtDato().setText("Aceptacion");
	}

	public static void error(String cadena) {
		cosas.frm.getTxtDato().setText("Rechazo");
	}
}

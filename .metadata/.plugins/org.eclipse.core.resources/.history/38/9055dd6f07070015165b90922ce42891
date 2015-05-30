package com.Parcial2;

import java.io.*;
import java.util.Scanner;

public class Parcial2DF {

	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	static String cadena1, cadena2;
	private static int contNodos = 0, acumNodos = 0, promNodos, may = 0,
			men = 3;
	
	static Parcial2DF listaA = new Parcial2DF();
	private static CrearNodo primero;

	private static CrearNodo primeroAux;

	/**
	 * @return the acumNodos
	 */
	public static int getAcumNodos() {
		return acumNodos;
	}

	/**
	 * @return the may
	 */
	public static int getMay() {
		return may;
	}

	/**
	 * @return the men
	 */
	public static int getMen() {
		return men;
	}

	/**
	 * @return the promNodos
	 */
	public static int getPromNodos() {
		return promNodos;
	}

	static boolean isVacia(Parcial2DF L) {

		boolean rta = false;

		if (Parcial2DF.primero == null) {
			rta = true;
		}

		return rta;
	}

	public static void main(String[] args) throws IOException {
		String O;
		int op;

		while (true) {

			System.out.println("\n\n-- Menu de opciones --");
			System.out.println("\n1. Crear Lista");
			System.out.println("2. Ver Lista");
			System.out.println("3. Salir");

			System.out.print("\nDigite opcion -> ");
			O = br.readLine();
			op = Integer.parseInt(O);

			if (op == 1) {
				listaA = listaA.crearL();
			}
			if (op == 2) {
				contNodos = 0;
				verLista(listaA);
			}
			if (op == 3) {
				System.out.println("\n\nFIN..\n\n");
				break;
			}

		}

	}

	/**
	 * @param acumNodos
	 *            the acumNodos to set
	 */
	public static void setAcumNodos(int acumNodos) {
		Parcial2DF.acumNodos = acumNodos;
	}

	/**
	 * @param may
	 *            the may to set
	 */
	public static void setMay(int may) {
		Parcial2DF.may = may;
	}

	/**
	 * @param men
	 *            the men to set
	 */
	public static void setMen(int men) {
		Parcial2DF.men = men;
	}

	/**
	 * @param promNodos
	 *            the promNodos to set
	 */
	public static void setPromNodos(int promNodos) {
		Parcial2DF.promNodos = promNodos;
	}

	static void verLista(Parcial2DF L) {

		if (isVacia(L)) {
			System.out
			.println("\n\nLa lista esta vacia, debe crearla primero.\n");
		} else {

			System.out.println("\n\n--Lista creada --\n");
			primeroAux = primero;

			while (primero != null) {
				contNodos++;

				System.out.print("\n Nombre: " + primero.nombre
						+ "\n Apellido: " + primero.apellido + "\n Edad: "
						+ primero.edad + "\n Estatura: " + primero.estatura
						+ "\n");
				primero = primero.enlace;

			}
			primero = primeroAux;
			System.out.println("\n numero de nodos = " + contNodos);
			System.out.println(" ");

		}

	}

	public Parcial2DF() {
		primero = null;
	}

	Parcial2DF crearL() throws IOException {
		Parcial2DF l1 = new Parcial2DF();
		Scanner leer = new Scanner(System.in);
		DataOutputStream Archi = null;
		int i;
		int edad;
		String nombre;
		double estatura;
		String apellido;

		int n;
		try {

			System.out.println("Ingrese numero de nodos: ");
			n = leer.nextInt();

			for (i = 0; i < n; i++) {
				Archi = new DataOutputStream(new FileOutputStream(
						"c:/AlmacenLista.txt", true));

				System.out.println("Ingrese Nombre: ");
				nombre = leer.next();

				System.out.println("Ingrese Apellido: ");
				apellido = leer.next();

				System.out.println("Ingrese Edad : ");
				edad = leer.nextInt();

				System.out.println("Ingrese Estatura:  ");
				estatura = leer.nextDouble();

				primero = new CrearNodo(nombre, apellido, edad, estatura, primero);

				Archi.writeUTF(nombre);
				Archi.writeUTF(apellido);
				Archi.writeInt(edad);
				Archi.writeDouble(estatura);

				Archi.close();
			}

		} catch (FileNotFoundException fnfe) {
		}

		catch (IOException ioe) {
		}
		System.out.print("\nLista creada con exito");
		return l1;
	}

}

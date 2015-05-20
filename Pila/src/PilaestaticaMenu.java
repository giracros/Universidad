import java.util.Scanner;

public class PilaestaticaMenu {
	public static void main(String[] args) {
		PilaestaticaMenu objeto = new PilaestaticaMenu();
		Scanner opcion = new Scanner(System.in);
		int seleccion;
		do {
			System.out.println("Menu de Pila  ");

			System.out.println("1.- Insertar dato");
			System.out.println("2.- Borrar dato");
			System.out.println("3.- Mostrar ");

			System.out.println("4.- Salir");

			System.out.println("Teclee la opcion deseada");
			seleccion = opcion.nextInt();

			switch (seleccion) {
			case 1:
				System.out.println("");
				objeto.llenarpila();
				System.out.println("");
				break;
			case 2:
				System.out.println("");
				objeto.Vaciar();
				System.out.println("");
			case 3:
				System.out.println("");
				objeto.ver();
				System.out.println("");
			}// fin del switch seleccion
		} while (seleccion != 4);
	}
	int pilaa[] = new int[4];
	Scanner teclado = new Scanner(System.in);

	int tope = -1;

	public int llenarpila() {
		if (tope >= pilaa.length - 1) {
			System.out.println("La pila esta llena :/");
		} else {
			tope++;
			System.out.println("Ingrese el dato ");
			pilaa[tope] = teclado.nextInt();
		}
		return tope;
	}// fin llenarpila

	public int Vaciar() {
		if (tope == -1) {
			System.out.println("La pila esta vacia :/");
		} else {
			System.out.println("Se elimino un elememto de la pila");
			pilaa[tope] = 0;
			tope--;
		}
		return tope;
	}// fin vaciar

	public void ver() {
		for (int tope = 3; tope >= 0; tope--) {
			System.out.println("Datos de la pila" + pilaa[tope]);
		}
	}// fin metodo ver
}

import java.util.Scanner;

public class PilaEstatica {
	public static void main(String[] args) {
		int dato;
		int pila[] = new int[5];
		Scanner teclado = new Scanner(System.in);
		for (int tope = 0; tope <= 4; tope++) {
			System.out.println("Proporciona datos para la pila");
			dato = teclado.nextInt();
			pila[tope] = dato;
		}
		for (int tope = 4; tope >= 0; tope--)
			System.out.println("La pila tiene los siguientes datos: "
					+ pila[tope]);
	}
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Piladinamicaejemplo {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int num;
        int seleccion;
        LinkedList lista=new LinkedList();// Objeto
        do{
            System.out.println("Menu de opciones  ");


            System.out.println("1.- Insertar dato");
            System.out.println("2.- Borrar dato");
            System.out.println("3.- Mostrar ");
            System.out.println("4.- Borrar toda la pila");
            System.out.println("5.- Salir");


            System.out.println("Teclee la opcion deseada para la pila");
            seleccion=leer.nextInt();


          switch(seleccion){
              case 1:
                  System.out.println("Inserte un numero");
                  num=leer.nextInt();
                  lista.addFirst(num);
                  break;
              case 2:
                  System.out.println("Se borrara el primer nodo");
                  lista.removeFirst();
              case 3:
                   System.out.println("La pila es la siguiente");
                  List lista2=new ArrayList(lista);
                  Iterator it=lista2.iterator();
                  while(it.hasNext()){
                      System.out.println(it.next()+"");
                  }
              case 4:
                   System.out.println("Se borraran todos los elementos");
                  lista.clear();
                  break;


                  }//fin del switch seleccion


          }
        while(seleccion !=5);
        }//fin del main

    }//fin de la clase
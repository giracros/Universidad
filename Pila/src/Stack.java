import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack {
    private LinkedList<Integer> pila;
    
    public Stack(){
        pila = new LinkedList<>();
    }
    
    public boolean isEmpty() {
        return pila.isEmpty();
    }
    
    public void push(Integer elemento){
        pila.addLast(elemento);
    } 
    
    public Integer pop(){
        Integer elem = null;
        try{
        elem = pila.removeLast();
        }catch(NoSuchElementException e){
            System.out.println("No hay elementos en la pila");
        }
        return elem;
    }
    
}
package proyecto1;

import da.Cola;
import da.Lista;
import da.Pila;

/**
 *
 * @author Johan Herrera
 */
public class Proyecto1 {

    public static void main(String[] args) {
        Cola c = new Cola(); //Cola Vacia
        Pila p = new Pila(); //Pila Vacia
        Lista l = new Lista(); //Lista Vacia

        //Merge Sort
        l.addSimple("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista
        l.addSimple("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        l.addSimple("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        l.addSimple("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        l.addSimple("Mariana", "Castilla", "Arias", "M123785", 20.9);
        l.addSimple("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        l.addSimple("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        l.addSimple("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("Lista Original: \n" + l.toString());    //Imprime lista Original
        l.mergeSort(l.getCabeza());                                //Ordenamiento por mezcla 
        l.pasaportePrimero();                                     //Si hay pasaportes los coloca en primera posicion.
        System.out.println("Lista Ordenada: \n" + l.toString()); //Imprime lista Ordenada

        //Heap Sort
        p.push("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Pila
        p.push("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        p.push("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        p.push("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        p.push("Mariana", "Castilla", "Arias", "M123785", 20.9);
        p.push("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        p.push("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        p.push("Angel", "Barrantes", "Chaves", "e770089", 18.7);

//        System.out.println("Pila Original: \n" + p.toString());   //Imprime Pila Original
//                                                                 // Ordenamiento por monticulos.
//        System.out.println("Pila Ordenada: \n" + p.toString()); //Imprime Pila Ordenada

        //Insertion Sort 
        c.queue("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4);   //Añade a la Cola
        c.queue("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        c.queue("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        c.queue("Daniela", "Zepeda", "Ramirez", "P557905", 20.9);
        c.queue("Mariana", "Castilla", "Arias", "M123785", 20.9);
        c.queue("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        c.queue("Rogel", "Herrera", "Bellido", "8-0083-0592", 41.5);
        c.queue("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("Cola Original: \n" + c.toString());   //Imprime Cola Original
        c.insertionSort();                                       //Ordenadimiento por Insercion
        System.out.println("Cola Ordenada: \n" + c.toString()); //Imprime Cola Ordenada
    }
}

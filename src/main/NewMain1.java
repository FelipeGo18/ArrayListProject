package main;

import java.util.Scanner;
import lista.Lista;

/**
 *
 * @author gonza
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int cont = 0;
        String opcion2;

        System.out.print("Ingrese el tamanio del arreglo: ");
        int index = sc.nextInt();
        Lista ls = new Lista(index);

        ls.crearArreglo(index);

        String elemento = null;
        do {
            System.out.print("Ingrese un elemento: ");
            elemento = sc.next();

            ls.llenarArreglo(elemento, cont);

            System.out.print("Quiere agregar otro elemento? (S/N): ");
            opcion2 = sc.next();

            cont++;
        } while (opcion2.equalsIgnoreCase("S"));

        while (true) {

            System.out.println("""

                           1.  Mostrar lista
                           2.  Agrega un elemento al final de la lista
                           3.  Agrega un elemento en una posicion de la lista
                           4.  addAll
                           5.  Limpiar lista
                           6.  Verificar si hay un elemento en la lista
                           7.  Mostrar que elemento hay en una posicion
                           8.  Mostrar la posicion de la primera aparicion del elemento 
                               especificado en esta lista, o -1 si esta lista no contiene el elemento.
                           9. Verificar si la lista esta vacia
                           10. Mostrar la posicion de la ultima aparicion del elemento 
                               especificado en esta lista, o -1 si esta lista no contiene el elemento.
                           11. Eliminar un elemento en una posicion de la lista
                           12. Eliminar la priemara aparicion de un elemento de la lista
                           13. Reemplazar un elemento de la lista
                           14. Numero de elemetos en la lista
                           15. Hacer una sublista
                           16. Disminuir tamanio de la lista
                           17. Aumenta el tamanio de la lista
                           18. Salir.
                           """);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(ls.mostrarArreglo(cont));
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                case 12:
                    break;

                case 13:
                    break;

                case 14:
                    break;

                case 15:
                    break;

                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;

            }
        }

    }

}

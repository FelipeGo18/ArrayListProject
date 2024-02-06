package main;

import java.util.Arrays;
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
        int opcion;
        int cont = 0;
        String opcion2 = "";

        System.out.print("Ingrese el tamanio del arreglo: ");
        int index = sc.nextInt();
        Lista ls = new Lista(index);

        ls.crearArreglo(index);

        String elemento;
        do {
            System.out.print("Ingrese un elemento: ");
            elemento = sc.next();
            ls.llenarArreglo(elemento, cont);

            if (cont == index - 1) { //condicion para sacar del caso si está lleno el arreglo
                cont++;
                break;
                
            }

            cont++;
            System.out.println(cont);

            boolean opcionValida = false;

            do {
                try {
                    System.out.print("Quiere agregar otro elemento? (S/N): ");
                    opcion2 = sc.next();

                    if (opcion2.equalsIgnoreCase("s") || opcion2.equalsIgnoreCase("n")) {
                        opcionValida = true;
                    } else {
                        throw new IllegalArgumentException("Opcion no valida. Ingrese 'S' o 'N'.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!opcionValida);

        } while (opcion2.equalsIgnoreCase("s"));

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
                           14. Numero de elementos en la lista
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

                    try {
                        if (cont == index - 1) {
                            throw new IllegalArgumentException("La lista esta llena");
                        } else {
                            System.out.print("Ingrese el elemento a agregar al final de la lista: ");
                            elemento = sc.next();

                            if (ls.agregarAlFinal(elemento, cont)) {
                                System.out.println("Se agrego el elemento");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    cont++;
                    break;

                case 3:

                    System.out.print("Ingrese la posicion donde desea agregar el elemento: ");
                    int posicion = sc.nextInt();

                    System.out.print("Ingrese el nuevo elemento para agregar en la posicion " + posicion + ": ");
                    elemento = sc.next();

                    ls.agregarEnPosicion(elemento, posicion, cont);

                    cont++;
                    break;

                case 4:
                    
                    break;

                case 5:
                    ls.limpiarLista(index);
                    break;

                case 6:

                    System.out.print("Ingrese el elemento que desea verificar: ");
                    elemento = sc.next();

                    if (ls.verificarElemento(elemento, cont)) {
                        System.out.println("El elemento " + elemento + " esta presente en la lista.");
                    } else {
                        System.out.println("El elemento " + elemento + " no está presente en la lista.");
                    }
                    break;

                case 7:

                    System.out.print("Ingrese la posicion para obtener el elemento: ");
                    int posicionConsulta = sc.nextInt();

                    String elementoEnPosicion = ls.obtenerElementoEnPosicion(posicionConsulta, cont);
                    if (elementoEnPosicion != null) {
                        System.out.println("El elemento en la posicion " + posicionConsulta + " es: " + elementoEnPosicion);
                    } else {
                        System.out.println("Posicion no valida o el elemento no esta presente en la lista.");
                    }
                    break;

                case 8:

                    System.out.print("Ingrese el elemento para obtener la primera posicion: ");
                    elemento = sc.next();

                    int primeraPosicion = ls.obtenerPrimeraPosicion(elemento, cont);
                    if (primeraPosicion != -1) {
                        System.out.println("La primera aparicion de " + elemento + " esta en la posicion: " + primeraPosicion);
                    } else {
                        System.out.println("El elemento " + elemento + " no esta presente en la lista.");
                    }
                    break;

                case 9:
                    if (ls.verificarListaVacia(cont)) {
                        System.out.println("la lista  esta vacia.");
                    } else {
                        System.out.println("la lista no esta vacia");
                    }
                    break;

                case 10:
                    System.out.print("Ingrese el elemento para obtener la ultima posicion: ");
                    elemento = sc.next();

                    int ultimaPosicion = ls.obtenerUltimaPosicion(elemento, cont);
                    if (ultimaPosicion != -1) {
                        System.out.println("La ultima posicion de " + elemento + " es: " + ultimaPosicion);
                    } else {
                        System.out.println("El elemento " + elemento + " no esta presente en la lista.");
                    }
                    break;

                case 11:
                    System.out.print("Ingrese la posicion para eliminar el elemento: ");
                    int posicionEliminar = sc.nextInt();
                    posicion = posicionEliminar - 1;
                    ls.moverPosicionIzquierda(cont, posicion);

                    cont--;

                    break;

                case 12:
           
                    System.out.print("Ingrese el elemento para eliminar la primera aparicion: ");
                    String elementoEliminar = sc.next();
                    String elementoEliminado = ls.eliminarPrimeraAparicion(elementoEliminar, cont);

                    if (elementoEliminado != null) {
                        System.out.println("Se ha eliminado el elemento: " + elementoEliminado);
                        cont--; 
                    } else {
                        System.out.println("El elemento no se encontró en la lista.");
                    }
                    break;


                case 13:
                    System.out.print("Ingrese el elemento que desea reemplazar: ");
                    String elementoViejo = sc.next();

                    System.out.print("Ingrese el nuevo elemento: ");
                    String elementoNuevo = sc.next();

                    ls.reemplazarElemento(elementoViejo, elementoNuevo, cont);
                    break;

                case 14:
                    System.out.println(cont);
                    System.out.println("Numero de elementos en la lista: " + ls.tamanio(cont));
                    break;

                case 15:
                    System.out.print("Ingrese el indice de inicio para la sublista: ");
                    int inicioSublista = sc.nextInt();

                    System.out.print("Ingrese el indice de fin para la sublista: ");
                    int finSublista = sc.nextInt();

                    String[] sublista = ls.crearSublista(inicioSublista, finSublista, cont);
                    if (sublista != null) {
                        System.out.println("Sublista creada correctamente: " + Arrays.toString(sublista));
                    } else {
                        System.out.println("indices de sublista no válidos.");
                    }
                    break;

                case 16:
                    System.out.print("Ingrese la cantidad de elementos a eliminar: ");
                    int cantidadEliminar = sc.nextInt();
                    ls.disminuirTamanioLista(cantidadEliminar, cont);
                    cont -= cantidadEliminar;
                    break;
                case 17:
                    System.out.print("Ingrese la cantidad de elementos a agregar: ");
                    int cantidadAgregar = sc.nextInt();
                    ls.aumentarTamanioLista(cantidadAgregar, cont);
                    cont += cantidadAgregar;
                    break;
                case 18:
                    System.exit(0);
                    break;

            }
        }

    }

}

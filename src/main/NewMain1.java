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

        int index = 0;
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.print("Ingrese el tamaño del arreglo: ");
                index = sc.nextInt();

                if (index <= 0) {
                    throw new IllegalArgumentException("El tamaño del arreglo debe ser mayor que cero.");
                }

                inputValid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Ingrese un valor numérico válido para el tamaño del arreglo.");
                
                sc.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

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
                    System.out.println(index);
                    System.out.println(cont);
                    break;

                case 2:

                    try {
                        if (cont == index) {
                            throw new IllegalArgumentException("La lista esta llena");
                        } else {
                            System.out.print("Ingrese el elemento a agregar al final de la lista: ");
                            elemento = sc.next();

                            if (ls.agregarAlFinal(elemento, cont)) {
                                System.out.println("Se agrego el elemento");
                                cont++;
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    try {
                        System.out.print("Ingrese la posición donde desea agregar el elemento: ");
                        int posicion = sc.nextInt();

                        if (posicion < 0 || posicion > cont) {
                            throw new IllegalArgumentException("La posición ingresada no es válida.");
                        }

                        System.out.print("Ingrese el nuevo elemento para agregar en la posición " + posicion + ": ");
                        elemento = sc.next();

                        ls.agregarEnPosicion(elemento, posicion, cont);
                        cont++;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Ingrese la cantidad de elementos a agregar: ");
                        int cantidadAgregar = sc.nextInt();

                        if (cantidadAgregar <= 0) {
                            throw new IllegalArgumentException("La cantidad de elementos a agregar debe ser mayor que cero.");
                        }

                        String[] nuevosElementos = new String[cantidadAgregar];
                        for (int i = 0; i < cantidadAgregar; i++) {
                            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
                            nuevosElementos[i] = sc.next();
                        }

                        if (ls.addAll(nuevosElementos, cont)) {
                            System.out.println("Elementos agregados correctamente.");
                            cont += cantidadAgregar;
                        } else {
                            System.out.println("No se pudieron agregar los elementos. Espacio insuficiente en la lista.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    ls.limpiarLista(index);
                    cont = 0;
                    break;

                case 6:
                    try {
                        if (cont == 0) {
                            throw new IllegalStateException("La lista está vacía. No se puede verificar ningún elemento.");
                        }

                        System.out.print("Ingrese el elemento que desea verificar: ");
                        elemento = sc.next();

                        if (ls.verificarElemento(elemento, cont)) {
                            System.out.println("El elemento " + elemento + " está presente en la lista.");
                        } else {
                            System.out.println("El elemento " + elemento + " no está presente en la lista.");
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.print("Ingrese la posición para obtener el elemento: ");
                        int posicionConsulta = sc.nextInt();

                        if (posicionConsulta < 0 || posicionConsulta >= cont) {
                            throw new IndexOutOfBoundsException("Posición no válida. Debe estar dentro del rango [0, " + (cont - 1) + "].");
                        }

                        String elementoEnPosicion = ls.obtenerElementoEnPosicion(posicionConsulta, cont);
                        System.out.println("El elemento en la posición " + posicionConsulta + " es: " + elementoEnPosicion);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        System.out.print("Ingrese el elemento para obtener la primera posición: ");
                        elemento = sc.next();

                        int primeraPosicion = ls.obtenerPrimeraPosicion(elemento, cont);
                        if (primeraPosicion != -1) {
                            System.out.println("La primera aparición de " + elemento + " está en la posición: " + primeraPosicion);
                        } else {
                            throw new IllegalArgumentException("El elemento " + elemento + " no está presente en la lista.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        if (ls.verificarListaVacia(cont)) {
                            System.out.println("La lista está vacía.");
                        } else {
                            System.out.println("La lista no está vacía.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al verificar si la lista está vacía: " + e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        System.out.print("Ingrese el elemento para obtener la última posición: ");
                        elemento = sc.next();

                        int ultimaPosicion = ls.obtenerUltimaPosicion(elemento, cont);
                        if (ultimaPosicion != -1) {
                            System.out.println("La última posición de " + elemento + " es: " + ultimaPosicion);
                        } else {
                            System.out.println("El elemento " + elemento + " no está presente en la lista.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al obtener la última posición del elemento: " + e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        System.out.print("Ingrese la posición para eliminar el elemento: ");
                        int posicionEliminar = sc.nextInt();
                        int posicion = posicionEliminar - 1;

                        if (posicion >= 0 && posicion < cont) {
                            String elementoEliminado = ls.eliminarEnPosicion(posicion, cont);
                            System.out.println("Se ha eliminado el elemento en la posición " + posicion + ": " + elementoEliminado);
                            cont--;
                        } else {
                            System.out.println("Posición no válida. Ingrese una posición dentro del rango de la lista.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al eliminar el elemento en la posición: " + e.getMessage());
                    }
                    break;

                case 12:
                    try {
                        System.out.print("Ingrese el elemento para eliminar la primera aparición: ");
                        String elementoEliminar = sc.next();
                        String elementoEliminado = ls.eliminarPrimeraAparicion(elementoEliminar, cont);

                        if (elementoEliminado != null) {
                            System.out.println("Se ha eliminado el elemento: " + elementoEliminado);
                            cont--;
                        } else {
                            System.out.println("El elemento no se encontró en la lista.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al intentar eliminar la primera aparición del elemento: " + e.getMessage());
                    }
                    break;

                case 13:
                    try {
                        System.out.print("Ingrese el elemento que desea reemplazar: ");
                        String elementoViejo = sc.next();

                        System.out.print("Ingrese el nuevo elemento: ");
                        String elementoNuevo = sc.next();

                        ls.reemplazarElemento(elementoViejo, elementoNuevo, cont);
                    } catch (Exception e) {
                        System.out.println("Error al intentar reemplazar el elemento: " + e.getMessage());
                    }
                    break;

                case 14:
                    System.out.println(cont);
                    System.out.println("Numero de elementos en la lista: " + ls.tamanio(cont));
                    break;
                case 15:
                    try {
                        System.out.print("Ingrese el indice de inicio para la sublista: ");
                        int inicioSublista = sc.nextInt();

                        System.out.print("Ingrese el indice de fin para la sublista: ");
                        int finSublista = sc.nextInt();

                        String[] sublista = ls.crearSublista(inicioSublista, finSublista, cont);
                        if (sublista != null) {
                            System.out.println("Sublista creada correctamente: " + Arrays.toString(sublista));
                        } else {
                            System.out.println("Indices de sublista no válidos.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al intentar crear la sublista: " + e.getMessage());
                    }
                    break;

                case 16:
                    System.out.print("Ingrese la cantidad de elementos a eliminar: ");
                    int cantidadEliminar = sc.nextInt();

                    if (cont == index) {
                        cont -= cantidadEliminar;
                        System.out.println("se uso");
                    }

                    index -= cantidadEliminar;

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
                default:
                    System.out.println("Opción no reconocida.");
            }

        }

    }

}

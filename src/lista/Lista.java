package lista;

public class Lista {

    private String[] arreglo;

    public Lista(int index) {
        arreglo = crearArreglo(index);
    }

    public String[] crearArreglo(int index) {
        return new String[index];
    }
    
    private void moverPosicionDerecha(int cont, int posicion) {
        for (int i = cont; i > posicion; i--) {
            arreglo[i] = arreglo[i - 1];
        }
    }

    public void llenarArreglo(String elemento, int cont) {
        arreglo[cont] = elemento;
    }

    public String mostrarArreglo(int cont) {
        String salida = "| ";
        for (int i = 0; i < cont; i++) {
            salida += arreglo[i] + " | ";
        }
        return salida;
    }

    public boolean agregarAlFinal(String nuevoElemento, int cont) {
        arreglo[cont] = nuevoElemento;
        return true;
    }


    public void moverPosicionIzquierda(int cont, int posicion) {
        for (int i = posicion; i < cont - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
    }

    public void agregarEnPosicion(String elemento, int posicion, int cont) {
        moverPosicionDerecha(cont, posicion);
        arreglo[posicion] = elemento;
    }

    public void limpiarLista(int index) {
        for (int i = 0; i < index; i++) {
            arreglo[i] = "";
        }
    }
    
    public boolean addAll(String[] elementos, int cont) {
  
        int nuevoTamanio = cont + elementos.length; 

        if (nuevoTamanio > arreglo.length) {
            return false;
        }

        for (int i = cont, j = 0; i < nuevoTamanio; i++, j++) {
            arreglo[i] = elementos[j];
        }

        return true; 
    }

    public boolean verificarElemento(String elemento, int cont) {
        for (int i = 0; i < cont; i++) {
            if (arreglo[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public String obtenerElementoEnPosicion(int posicion, int cont) {
        if (posicion >= 0 && posicion < cont) {
            return arreglo[posicion];
        } else {
            return null;
        }
    }

    public boolean verificarListaVacia(int cont) {
        for (int i = 0; i < cont; i++) {
            if (arreglo[i].equals("")) {
                return true;
            }
        }
        return false;
    }

    public int obtenerPrimeraPosicion(String elemento, int cont) {
        for (int i = 0; i < cont; i++) {
            if (arreglo[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public int obtenerUltimaPosicion(String elemento, int cont) {
        for (int i = cont - 1; i >= 0; i--) {
            if (arreglo[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public String eliminarEnPosicion(int posicion, int cont) {
        String elementoEliminado;
        elementoEliminado = arreglo[posicion];
        moverPosicionIzquierda(posicion, cont);

        return elementoEliminado;
    }

    public String eliminarPrimeraAparicion(String elemento, int cont) {
        int posicion = -1;

        for (int i = 0; i < cont; i++) {
            if (arreglo[i].equals(elemento)) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {

            String elementoEliminado = arreglo[posicion];
            moverPosicionIzquierda(cont, posicion);
            cont--;

            return elementoEliminado;
        } else {
            return null;
        }
    }

    public void reemplazarElemento(String elementoViejo, String elementoNuevo, int cont) {
        for (int i = 0; i < cont; i++) {
            if (arreglo[i].equals(elementoViejo)) {
                arreglo[i] = elementoNuevo;
                return;
            }
        }

    }

    public int tamanio(int cont) {
        return cont;
    }

    public String[] crearSublista(int inicio, int fin, int cont) {
            String[] sublista = new String[fin - inicio + 1];
            int sublistaIndex = 0;

            for (int i = inicio; i <= fin; i++) {
                sublista[sublistaIndex++] = arreglo[i];
            }
            return sublista;
    }

    public void aumentarTamanioLista(int cantidad, int cont) {
        String[] nuevoArreglo = new String[cont + cantidad];

        for (int i = 0; i < cont; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

}
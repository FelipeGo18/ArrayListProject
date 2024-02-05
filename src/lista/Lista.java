package lista;

public class Lista {

    private String[] arreglo;

    public Lista(int index) {
        arreglo = crearArreglo(index);
    }

    public final String[] crearArreglo(int index) {
        return new String[index];
    }

    public void llenarArreglo(String elemento, int cont) {
        arreglo[cont] = elemento;
    }

    public String mostrarArreglo(int cont) {
        String salida = "";
        for (int i = 0; i < cont; i++) {
            salida += " | " + arreglo[i] + " | ";
        }
        return salida;
    }

    public void agregarAlFinal(String nuevoElemento, int cont) {
        if (cont < arreglo.length) {
            arreglo[cont] = nuevoElemento;
        }
    }

    private void moverPosicionDerecha(int cont, int posicion) {
        for (int i = cont; i > posicion; i--) {
            arreglo[i] = arreglo[i - 1];
        }
    }

    public void agregarEnPosicion(String elemento, int posicion, int cont) {
        if (posicion >= 0 && posicion < cont) {
            moverPosicionDerecha(cont, posicion);
            arreglo[posicion] = elemento;

        }
    }

    public void limpiarLista(int index) {
        for (int i = 0; i < index; i++) {
            arreglo[i] = " ";
        }
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
            if (arreglo[i].equals(" ")) {
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

    public void eliminarEnPosicion(int posicion, int cont) {
    if (posicion >= 0 && posicion < cont) {
        for (int i = posicion; i < cont - 1; i++) {
            arreglo[i] = arreglo[i + 1];
        }
          arreglo[cont - 1] = " ";
        cont--; 
        
    }
}

public void eliminarPrimeraAparicion(String elemento, int cont) {
    int posicion = -1;

    for (int i = 0; i < cont; i++) {
        if (arreglo[i].equals(elemento)) {
            posicion = i;
            break; 
        }
    }
    if (posicion != -1) {
        eliminarEnPosicion(posicion, cont);
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

public String[] crearSublista(int inicio, int fin, int cont) {
    if (inicio >= 0 && inicio < cont && fin >= 0 && fin < cont && inicio <= fin) {
        String[] sublista = new String[fin - inicio + 1];
        int sublistaIndex = 0;

        for (int i = inicio; i <= fin; i++) {
            sublista[sublistaIndex++] = arreglo[i];
        }

        return sublista;
    } else {
        return null; 
    }
}

public void disminuirTamanioLista(int cantidad, int cont) {
    if (cantidad >= 0 && cantidad <= cont) {
        for (int i = 0; i < cantidad; i++) {
            arreglo[cont - 1 - i] = "";
        }         
    } 
}

    public void aumentarTamanioLista(int cantidad, int cont) {
        if (cantidad > 0) {
            String[] nuevoArreglo = new String[cont + cantidad];

            for (int i = 0; i < cont; i++) {
                nuevoArreglo[i] = arreglo[i];
            }
            arreglo = nuevoArreglo;
        }
    }

}

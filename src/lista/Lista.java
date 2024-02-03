package lista;

public class Lista {

    private String[] arreglo;

    public Lista(int index) {
        arreglo = crearArreglo(index);
    }

    public String[] crearArreglo(int index) {
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

    public void agregarEnPosicion(String elemento, int posicion, int cont) {
        if (posicion >= 0 && posicion < cont) {
            for (int i = cont; i > posicion; i--) {
                arreglo[i] = arreglo[i - 1];
            }
            arreglo[posicion] = elemento;
            cont++;

        }
    }

}

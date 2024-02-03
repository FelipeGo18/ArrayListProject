
package lista;

public class Lista {
    
    private String[] arreglo;

    public Lista(int index) {
        arreglo = crearArreglo(index);
    }
 
    public String[] crearArreglo(int index) {
        return new String[index];
    }
    
    public void llenarArreglo(String elemento, int cont){
        arreglo[cont] = elemento;
    }
    
    public String mostrarArreglo(int cont){
        String salida = "";
        for (int i = 0; i < cont; i++) {
            salida += " | " + arreglo [i] + " | "; 
        }  
        return salida;
    }
}

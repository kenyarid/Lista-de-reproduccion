package listareproduccion;

public class PilaHistorial {
    private NodoPila tope;
    private int tamano;

    public PilaHistorial() {
        this.tope = null;
        this.tamano = 0;
    }

    // Agrega la canción al historial
    public void push(Cancion cancion) {
        if (cancion == null) return;
        NodoPila nuevoNodo = new NodoPila(cancion);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
        tamano++;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    // Canción en reproducción
    public Cancion peek() {
        if (tope == null) {
            System.out.println("El historial está vacío, no hay canción actual.");
            return null;
        }
        return tope.getCancion();
    }

    // Método para borrar las canciones
    public void clear() {
        tope = null;
        tamano = 0;
        System.out.println("Se ha limpiado el historial por completo.");
    }

    // Método para mostrar
    public void mostrar() {
        if (tope == null) {
            System.out.println("El historial está vacío, no hay canciones reproducidas.");
            return;
        }
        System.out.println();
        System.out.println("=================== HISTORIAL DE REPRODUCCIÓN ===================");
        NodoPila actual = tope;
        int contador = 1;
        NodoPila temp = actual;
        while (actual != null) {
        	String marcador = (temp == actual) ? " <-- [ACTUAL]" : "";
            System.out.println("[" + contador + "] " + actual.getCancion().toString() + marcador);
            actual = actual.getSiguiente();
            contador++;
        }
        System.out.println("Total de canciones reproducidas: " + tamano);
        System.out.println("===================================================================");
    }

    public int getTamano() {
        return tamano;
    }
}
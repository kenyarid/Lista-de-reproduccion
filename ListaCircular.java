package listareproduccion;

public class ListaCircular {
    private NodoListaCircular cabeza = null;
    private NodoListaCircular cola = null;
    private NodoListaCircular actual = null;
    private PilaHistorial historial = new PilaHistorial(); // Conexión con la pila

    public void agregar(String titulo, String autor) {
        Cancion nuevaCancion = new Cancion(titulo, autor);
        NodoListaCircular nuevoNodo = new NodoListaCircular(nuevaCancion);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;
            nuevoNodo.anterior = cola;
            actual = cabeza;
            historial.push(actual.cancion); // Se registra la primera canción en el historial
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
            cola.siguiente = cabeza;
            cabeza.anterior = cola;
        }
    }

    public void anteriorCancion() {
        if (actual == null) {
            System.out.println("La playlist está vacía");
            return;
        }
        actual = actual.anterior;
        System.out.println("Reproduciendo: " + actual.cancion);
        historial.push(actual.cancion); // Guarda en historial
    }

    public void siguienteCancion() {
        if (actual == null) {
            System.out.println("La playlist está vacía");
            return;
        }
        actual = actual.siguiente;
        System.out.println("Reproduciendo: " + actual.cancion);
        historial.push(actual.cancion); // Guarda en historial
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        NodoListaCircular temp = cabeza;
        do {
            System.out.print(temp.cancion + " -> ");
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("(vuelve a " + cabeza.cancion + ")");
    }

    public void eliminar(String autor, String titulo) {
        if (cabeza == null) {
            System.out.println("La playlist está vacía");
            return;
        }

        NodoListaCircular temp = cabeza;
        boolean encontrada = false;

        do {
            if (temp.cancion.getTitulo().equalsIgnoreCase(titulo)) {
                encontrada = true;
                break;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        if (!encontrada) {
            System.out.println("No se encontró la canción: " + titulo);
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } else {
            temp.anterior.siguiente = temp.siguiente;
            temp.siguiente.anterior = temp.anterior;

            if (temp == cabeza) {
                cabeza = temp.siguiente;
            }
            if (temp == cola) {
                cola = temp.anterior;
            }
            if (temp == actual) {
                actual = temp.siguiente;
                historial.push(actual.cancion); // Si cambia automáticamente, se guarda en historial
            }
        }

        System.out.println("Canción eliminada: " + titulo);
    }

    // MÉTODOS CONECTADOS AL HISTORIAL!!!
    public void verCancionActualHistorial() {
        Cancion enCima = historial.peek();
        if (enCima != null) {
            System.out.println("Canción actual " + enCima);
        }
    }

    public void verHistorialCompleto() {
        historial.mostrar();
    }

    public void limpiarHistorial() {
        historial.clear();
    }
}
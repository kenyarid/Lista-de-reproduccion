package listareproduccion;

public class ListaCircular {
	    private NodoListaCircular cabeza = null;
	    private NodoListaCircular cola = null;
	    private NodoListaCircular actual = null;
	    
	    public void agregar(String titulo, String autor) {
	        CancionListaCircular nuevoCancionListaCircular = new CancionListaCircular(titulo, autor);
	        NodoListaCircular nuevoNodo = new NodoListaCircular(nuevoCancionListaCircular);
	        
	        if (cabeza == null) {
	            cabeza = nuevoNodo;
	            cola = nuevoNodo;
	            nuevoNodo.siguiente = cabeza; // Apunta a sí mismo
	            nuevoNodo.anterior = cola;
	            actual = cabeza;
	        } else {
	            cola.siguiente = nuevoNodo;   // La antigua cola apunta al nuevo
	            nuevoNodo.anterior = cola;
	            cola = nuevoNodo;             // El nuevo nodo es ahora la cola
	            cola.siguiente = cabeza;   // La nueva cola apunta a la cabeza
	            cabeza.anterior = cola;
	        }
	    }
	    
	    public void anteriorCancion() {
	    	if (actual == null) {
	            System.out.println("La playlist está vacía.");
	            return;
	        }	
	    	actual = actual.anterior; // Avanza y al volver al inicio llega al final
	        System.out.println("Reproduciendo: " + actual.cancion);	   
	    }
	    
	    
	    public void siguienteCancion() {
	        if (actual == null) {
	            System.out.println("La playlist está vacía.");
	            return;
	        }
	        actual = actual.siguiente; // Avanza y al llegar al final vuelve al inicio
	        System.out.println("Reproduciendo: " + actual.cancion);	     
	    }
	    
	    public void mostrar() {
	        if (cabeza == null) {
	            System.out.println("La lista está vacía.");
	            return;
	        }

	        NodoListaCircular actual = cabeza;
	        do {
	            System.out.print(actual.cancion + " -> ");
	            actual = actual.siguiente;
	        } while (actual != cabeza); // Se detiene al volver al inicio
	        
	        System.out.println("(vuelve a " + cabeza.cancion + ")");
	    }
	    
	    //PARTE MÁS COMPLEJA!!!!!!!!!!!!!!!!!
	    public void eliminar(String autor, String titulo) {
    	    if (cabeza == null) {
    	        System.out.println("La playlist está vacía.");
    	        return;
    	    }

    	    NodoListaCircular temp = cabeza;
    	    boolean encontrada = false;

    	    // recorrer lista
    	    do {
    	        if (temp.cancion.titulo.equalsIgnoreCase(titulo)) {
    	            encontrada = true;
    	            break;
    	        }
    	        temp = temp.siguiente;
    	    } while (temp != cabeza);

    	    if (!encontrada) {
    	        System.out.println("No se encontró la canción: " + titulo);
    	        return;
    	    }

    	    // reconectar los nodo según el caso
    	    if (cabeza == cola) {
    	    	//Única canción
    	        cabeza = null;
    	        cola = null;
    	        actual = null;
    	    } else {
    	        //Hay más canciones, puenteamos el nodo a eliminar
    	        temp.anterior.siguiente = temp.siguiente;
    	        temp.siguiente.anterior = temp.anterior;

    	        // Si borramos los extremos, movemos cabeza o cola
    	        if (temp == cabeza) {
    	            cabeza = temp.siguiente;
    	        }
    	        if (temp == cola) {
    	            cola = temp.anterior;
    	        }
    	        // Si está sonando justo la que borramos, pasamos a la siguiente
    	        if (temp == actual) {
    	            actual = temp.siguiente;
    	        }
    	    }

    	    System.out.println("Canción eliminada: " + titulo);
    	}
}


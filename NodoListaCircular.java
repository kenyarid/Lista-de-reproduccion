package listareproduccion;

public class NodoListaCircular {
    Cancion cancion;
    NodoListaCircular siguiente;
    NodoListaCircular anterior;

    public NodoListaCircular(Cancion cancion) {
        this.cancion = cancion;
        this.siguiente = null;
        this.anterior = null;
    }
}
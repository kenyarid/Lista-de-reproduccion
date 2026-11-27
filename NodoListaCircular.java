package listareproduccion;

public class NodoListaCircular {
		CancionListaCircular cancion;
		NodoListaCircular siguiente;
		NodoListaCircular anterior;

		public NodoListaCircular(CancionListaCircular cancion) {
			this.cancion = cancion;
			this.siguiente = null;
			this.anterior = null;
		}
}

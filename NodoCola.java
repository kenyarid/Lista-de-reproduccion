package listareproduccion;

public class NodoCola 
{
	//--------------------------
	private Cancion cancion; // guarda la info del elemento
	private NodoCola siguiente; // guarda la referencia al nodo que sigue (el que está detrás en la fila)

	public NodoCola(Cancion cancion) 
	{
		this.cancion = cancion;
		this.siguiente = null;
	}

	//----- Getters & Setters------
	public Cancion getCancion() 
	{
		return cancion;
	}

	public NodoCola getSiguiente() 
	{
		return siguiente;
	}

	public void setSiguiente(NodoCola siguiente) 
	{
		this.siguiente = siguiente;
	}
}
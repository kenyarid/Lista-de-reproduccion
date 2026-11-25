package listareproduccion;

public class NodoPila 
{
	//--------------------------
	private Cancion cancion; // guarda  la info del elemento
    private NodoPila siguiente; // guarda la referencia del sig nnodo

    public NodoPila(Cancion cancion) 
    {
        this.cancion = cancion;
        this.siguiente = null;
    }

    //----- Getters & Setters------
    public Cancion getCancion() 
    {
        return cancion;
    }

    public NodoPila getSiguiente() 
    {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) 
    {
        this.siguiente = siguiente;
    }
}

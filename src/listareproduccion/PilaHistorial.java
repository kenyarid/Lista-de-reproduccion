package listareproduccion;

public class PilaHistorial
{

	//---------------------------
	private NodoPila tope;
	private int cantidad;

    public PilaHistorial() 
    {
        tope = null;
        cantidad = 0;
    }
	
	//REVISA SI LA PILA ESTA VACIA-------
    public boolean isEmpty() 
    {
        return tope == null;
    }
	   
	//AGREGAMOS UNA CANCION--------
	public void push(Cancion cancion) 
	{

	        if (cancion == null ||cancion.getTitulo() == null ||cancion.getTitulo().isBlank() || cancion.getArtista() == null ||cancion.getArtista().isBlank()) 
	        {

	            System.out.println(
	                "PUSH: Datos de canción inválidos");
	            return;
	        }

	        NodoPila nuevo = new NodoPila(cancion);

	        nuevo.setSiguiente(tope);
	        tope = nuevo;
	        cantidad++;

	        // imprimimos si, si quedó y su cant
	        System.out.println("PUSH: Canción agregada: " + cancion);
	        System.out.println("Total de canciones: " + cantidad);
	    }
	//---
	  // QUITAR LA CANCION DEL TOPE--------------
    public Cancion pop() 
    {

        if (isEmpty()) 
        {
            System.out.println("POP: No se puede retirar una canción " + " La pila está vacía");
            return null;
        }

        Cancion eliminada = tope.getCancion();

        tope = tope.getSiguiente();
        cantidad--;

        System.out.println("POP: Canción retirada: " + eliminada);
        return eliminada;
    }

    // CONSULTAR EL TOPE SIN BORRARLO----------
    public Cancion peek() 
    {

        if (isEmpty()) 
        {
            System.out.println("PEEK: La pila está vacía");
            return null;
        }

        System.out.println("PEEK: Canción actual: "+ tope.getCancion());
        return tope.getCancion();
    }

    // MOSTRAR LAS CONCIONES ALMACENADAS---------------
    public void mostrar() 
    {

        System.out.println("----- HISTORIAL DE CANCIONES-----");

        if (isEmpty()) 
        {
            System.out.println("No hay canciones en el historial...");
            return;
        }

        NodoPila actual = tope;
        int posicion = 1;

        while (actual != null) 
        {

            System.out.println(posicion + ". " + actual.getCancion());
            actual = actual.getSiguiente();
            posicion++;
        }

        System.out.println("Total de canciones: " + cantidad);
    }

    // VACIAR COMPLETAMENTE LA PILA-------------
    public void clear() 
    {
        int eliminadas = cantidad;
        tope = null;
        cantidad = 0;

        System.out.println("CLEAR: Historial borrado");
        System.out.println("Canciones borradas: " + eliminadas);
    }

    // CHECAR LA CANT DE ELEMETOS-----
    public int getCantidad() 
    {
        return cantidad;
    }
}

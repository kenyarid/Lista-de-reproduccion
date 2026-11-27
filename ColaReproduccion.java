package listareproduccion;

public class ColaReproduccion
{

	//---------------------------
	private NodoCola frente; // primera canción en la fila (la próxima)
	private NodoCola fin;    // última canción en la fila (la más reciente)
	private int cantidad;

	public ColaReproduccion() 
	{
		frente = null;
		fin = null;
		cantidad = 0;
	}
	//Para actulizar la cola al reproducir la canción anterior
	public void vaciarSilencioso() {
	    frente = null;
	    fin = null;
	    cantidad = 0;
	}
	
	//REVISA SI LA COLA ESTA VACIA-------
	public boolean isEmpty() 
	{
		return frente == null;
	}

	//AGREGAMOS UNA CANCION AL FINAL DE LA COLA--------
	public void encolar(Cancion cancion) 
	{
		if (cancion == null || cancion.getTitulo() == null || cancion.getTitulo().isBlank() 
				|| cancion.getArtista() == null || cancion.getArtista().isBlank()) 
		{
			System.out.println("ENCOLAR: Datos de canción inválidos");
			return;
		}

		NodoCola nuevo = new NodoCola(cancion);

		if (isEmpty()) 
		{
			// primer elemento: es a la vez el frente y el fin
			frente = nuevo;
			fin = nuevo;
		} 
		else 
		{
			// el que era el último ahora apunta al nuevo, y el nuevo pasa a ser el fin
			fin.setSiguiente(nuevo);
			fin = nuevo;
		}
		cantidad++;
	}

	//SACAR LA CANCION DEL FRENTE (LA QUE SIGUE EN REPRODUCCIÓN)--------------
	public Cancion desencolar() 
	{
		if (isEmpty()) 
		{
			System.out.println("DESENCOLAR: No se puede eliminar una canción. La cola está vacía");
			return null;
		}

		Cancion retirada = frente.getCancion();

		frente = frente.getSiguiente();
		cantidad--;

		// si ya no quedó nadie, el fin también debe quedar en null
		if (frente == null) 
		{
			fin = null;
		}
		return retirada;
	}

	// CONSULTAR EL FRENTE SIN BORRARLO----------
	public Cancion peek() 
	{
		if (isEmpty()) 
		{
			System.out.println("[IsEmpty]: La cola está vacía");
			return null;
		}

		System.out.println("Siguiente en reproducirse: " + frente.getCancion());
		return frente.getCancion();
	}

	// MOSTRAR LAS CANCIONES ALMACENADAS---------------
	public void mostrar() 
	{
		System.out.println("----- COLA DE REPRODUCCION-----");

		if (isEmpty()) 
		{
			System.out.println("No hay canciones en la cola...");
			return;
		}

		NodoCola actual = frente;
		int posicion = 1;

		while (actual != null) 
		{
			System.out.println(posicion + ". " + actual.getCancion());
			actual = actual.getSiguiente();
			posicion++;
		}

		System.out.println("Total de canciones en la cola: " + cantidad);
	}

	// BUSCAR UNA CANCION POR TITULO (sin importar mayúsculas)-------------
	public void buscar(String titulo) 
	{
		if (titulo == null || titulo.isBlank()) 
		{
			System.out.println("BUSCAR (El título no puede estar vacío):");
			return;
		}

		if (isEmpty()) 
		{
			System.out.println("[isEmpty]: La cola está vacía");
			return;
		}

		NodoCola actual = frente;
		int posicion = 1;

		while (actual != null) 
		{
			if (actual.getCancion().getTitulo().equalsIgnoreCase(titulo.trim())) 
			{
				System.out.println("BUSCAR: Encontrada en la posición " + posicion + ": " + actual.getCancion());
				return;
			}
			actual = actual.getSiguiente();
			posicion++;
		}

		System.out.println("BUSCAR: No se encontró la canción \"" + titulo + "\"");
	}

	// VACIAR COMPLETAMENTE LA COLA-------------
	public void clear() 
	{
		int eliminadas = cantidad;
		frente = null;
		fin = null;
		cantidad = 0;

		System.out.println("CLEAR: Cola vaciada");
		System.out.println("Canciones borradas: " + eliminadas);
	}

	// CHECAR LA CANT DE ELEMENTOS-----
	public int getCantidad() 
	{
		return cantidad;
	}
}
package listareproduccion;

public class CancionListaCircular {
	String autor;
	String titulo;
	public CancionListaCircular(String titulo, String autor) {
		super();
		this.autor = autor;
		this.titulo = titulo;
	}
	
	public String toString()
	{
		return titulo + " - " + autor;
	}
}
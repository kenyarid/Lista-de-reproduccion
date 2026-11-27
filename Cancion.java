package listareproduccion;

public class Cancion 
{
	//----------------
	private String titulo;
	private String artista;
	
	// -----------------Getters & Setters-----------------
	public String getTitulo() 
	{
		return titulo;
	}
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	public String getArtista() 
	{
		return artista;
	}
	public void setArtista(String artista) 
	{
		this.artista = artista;
	}
	// -----------------Constructors-----------------
	public Cancion(String titulo, String artista) 
	{
        this.titulo = titulo;
        this.artista = artista;
    }
	
	//--------------toSTring-----------
	public String toString() 
	{
		 return titulo + " - " + artista;
	}
}
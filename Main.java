package listareproduccion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int opcion = 0;
		ListaCircular playList = new ListaCircular();
		playList.agregar("I'm not Paquita (I Bacteria)", "My Majita Romance");
		playList.agregar("The Baconsita Of You", "My Majita Romance");
		playList.agregar("The Bacteria Is Ugly", "My Majita Romance");
		playList.agregar("The Night", "The Quentyn");
		
		playList.siguienteCancion();
		playList.siguienteCancion();
		playList.anteriorCancion();
		while(opcion != 5)
			{
			System.out.println("1- Agregar Canción");
			System.out.println("2- Siguiente Canción");
			System.out.println("3- Anterior Canción"); 
			System.out.println("4- Eliminar Canción");
			System.out.println("5- Salir");
			if(in.hasNextInt());
				opcion = in.nextInt();
			switch(opcion)
			{
				case 1:
				{	
					System.out.println("Nombre canción: " );
					in.nextLine();
					String nombre = in.nextLine();
					System.out.println("Nombre autor: " );
					String autor = in.nextLine();
					playList.agregar(nombre, autor);
					break;
				}
				case 2:
				{
					playList.siguienteCancion();
					break;
				}
				case 3:
				{
					playList.anteriorCancion();
					break;
				}
				case 4:
				{
					System.out.println("Nombre de la canción: ");
					in.nextLine();
					String autor = "";
					String titulo = in.nextLine();
					playList.eliminar(autor,titulo);
					break;
				}
				case 5:
					System.out.println("Adiós Bacteria");
			}
		}		
	}
}

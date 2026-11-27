package listareproduccion;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		PilaHistorial pilaHistorial = new PilaHistorial();
		ListaCircular playList = new ListaCircular();
		boolean ejecutarse = false;
		Scanner in = new Scanner(System.in);
		 playList.agregar("I'm not Paquita (I Bacteria)", "My Majita Romance");
	        playList.agregar("The Baconsita Of You", "My Majita Romance");
	        playList.agregar("The Bacteria Is Ugly", "My Majita Romance");
	        playList.agregar("The Night", "The Quentyn");
		
		while(!ejecutarse) {
			System.out.println("======= MENÚ DE REPRODUCCIÓN ======");
			System.out.println("Seleccione una de las siguientes opciones: ");
			System.out.println("1. Agregar canción. \n2. Eliminar canción. \n3. Reproducir canción anterior. "
					+ "\n4. Reproducir siguiente canción. \n5. Ver canción actual. \n6. Ver historial. \n8. Salir.");
			int opciones = in.nextInt();
			switch(opciones) {
				case 1: 
					{
						System.out.println("Nombre canción: " );
						in.nextLine();
						String nombre = in.nextLine();
						System.out.println("Nombre autor: " );
						String autor = in.nextLine();
						playList.agregar(nombre, autor);
					}
					break;
				case 2: 
					{
						System.out.println("Nombre de la canción: ");
						in.nextLine();
						String autor = "";
						String titulo = in.nextLine();
						playList.eliminar(autor,titulo);
					}
					break;
				case 3: 
					{
						playList.anteriorCancion();
					}
					break;
				case 4: 
					{
						playList.siguienteCancion();
					}
					break;
				case 5: 
					{
						playList.verCancionActualHistorial();
					}
					break;
				case 6: 
					{
						 playList.verHistorialCompleto();
					}
					break;
				case 7: 
					{
						playList.limpiarHistorial();
					}
					break;
				case 8: 
					{
						System.out.println("Saliendo del programa...");
						ejecutarse = true;
					}
					break;
			}
		}
	}
}

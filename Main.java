package listareproduccion;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		PilaHistorial pilaHistorial = new PilaHistorial();
		ListaCircular playList = new ListaCircular();
		boolean ejecutarse = false;
		int opciones;
		Scanner in = new Scanner(System.in);
		 playList.agregar("I'm not Paquita (I Bacteria)", "My Majita Romance");
	        playList.agregar("The Baconsita Of You", "My Majita Romance");
	        playList.agregar("The Bacteria Is Ugly", "My Majita Romance");
	        playList.agregar("The Night", "The Quentyn");
		
		while(!ejecutarse) {
			System.out.println("======= MENÚ DE REPRODUCCIÓN ======");
			System.out.println("Seleccione una de las siguientes opciones: ");
			System.out.println("1. Agregar canción.\n2. Eliminar canción.\n3. Reproducir canción anterior. "
					+ "\n4. Reproducir siguiente canción.\n5. Ver canción actual.\n6. Ver historial.\n7. "
					+ "Borrar historial.\n8. Ver canción siguiente en la cola.\n9. Ver cola de reproducción.\n10. Salir.");
			
			 if (in.hasNextInt()) {
	                opciones = in.nextInt();
	                if (opciones > 10) {
	                	System.out.println("ingrese una opción válida");
	                }
	            } else {
	                System.out.println("Ingrese un número válido.");
	                in.next();
	                continue;
	            }
			switch(opciones) {
				case 1: 
					{
						System.out.println("Título de la canción: " );
						in.nextLine();
						String nombre = in.nextLine();
						System.out.println("Autor: " );
						String autor = in.nextLine();
						playList.agregar(nombre, autor);
					}
					break;
				case 2: 
					{
						System.out.println("Título de la canción: ");
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
						playList.verSiguienteCancion();
					}
					break;
				case 9: 
					{
						playList.verColaReproduccion();
					}
					break;
				case 10: 
					{
						System.out.println("Saliendo del programa...");
						ejecutarse = true;
					}
					break;
			}
		}
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	static public Persona[] listaPersona=new Persona[6];
	static int contador=0;
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		
		if (!leerArchivo("Participantes (1).txt")) {
			return;
		}
		System.out.println("++++Conteo de gula++++"
				+ "Personas que participan = "+ contador);
		
		System.out.println();
		System.out.println();

		System.out.println("[1] Ver registros+2 Actualizar registros[3] Calcular metricas[4] Salir");
		
	}

	private static boolean leerArchivo(String string) {
		
		File file=new File(string);
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String linea=scanner.nextLine();
				String[] partes=linea.split(";");
				
				if(partes[0].trim().isEmpty()) {
					System.out.println("Se omitió una línea sin nombre.");
					continue;
				}
				if(contador >= listaPersona.length) {
					System.out.println("Error: el archivo contiene más de "
							+ listaPersona.length + " personas.");
					return false;
				}
				llenarLista(partes);
			}
		} catch(FileNotFoundException e) {
			System.out.println("No se encontró el archivo: " + file.getAbsolutePath());
			return false;
		}
		return true;
	}

	private static void llenarLista(String[] partes) {
		
		Persona nueva=new Persona(partes[0],null);
		listaPersona[contador]=nueva;
		
		contador ++;
		
	}

}

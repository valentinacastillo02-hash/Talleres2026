import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static Scanner scanner=null;
	static public Alimento[] listaAlimentos=new Alimento[200];
	static public Persona[] listaPersona=new Persona[200];
	static int contador=0;
	static int contComida=0;
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		// TODO Auto-generated method stub
		if (!leerArchivoParticipante("Participantes (1).txt")) {
			return;
		}
		if (!leerArchivoComida("Consumido.txt")) {
			return;
		}
		int opcion=1;
		do {
		System.out.println("++++Menú Principal++++\r\n"
		+"1)Ver registros.\r\n"
		+"2)Actualizar registros\r\n"
		+"3)Calcular métricas\r\n"
		+"4)Salir\r\n"
		+ "Personas que participan = "+ contador);
		System.out.println();
		System.out.println();
		scanner=new Scanner(System.in);
		System.out.print("Escoja la opción que desee:");
		try {
		opcion=scanner.nextInt();
		System.out.println();
		}catch(Exception e) {
			System.out.println("Error al ingresar el dato");
		}
		while(4<opcion || opcion<0) {
			System.out.print("Error.Intente de nuevo.");
			try {
				opcion=scanner.nextInt();
				System.out.println();
				}catch(Exception e) {
					System.out.println("Error al ingresar el dato");
					}
			}
			switch(opcion) {
			case 1:
				verRegistro();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				salir();
				opcion=0;
				break;
			}
		}while(0<opcion && opcion<5);
				
	}
		
	private static boolean leerArchivoComida(String string) {
		File file=new File(string);
		try (Scanner scanner = new Scanner(file)) {
			while(scanner.hasNextLine()) {
				String linea=scanner.nextLine();
				String[] partes=linea.split(";");
				
				if(partes[0].trim().isEmpty()) {
					System.out.println("Se omitió una línea sin nombre.");
					continue;
				}
				if(contComida >= listaAlimentos.length) {
					System.out.println("Error: el archivo contiene más de "
							+ listaAlimentos.length + " personas.");
					return false;
				}
				llenarListaAlimento(partes,listaAlimentos);
			}
		} catch(FileNotFoundException e) {
			System.out.println("No se encontró el archivo: " + file.getAbsolutePath());
			return false;
		}
		return true;
	}

	private static void llenarListaAlimento(String[] partes, Alimento[] listaAlimentos2) {
		Persona comensal=new Persona(partes[1],null);
		Alimento comida=null;
		if (partes.length ==5) {
		comida=new Alimento(partes[0],comensal,Float.parseFloat(partes[2]),Float.parseFloat(partes[3]),partes[4]);
		}
		if(partes.length ==4) {
			comida=new Alimento(partes[0],comensal,Float.parseFloat(partes[2]),partes[3]);
		}
		listaAlimentos[contComida]=comida;
		
		contComida++;
	}

	private static void verRegistro() {
		// TODO Auto-generated method stub
		int escoger=0;
		do {
		System.out.println("----observar registros----\r\n"
				+ "  [1] Choripanes\r\n"
				+ "  [2] Terremotos\r\n"
				+ "  [3] Volver al menu principal\r\n"
				+ "--------------------------------");
		
		
		try {
		System.out.print("escoja opción: ");
		escoger=scanner.nextInt();
		while(3<escoger || escoger<1 ) {
			try {
				System.out.print("Opción incorrecta.Intente denuevo ");
				escoger=scanner.nextInt();
			}catch(Exception e) {
				System.out.println("Error. intente de nuevo");
				}
			}
		}catch(Exception e) {
			System.out.println("Error. intente de nuevo");
			}
		
		switch(escoger) {
		case 1:
			System.out.println("Choripanes");
			choripanes();
			break;
		case 2:
			terremoto();
			break;
		case 3:
			break;
		}
		
		
		}while(escoger !=3);
	}

	private static void terremoto() {
		
		
	}

	private static void choripanes() {
		System.out.println("Mostrando Choripanes (Comensal,Largo,Ancho,): ");
		String formato = "%-15s %-15s %-15s %-15s%n"; 
		System.out.printf(formato,"Comensal","Largo","Ancho","Calorias");
		for (int i = 0; i < contComida; i++) {
			if(listaAlimentos[i] != null) {
				int posicion=i+1;
				System.out.print("["+posicion+"]  ");
				System.out.printf(formato);
			}else {
				System.out.println("Linea Vacia");
			}
			
			
			
		}
		
	}

	private static void salir() {
		System.out.println("Adios");
		
		
	}

private static boolean leerArchivoParticipante(String string) {
		
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
				llenarLista(partes,listaPersona);
			}
		} catch(FileNotFoundException e) {
			System.out.println("No se encontró el archivo: " + file.getAbsolutePath());
			return false;
		}
		return true;
	}


	private static void llenarLista(String[] partes, Persona[] listaPersona2) {
		// TODO Auto-generated method stub
		Persona nueva=new Persona(partes[0],null);
		listaPersona[contador]=nueva;
		
		contador ++;
		
	}

}

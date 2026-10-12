import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
		while(4<opcion || opcion<1) {
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
				actualizarRegistros();
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
		
	private static void actualizarRegistros() {
		int opc=0;
		do {
		System.out.println("Cambiar registros.");
		System.out.println();
		System.out.println("[1] Agregar al registro permanente.\r\n"
						 + "[2] Modificar un dato del registro permanente.\r\n"
						  +"[3] Eliminar un dato del registro  permanente.\r\n"
						  +"[4] Volver al menú principal.\r\n");
		System.out.println();
		try {
			opc=scanner.nextInt();
		}catch(Exception e) {
			System.out.println("Error al ingresar el dato");
		}
		while(4<opc || opc<1) {
			System.out.print("Error.Intente de nuevo.");
			try {
				opc=scanner.nextInt();
				System.out.println();
				}catch(Exception e) {
					System.out.println("Error al ingresar opcion /dato");
					}
			}
			switch(opc) {
			case 1:
				agregarDato();
				break;
			case 2:
				modificarDato();
				break;
			case 3:
				//EliminarDato
				break;
			case 4:
				salir();
				opc=0;
				break;
			}
		}while(opc<1 || opc>4);
	}

	private static void modificarDato() {
		// TODO Auto-generated method stub
		
	}

	private static void agregarDato() {
		// TODO Auto-generated method stub
		int agreg=0;
		
		do {
			System.out.println("Tipo de dato a Agregar:");
			System.out.println();
			System.out.println("[1] Choripan.\r\n"
							 + "[2] Terremoto.\r\n"
							  +"[3] Cancelar.\r\n"
							  );
			System.out.println();
			try {
				agreg=scanner.nextInt();
			}catch(Exception e) {
				System.out.println("Error al ingresar el dato");
			}
			while(3<agreg || agreg<1) {
				System.out.print("Error.Intente de nuevo.");
				try {
					agreg=scanner.nextInt();
					System.out.println();
					}catch(Exception e) {
						System.out.println("Error al ingresar opcion /dato");
						}
				}
				switch(agreg) {
				case 1:
					sobreEscriubir("Choripan");
					break;
					
				case 2:
					sobreEscriubir("Terremoto");
					break;
				case 3:
					//agreg=0;
					break;
				}
			}while(agreg<1 || agreg>3);
		
	}

	private static void sobreEscriubir(String string) {
		Alimento agregar=crearNuevoDato(string);
		
		try {
			FileWriter filewrite=new FileWriter("Consumido.txt");
			BufferedWriter cr=new BufferedWriter(filewrite);
			for (int i = 0; i < contComida; i++) {
				if(listaAlimentos[i].getTipoAlimento().equalsIgnoreCase("Terremoto")) {
				cr.write(listaAlimentos[i].getTipoAlimento()+";"+listaAlimentos[i].getPersonaUno().getNombrePersona()+";"+listaAlimentos[i].getLitros()+";"+listaAlimentos[i].getFechaConsumo());
				}
				if(listaAlimentos[i].getTipoAlimento().equalsIgnoreCase("Choripan")) {
					cr.write(listaAlimentos[i].getTipoAlimento()+";"+listaAlimentos[i].getPersonaUno().getNombrePersona()+";"+listaAlimentos[i].getLargo()+";"+listaAlimentos[i].getAncho()+";"+listaAlimentos[i].getFechaConsumo());
					}
				cr.newLine();
			}
			cr.close();
		}catch(Exception e) {
			System.out.println("Error.El Archivo txt no es compatible. ");
		}
		
		
	}

	private static Alimento crearNuevoDato(String tAlimento) {
		Alimento nuevo=null;
		int persona=0;
		String tipoComidaNueva=tAlimento;
		Persona nombrePersona=null;
		float Largo=0;
		float Ancho=0;
		float Litros=0;
		String fechaConsumo=null;
		int finalp=contador +1;
			System.out.println("Consumidores: ");
			System.out.println();
			for (int i = 0; i < contador; i++) {
				int posición=i+1;
				System.out.print("["+posición+"]");
				System.out.println(listaPersona[posición].getNombrePersona());
				
				System.out.println();
			}
				System.out.println("Señale al consumidor: ");
				try {
					persona=scanner.nextInt();
					
					
				}catch(Exception e) {
					System.out.println("Error al seleccionar el nombre.Formato  incorrecto.");
				}
				while(contador<persona || persona<1) {
					try {
						System.out.println("Valor invalido. Intente denuevo");
						persona=scanner.nextInt();
						
					}catch(Exception e) {
						System.out.println("Error al seleccionar el nombre.Formato  incorrecto.");
					}
					
				}
				persona--;
				nombrePersona=listaPersona[persona];
				if(tipoComidaNueva.equalsIgnoreCase("Choripan")) {
				System.out.println("Escoja el Largo: ");
				try {
					Largo=scanner.nextFloat();
				}catch(Exception e) {
					System.out.println("Error. Ingrese dato decimal.");
					}
				System.out.println("Ingrese el ancho");
				try {
					Ancho=scanner.nextFloat();
				}catch(Exception e) {
					System.out.println("Error. Ingrese dato decimal.");
					}
				}
				if(tipoComidaNueva.equalsIgnoreCase("Terremoto")) {
					System.out.println("Ingrese la cantidad de litros");
					try {						
						Litros=scanner.nextFloat();
					}catch(Exception e) {
						System.out.println("Error. Ingrese dato decimal.");
						}
				}
				System.out.println("Ingrese la fecha(YYYY-MM-DD):");
				try {
					fechaConsumo=scanner.nextLine();
				}catch(Exception e) {
					System.out.println("Error. Ingrese dato decimal.");
					}
				if(tipoComidaNueva.equalsIgnoreCase("Choripan")) {
					nuevo=new Alimento(tipoComidaNueva,nombrePersona,Largo,Ancho,fechaConsumo,0);
					return nuevo;
					
				}
				if(tipoComidaNueva.equalsIgnoreCase("Terremoto")) {
					nuevo=new Alimento(tipoComidaNueva,nombrePersona,Litros,fechaConsumo,0);
					return nuevo;
				}
				
				agregarLista(nuevo);
				return null;
			
		
	}

	private static void agregarLista(Alimento nuevo) {
		for (int i = 0; i < listaAlimentos.length; i++) {
			if(listaAlimentos[i] ==null) {
				listaAlimentos[i]=nuevo;
				contComida++;
				break;
			}
		}
		
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
		
		comida=new Alimento(partes[0],comensal,Float.parseFloat(partes[2]),Float.parseFloat(partes[3]),partes[4],0);
		}
		if(partes.length ==4) {
			
			comida=new Alimento(partes[0],comensal,Float.parseFloat(partes[2]),partes[3],0);
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
		int conteoTerremoto=0;
		float totalLitros=0;
		System.out.println("Mostrando terremoto (Comensal,Litros,Fecha,Calorias): ");
		String formato = "%-15s %-15s %-15s%n"; 
		System.out.printf(formato,"Comensal","Litros","Calorias");
		
		for (int i = 0; i < contComida; i++) {
			if(listaAlimentos[i] != null) {
				int posicion=i+1;
				
				if(listaAlimentos[i].getTipoAlimento().equalsIgnoreCase("Terremoto")) {
				System.out.print("["+posicion+"]  ");
				System.out.printf(formato,listaAlimentos[i].getPersonaUno().getNombrePersona(),listaAlimentos[i].getLitros(),listaAlimentos[i].getFechaConsumo());
				conteoTerremoto ++;
				totalLitros+=listaAlimentos[i].getLitros();
				}
			}else {
				System.out.println("Linea Vacia");
			}	
		}
		System.out.println("Terremotos registrados: "+conteoTerremoto);
		System.out.println("Total de litros registrados: "+totalLitros+"L");
		System.out.println("++++++++++++++++");
		
		
	}

	private static void choripanes() {
		int conteoChoripanes=0;
		System.out.println("Mostrando Choripanes (Comensal,Largo,Ancho,Fecha,Calorias): ");
		String formato = "%-15s %-15s %-15s %-15s%n"; 
		System.out.printf(formato,"Comensal","Largo","Ancho","Calorias");
		
		for (int i = 0; i < contComida; i++) {
			if(listaAlimentos[i] != null) {
				int posicion=i+1;
				
				if(listaAlimentos[i].getTipoAlimento().equalsIgnoreCase("Choripan")) {
				System.out.print("["+posicion+"]  ");
				System.out.printf(formato,listaAlimentos[i].getPersonaUno().getNombrePersona(),listaAlimentos[i].getLargo(),listaAlimentos[i].getAncho(),listaAlimentos[i].getFechaConsumo());
				conteoChoripanes++;
				}
			}else {
				System.out.println("Linea Vacia");
			}	
		}
		System.out.println("Choripanes registrados: "+conteoChoripanes);
		System.out.println("++++++++++++++++");
		
		
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

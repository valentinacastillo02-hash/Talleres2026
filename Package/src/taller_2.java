
package taller2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class taller_2 {
	static GestorConsumo gestor = new GestorConsumo();

    static String[] nombreParticipantes = new String[200];
    static int cantidadParticipantes = 0;
    
    

    public static void main(String[] args) {
    	System.out.println("Carpeta de trabajo: " + System.getProperty("user.dir"));
    	System.out.println("Existe Participantes.txt: "
    	        + new File("Participantes.txt").exists());
    	System.out.println("Existe Consumido.txt: "
    	        + new File("Consumido.txt").exists());
    	leerParticipantes();
	    leerConsumidos();
        menu();
    }

    public static void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("BIENVENIDO A LA FONDA DEL PAPU");
            System.out.println("[1] Ver registros");
            System.out.println("[2] Actualizar registros");
            System.out.println("[3] Calcular metricas");
            System.out.println("[4] Salir");
            System.out.print("Seleccione una opcion: ");

            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        verRegistros(teclado);
                        break;
                    case 2:
                    	actualizarRegistros (teclado);
                        break;

                    case 3:
                        // Calcular metricas
                        break;

                    case 4:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println(
                            "Error: seleccione una opcion entre 1 y 4."
                        );
                }

            } else {
                System.out.println(
                    "Error debe ingresar un numero entero."
                );

                teclado.nextLine();
                opcion = 0;
            }

        } while (opcion != 4);

        teclado.close();
    }
    
    
    public static void eliminarRegistro (Scanner teclado) {
    	int opcion;
    	System.out.println("Tipo de registro a eliminar:");
    	System.out.println("[1] Choripan");
    	System.out.println("[2] Terremoto");
    	System.out.println("[3] Cancelar");
    	
    	System.out.print("Seleccione una opcion: ");
	    opcion  = teclado.nextInt();
	    
	    switch (opcion) {
	    case 1:
	    	 // eliminar choripan
	    	break;
	    case 2:
	    	 // Eliminar terremoto
	    	break;
	    case 3:
            System.out.println("Saliendo...");
            break;

        default:
            System.out.println("Opcion no valida.");
            break;
	    
	    	
	    }
	   
    }
    
    public static void editarTerremoto (Scanner teclado) {
    	
    }
    public static void editarChoripan (Scanner teclado) {
    	int num;
    	
    	gestor.mostrarChoripanes();
    	
	    System.out.print("Seleccione el registro a editar (0 para cancelar): ");
	    num = teclado.nextInt();
    	
    	
    }
    
    
    public static void editarRegistro (Scanner teclado) {
    	int opcion;
    	System.out.println("Tipo de registro a editar:");
    	System.out.println("[1] Choripan");
    	System.out.println("[2] Terremoto");
    	System.out.println("[3] Cancelar");
    	
    	System.out.print("Seleccione una opcion: ");
	    opcion  = teclado.nextInt();
	    
	    switch (opcion) {
	    case 1:
	    	 editarChoripan(teclado);
	    	break;
	    case 2:
	    	editarTerremoto(teclado);
	    	break;
	    case 3:
            System.out.println("Saliendo...");
            break;

        default:
            System.out.println("Opcion no valida.");
            break;
	    
	    	
	    }
    }
    
    
    public static void agregarTerremoto (Scanner teclado) {
    	String consumidor;
    	int opcionConsumidor;
    	double litros;
    	String fecha;
    	
    	System.out.println();
 	    System.out.println("Seleccione un consumidor:");
 	    
 	    for (int i = 0; i < cantidadParticipantes; i++) {
 	        System.out.println("[" + (i + 1) + "] " + nombreParticipantes[i]);
 	    }
 	   System.out.print("Ingrese una opcion: ");
	    opcionConsumidor = teclado.nextInt();
	    
	    consumidor = nombreParticipantes[opcionConsumidor - 1];
	    
	    System.out.println("Litros de terremoto (L): ");
	    litros = teclado.nextDouble();
	    
	    teclado.nextLine(); 
	    System.out.println("Fecha (YYYY-MM-DD): ");
	    fecha  = teclado.nextLine();
	   
	    Terremoto nuevo = new Terremoto (consumidor,fecha,litros);
	    gestor.agregarTerremoto(nuevo);
	    
	    System.out.println(">> Registro agregado correctamente y guardado en Consumido.txt");
	    System.out.println("Terremoto | " + consumidor +"|"+ litros +"|" + fecha);
    	
	    // Falta validar datos 
    }
    public static void agregarChoripan (Scanner teclado) {
    	  String consumidor;
    	    int opcionConsumidor;
    	    double largo;
    	    double ancho;
    	    String fecha;
    	    

    	    System.out.println();
    	    System.out.println("Seleccione un consumidor:");
    	    
    	    for (int i = 0; i < cantidadParticipantes; i++) {
    	        System.out.println("[" + (i + 1) + "] " + nombreParticipantes[i]);
    	    }
    	    
    	    System.out.print("Ingrese una opcion: ");
    	    opcionConsumidor = teclado.nextInt();
    	// falta validar datos
	    consumidor = nombreParticipantes[opcionConsumidor - 1];
	    //Agregar al nuevo choripan
	    
	    System.out.println("Largo del choripan (cm): ");
	    largo = teclado.nextDouble();
	    System.out.println("ancho del choripan(cm): ");
	    ancho = teclado.nextDouble();
	    teclado.nextLine(); 
	    System.out.println("Fecha (YYYY-MM-DD): ");
	    fecha  = teclado.nextLine();
	    
	    Choripan nuevo = new Choripan(consumidor, fecha, largo, ancho);
	    gestor.agregarChoripan(nuevo);
	    
	    
	    System.out.println(">> Registro agregado correctamente y guardado en Consumido.txt");
	    System.out.println("Choripan | " + consumidor + "|"+ largo + " cm x"+ ancho +  " cm |" + fecha);
	    //Falta mostar las calorias 
	    
    }
    
    public static void agregarRegistro (Scanner teclado) {
    	int eleccion;
   
    	System.out.println("Tipo de registro: ");
    	System.out.println("[1] Choripan");
    	System.out.println("[2] Terremoto");
    	System.out.println("[3] Cancelar");
    	
     	System.out.print("Seleccione una opcion: ");
	    eleccion = teclado.nextInt();
	    
	    switch (eleccion) {
        case 1:
        	agregarChoripan(teclado);
        	    break;
          
        case 2:
        	agregarTerremoto (teclado);
            break;

        case 3:
            System.out.println("Saliendo...");
            break;

        default:
            System.out.println("Opcion no valida.");
            break;
    }
    	
    }
    
    public static void actualizarRegistros (Scanner teclado) {
    	int opcion;
    	System.out.println("============ ACTUALIZAR REGISTROS =================");
    	System.out.println("[1] Agregar");
    	System.out.println("[2] Editar");
    	System.out.println("[3] Eliminar");
    	System.out.println("[4] Volver al menu principal");
    	System.out.println("============================================");
    	
	   	System.out.print("Seleccione una opcion: ");
	    opcion = teclado.nextInt();
	    
	    switch (opcion) {
	        case 1:
	        	 agregarRegistro(teclado);
	            break;
	        case 2:
	             editarRegistro(teclado);
	            break;
	        case 3:
	             eliminarRegistro(teclado);
	            break;
	        case 4:
	            System.out.println("Volviendo al menu principal...");
	            break;
	        default:
	            System.out.println("Opcion no valida.");
	            break;
	    }
    }
    
    
    public static void verRegistros (Scanner teclado) {
    	int opcion;
    	
    	System.out.println("============ VER REGISTROS =================");
    	System.out.println("[1] Choripanes");
    	System.out.println("[2] Terremotos");
    	System.out.println("[3] Volver al menu principal");
    	System.out.println("============================================");
    	
    	 System.out.print("Seleccione una opcion: ");
	     opcion = teclado.nextInt();
	     
	     switch (opcion) {
	     case 1:
	    	    gestor.mostrarChoripanes();
	    	    break;

	    	case 2:
	    	    gestor.mostrarTerremotos();
	    	    break;

	        case 3:
	            System.out.println("Volviendo al menu principal");
	            break;

	        default:
	            System.out.println("Opcion no valida.");
	    }	
    }
    


public static void leerConsumidos() {
    File archivo = new File("Consumido.txt");

    try (Scanner lector = new Scanner(archivo)) {
        while (lector.hasNextLine()) {
            String linea = lector.nextLine();

            if (linea.trim().isEmpty()) {
                continue;
            }

            String[] datos = linea.split(";");

            try {
                if (datos[0].equalsIgnoreCase("Terremoto")
                        && datos.length == 4) {

                    String consumidor = datos[1];
                    double litros = Double.parseDouble(datos[2]);
                    String fecha = datos[3];

                    Terremoto terremoto =
                            new Terremoto(consumidor, fecha, litros);

                    if (!gestor.agregarTerremoto(terremoto)) {
                        System.out.println(
                                "No se pueden agregar mas terremotos.");
                        break;
                    }

                } else if (datos[0].equalsIgnoreCase("Choripan")
                        && datos.length == 5) {

                    String consumidor = datos[1];
                    double largo = Double.parseDouble(datos[2]);
                    double ancho = Double.parseDouble(datos[3]);
                    String fecha = datos[4];

                    Choripan choripan =
                            new Choripan(consumidor, fecha, largo, ancho);

                    if (!gestor.agregarChoripan(choripan)) {
                        System.out.println(
                                "No se pueden agregar mas choripanes.");
                        break;
                    }

                } else {
                    System.out.println("Formato incorrecto: " + linea);
                }

            } catch (NumberFormatException e) {
                System.out.println("Numero invalido en: " + linea);
            }
        }

    } catch (FileNotFoundException e) {
        System.out.println("No se encontro Consumidos.txt");
        return;
    }

    System.out.println("Lectura de consumos finalizada.");
}

	public static void leerParticipantes() {
	    if (cantidadParticipantes > 0) {
	        System.out.println("Los archivos ya fueron cargados.");
	        return;
	    }
	
	    File archivo = new File("Participantes.txt");
	
	    try (Scanner lector = new Scanner(archivo)) {
	        while (lector.hasNextLine()) {
	            if (cantidadParticipantes >= 200) {
	                System.out.println("Se alcanzo la capacidad maxima de participantes.");
	                break;
	            }
	
	            String linea = lector.nextLine().trim();
	
	            if (!linea.isEmpty()) {
	                nombreParticipantes[cantidadParticipantes] = linea;
	                cantidadParticipantes++;
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("No se encontro Participantes.txt");
	        return;
	    }
	
	    System.out.println(cantidadParticipantes + " participantes cargados.");
	}
}

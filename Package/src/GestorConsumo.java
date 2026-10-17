package taller2;

public class GestorConsumo {
	
	private Choripan[] choripanes;
    private Terremoto[] terremotos;

    private int cantidadChoripanes;
    private int cantidadTerremotos;
   
   

    public GestorConsumo() {
        choripanes = new Choripan[200];
        terremotos = new Terremoto[200];

        cantidadChoripanes = 0;
        cantidadTerremotos = 0;
    }
    
    
    public boolean agregarChoripan(Choripan choripan) {
    	 
        if (cantidadChoripanes < 200) {
            choripanes[cantidadChoripanes] = choripan;
            cantidadChoripanes++;
            return true;
        }
        return false;
    }
    
    public boolean agregarTerremoto(Terremoto terremoto) {
        if (cantidadTerremotos < 200) {
            terremotos[cantidadTerremotos] = terremoto;
            cantidadTerremotos++;
            return true;
        }

        return false;
    }
    public void mostrarChoripanes() {
        System.out.println();
        System.out.println("=============== CHORIPANES =================");
        System.out.printf("%-4s %-13s %-8s %-8s %-12s %s%n",
                "#", "Consumidor", "Largo", "Ancho", "Fecha", "KCal");

        for (int i = 0; i < cantidadChoripanes; i++) {
            Choripan c = choripanes[i];

            System.out.printf("%-4d %-13s %-8s %-8s %-12s %6.2f%n",
                    i + 1,
                    c.getConsumidor(),
                    c.getLargo() + " cm",
                    c.getAncho() + " cm",
                    c.getFecha(),
                    c.calcularKcal());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("  Total: " + cantidadChoripanes
                + " choripanes registrados");
        System.out.println("==================================================");

        System.out.println();
        System.out.print("Presione ENTER para continuar...");
        new java.util.Scanner(System.in).nextLine();
    }
  
    public void mostrarTerremotos() {
    		double totallitros = 0;
    		try {
    	    System.out.println();
    	    System.out.println("=============== TERREMOTOS =================");
    	    System.out.printf("%-4s %-13s %-8s %-12s %s%n",
    	            "#", "Consumidor", "Litros", "Fecha", "KCal");

    	    for (int i = 0; i < cantidadTerremotos; i++) {
    	        System.out.printf("%-4d %-13s %-8s %-12s %6.2f%n",
    	                i + 1,
    	                terremotos[i].getConsumidor(),
    	                terremotos[i].getLitros() + " L",
    	                terremotos[i].getFecha(),
    	                terremotos[i].calcularKcal());
    	        
    	        totallitros += terremotos[i].getLitros();
    	    }

    	    System.out.println("---------------------------------------------");
    	    System.out.println("Total: " + cantidadTerremotos
    	            + " terremotos registrados");
    	    System.out.printf("Total de litros: %.2f L%n", totallitros);
    	    System.out.println("=============================================");
    		}catch(Exception e) {
    			System.out.println("Error al mostrar el archivo.");
    			return;
    		}
    	} 
    
   public  void sobreEscriubir(String string,boolean chor,boolean ter) {
		int contador=0;
		
		try {
			
			FileWriter filewrite=new FileWriter("Consumido.txt");
			BufferedWriter cr=new BufferedWriter(filewrite);
			for (int i = 0; i < 200; i++) {
				if(chor) {
					cr.write("Choripan"+";"+choripanes[i].getConsumidor()+";"+choripanes[i].getLargo()+";"+choripanes[i].getAncho()+";"+choripanes[i].getFecha());
				}
				
			if(!chor) {
				contador=cantidadTerremotos;
			}
			cr.write("Terremoto"+";"+terremotos[i].getConsumidor()+";"+terremotos[i].getLitros()+";"+terremotos[i].getFecha());
					}
				cr.newLine();
				
   			
		
			cr.close();
		}catch(Exception e) {
			System.out.println("Error.El Archivo txt no puede ser leido. ");
			return;
		}
		
   	}
   public void mostrarEditar(int num,boolean chor, boolean terr) {
	   Scanner sca=new Scanner(System.in);
	   String nombre=null;
	   double largo=0;
	   double ancho=0;
	   String fecha=null;
	   double litros=0;
	   if(chor) {
	   System.out.println("Registro seleccionado: Choripanes|"+choripanes[num].getConsumidor()+"|"+choripanes[num].getLargo()+"|"+choripanes[num].getAncho()+"|"+choripanes[num].getFecha());
	   System.out.println("Deje el campo vacio para mantener el valor actual.");
	   
	   boolean llenada=false;
	   
	   System.out.println("Consumidor Ingrese nuevo nombre: ");
	   try {
		   
		   nombre=sca.nextLine();
		   
	   }catch(Exception e) {
		   System.out.println("Error. Se trinen que ingresar un palabra nombre");
	   }
	   if(nombre !=null) {
		   llenada =true;
		   if(llenada) {
			   choripanes[num].setConsumidor(nombre);
			   
		   }   
	   }
	   System.out.println("Largo. Ingrese nuevo Largo: ");
	   try {
		   
		   largo=sca.nextDouble();
		   
	   }catch(Exception e) {
		   System.out.println("Error. Se tiene que ingresar un número");
	   }
	   if(largo!= 0) {
		   llenada =true;
		   if(llenada) {
			   choripanes[num].setLargo(largo);
		   }
	   }
	   System.out.println("Ancho. Ingrese nuevo Ancho: ");
	   try {
		   
		   ancho=sca.nextDouble();
		   
	   }catch(Exception e) {
		   System.out.println("Error. Se tiene que ingresar un número");
	   }
	   if(ancho!= 0) {
		   llenada =true;
		   if(llenada) {
			   choripanes[num].setAncho(largo);
		   }
	   }
	   
	   System.out.println("Fecha. Ingrese nuevo Fecha( (YYYY-MM-DD)): ");
	   try {
		   
		   fecha=sca.nextLine();
		   
	   }catch(Exception e) {
		   System.out.println("Error. Se tiene que ingresar de manera correcta.");
	   }
	   if(ancho!= 0) {
		   llenada =true;
		   if(llenada) {
			   choripanes[num].setFecha(fecha);
		   }
	   }
	   
	   if(!llenada) {
		   System.out.println("Se matiene igual los datos");
	   			}else {
	   				System.out.println("Registro Actualizado: Choripan|"+choripanes[num].getConsumidor()+"|"+choripanes[num].getLargo()+"|"+choripanes[num].getAncho()+"|"+choripanes[num].getFecha());
	   			}
	   
	   	}else {
	   		System.out.println("Registro seleccionado: "+terremotos[num].getConsumidor()+"|"+choripanes[num].getConsumidor()+"|"+terremotos[num].getLitros()+"|"+terremotos[num].getFecha());
	 	   System.out.println("Deje el campo vacio para mantener el valor actual.");
	 	   
	 	   boolean llenada=false;
	 	   
	 	   System.out.println("Consumidor Ingrese nuevo nombre: ");
	 	   try {
	 		   
	 		   nombre=sca.nextLine();
	 		   
	 	   }catch(Exception e) {
	 		   System.out.println("Error. Se trinen que ingresar un palabra nombre");
	 	   }
	 	   if(nombre !=null) {
	 		   llenada =true;
	 		   if(llenada) {
	 			  terremotos[num].setConsumidor(nombre);
	 			   
	 		   }   
	 	   }
	 	   System.out.println("Litros. Ingrese nuevo Litros: ");
	 	   try {
	 		   
	 		  litros=sca.nextDouble();
	 		   
	 	   }catch(Exception e) {
	 		   System.out.println("Error. Se tiene que ingresar un número");
	 	   }
	 	   if(largo!= 0) {
	 		   llenada =true;
	 		   if(llenada) {
	 			  terremotos[num].setLitros(litros);;
	 		   }
	 	   }
	 	   
	 	   
	 	   System.out.println("Fecha. Ingrese nuevo Fecha( (YYYY-MM-DD)): ");
	 	   try {
	 		   
	 		   fecha=sca.nextLine();
	 		   
	 	   }catch(Exception e) {
	 		   System.out.println("Error. Se tiene que ingresar de manera correcta.");
	 	   }
	 	   if(ancho!= 0) {
	 		   llenada =true;
	 		   if(llenada) {
	 			  terremotos[num].setFecha(fecha);
	 		   }
	 	   }
	 	   
	 	   if(!llenada) {
	 		   System.out.println("Se matiene igual los datos");
	 	   			}else {
	 	   				System.out.println("Registro Actualizado: Terremoto| "+terremotos[num].getConsumidor()+"|"+choripanes[num].getConsumidor()+"|"+terremotos[num].getLitros()+"|"+terremotos[num].getFecha());
	 	   			}
		   
	   		}
	   
   		}


   public void eliminarChoripan(int num) {
	   System.out.println("Confirma la eliminacion: "+choripanes[num].getChoripan()+"|"+choripanes[num].getConsumidor()+"|"+choripanes[num].getLargo()+"|"+choripanes[num].getAncho()+"|"+choripanes[num].getFecha());
	   boolean chor=true;
	   boolean ter=false;
	   choripanes[num]=null;
	   
	   for (int i = num; i < choripanes.length; i++) {
		   if(choripanes[num+1] !=null ) {
			   choripanes[num]=choripanes[num+1];
		   }
		   cantidadChoripanes--;
	   		}
	   sobreEscriubir("Consumido",chor,ter);
	   System.out.println("Registro eliminado correctamente. Cambios guardados en Consumido.txt");
   		}


   public void eliminarterremoto(int num) {
	   System.out.println("Registro seleccionado:"+terremotos[num].getProducto()+"|"+terremotos[num].getConsumidor()+"|"+choripanes[num].getConsumidor()+"|"+terremotos[num].getLitros()+"|"+terremotos[num].getFecha());
	   boolean chor=false;
	   boolean ter=true;
	   terremotos[num]=null;
	   
	   
	   for (int i = num; i < terremotos.length; i++) {
		   if(terremotos[num+1] !=null ) {
			   terremotos[num]=terremotos[num+1];
		   }
		   cantidadTerremotos--;
	   		}
	   sobreEscriubir("Consumido",chor,ter);
	   System.out.println("Registro eliminado correctamente. Cambios guardados en Consumido.txt");
	
   		}


   public void getcantChoripanes() {
	System.out.println("La cantidad total de choripanes son "+cantidadChoripanes);
	
   }


   public void getcantTerremotos() {
	   System.out.println("La cantidad total de Terremotos son "+cantidadTerremotos);
	
   		}


  
public void diasBorrachos(Consumidor consumidor) {
	   int cantDias=0;
	   
	   double cantGuardada=0;
	   for (int i = 0; i < cantidadTerremotos; i++) {
		   
		   String  fechaBorracho=terremotos[i].getFecha();
		   boolean revisado=false;
		   if(consumidor.getNombre().equalsIgnoreCase(terremotos[i].getConsumidor())) {
		   for (int j = 0; j < i; j++) {
			   if(terremotos[j].getFecha().equals(fechaBorracho)) {
				   revisado=true;
				   break;
			   }
		}
		   if(!revisado) {
			   cantGuardada=cantLitros(fechaBorracho);
			   if(cantGuardada>=2.0) {
				   
				   cantDias++;
				   
			   }
			   
		   }
		   
		  
		   	}
		   
	   }
	   String format="%-15s %-15s %-15s %n"; 
	   System.out.printf(format,consumidor.getNombre(),cantDias,cantGuardada);
	   
		
	}
   
   public double cantLitros(String fechaBorracho) {
		double totalLitros=0;
		
		for (int i = 0; i < cantidadTerremotos; i++) {
			if(terremotos[i].getFecha().equalsIgnoreCase(fechaBorracho)){
				totalLitros+=terremotos[i].getLitros();
				if(totalLitros>2) {
					
					
				}
			}
			
		}
		return totalLitros;
		
		
		}
		
	
  
   
   }
	
    





	


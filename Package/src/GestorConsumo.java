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
    	} // Faltan los litros 
    
}



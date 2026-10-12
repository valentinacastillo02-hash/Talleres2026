package taller2;

public abstract class consumo {
	private String consumidor ;
	private String fecha;
	
	// constructor 
	public consumo(String consumidor, String fecha) { // guarda fecha y consumidor cuando se crea un consumo 
        this.consumidor = consumidor;
        this.fecha = fecha;
    }
	  public String getConsumidor() { // obtener el nombre del consumidor
	        return consumidor;
	    }

	    
	    public String getFecha() { // obtener la fecha 
	        return fecha;
	    }
	
	 // clases hijas 
	public abstract void Mostar(); {
		//Esto se ve mas como clases de una interfase. No se debía ocupar herencia
		
	}
	
	public abstract double CalcularCalorias (); {
		
	}
	
	
}

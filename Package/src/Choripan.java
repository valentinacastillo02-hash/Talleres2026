package taller2;

public  class Choripan {
	private String Choripan="Choripan";
	private double largo;
	private double ancho;
	private String fecha;
	private String consumidor;
	

    // Constructor
    public Choripan(String choripan,String consumidor, String fecha,double largo, double ancho) {
        this.Choripan="Choripan";
    	this.consumidor = consumidor;
        this.fecha = fecha;
        this.largo = largo;
        this.ancho = ancho;
    }
    public String getConsumidor() { // consulta 
        return consumidor;
    }
    
    public String getFecha() {//obtener fecha
    	return fecha;
    }
    
    public double getLargo() {//obtener largo
    	return largo;
    }
    
    public double getAncho() {//obtener Ancho
    	return ancho;
    }
    public void setLargo(double largo) { //cambiar largo
        if (largo > 0) {
            this.largo = largo;
        }
    }

    public void setAncho(double ancho) {//cambiar ancho
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }
    
    public double calcularKcal(){//calcular calorias de choripanes
    	return (largo * ancho) / 3.0;
    }
	public String getChoripan() {//Obtener choripan
		return Choripan;
	}
	public void setConsumidor(String consumidor) {//Cambiar consumidor
		this.consumidor = consumidor;
	}
	public void setFecha(String fecha) {//Cambiar fecha
		this.fecha = fecha;
	}       
}

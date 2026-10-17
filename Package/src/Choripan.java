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
    
    public String getFecha() {
    	return fecha;
    }
    
    public double getLargo() {
    	return largo;
    }
    
    public double getAncho() {
    	return ancho;
    }
    public void setLargo(double largo) { 
        if (largo > 0) {
            this.largo = largo;
        }
    }

    public void setAncho(double ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }
    
    public double calcularKcal(){
    	return (largo * ancho) / 3.0;
    }
	public String getChoripan() {
		return Choripan;
	}
	public void setConsumidor(String consumidor) {
		this.consumidor = consumidor;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}       
}

package taller2;

public class Terremoto {
	private double litros;
	private String fecha;
	private String consumidor;

    // Constructor
    public Terremoto(String consumidor, String fecha,double litros) {
        this.consumidor = consumidor;
        this.fecha = fecha;
        this.litros = litros;
    }
    public String getConsumidor() { // consulta 
        return consumidor;
    }
    
    public String getFecha() {
    	return fecha;
    }
    
    public double getLitros() {
    	return litros;
    }
    
    public void setLitros(double litros) {
        if (litros > 0) {
            this.litros = litros;
        }
    }
    
  
    public double calcularKcal(){
    	return (litros * 10) / 3.0;
    }
}

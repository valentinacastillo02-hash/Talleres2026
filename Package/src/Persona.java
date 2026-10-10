public class Persona {
	private String nombrePersona;
	private Alimento[] listaConsumidos;
	public Persona(String nombrePersona, Alimento[] listaConsumidos) {
		
		this.nombrePersona = nombrePersona;
		this.listaConsumidos = listaConsumidos;
	}

    public String getNombrePersona() {
        return nombrePersona;
    }

	public void getTodosAlimentos(int cantidad){
		for(int i=0;i<cantidad;i++) {
			System.out.println(listaConsumidos[i].getTipoAlimento());
		}
	}
    
	public String getTipoAlimento(int i) {
		return listaConsumidos[i].getTipoAlimento();
	}
	
	

}

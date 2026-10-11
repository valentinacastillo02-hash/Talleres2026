public class Alimento {
	 private String tipoAlimento;
	 private Persona personaUno;
	 private float Largo;
	 private float Ancho;
	 private float Litros;
	 private String fechaConsumo;

	    public Alimento(String tipoAlimento, Persona personauno, float largo, float ancho, String fechaConsumo) {
	        this.tipoAlimento = tipoAlimento;
	        this.personaUno = personauno;
	        this.Largo = largo;
	        this.Ancho = ancho;
	        this.fechaConsumo = fechaConsumo;
	        
	    }

	     public Alimento(String tipoAlimento,Persona personauno, float litros, String fechaConsumo) {
	        this.tipoAlimento = tipoAlimento;
	        this.personaUno = personauno;
	        this.Litros = litros;
	        this.fechaConsumo = fechaConsumo;
	    }

	        public String getTipoAlimento() {
	            return tipoAlimento;
	    }

			public Persona getPersonaUno() {
				return personaUno;
			}

			public float getLargo() {
				return Largo;
			}

			public float getAncho() {
				return Ancho;
			}

			public float getLitros() {
				return Litros;
			}

			public String getFechaConsumo() {
				return fechaConsumo;
			}
	        

}

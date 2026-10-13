import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Consumidor {
	private String nombre;
	
	private Choripan[] listaChorip;
	private Terremoto[] listaterremoto;
	public Consumidor(String nombre, Choripan[] listaChorip, Terremoto[] listaterremoto) {
		
		this.nombre = nombre;
		
		this.listaChorip = listaChorip;
		this.listaterremoto = listaterremoto;
	}
	int cantCho =0;
	int cantTerr=0;
	public String getNombre() {
		return nombre;
	}
	public int getCantCho() {
		return cantCho;
	}
	public int getCantTerr() {
		return cantTerr;
	}
	public void getCanPersonaChoripan() throws FileNotFoundException {
		File file=new File("Consumido.txt");
		Scanner scan=new Scanner(file);
		
		while(scan.hasNextLine()) {
			String linea=scan.nextLine();
			String[] partes=linea.split(";");
			String tip=partes[0];
			String nomb=partes[1];
			
			if(this.nombre.equalsIgnoreCase(nomb)) {
				if(tip.equalsIgnoreCase("Choripan")) {
					double largo=Double.parseDouble(partes[2]);
					double ancho=Double.parseDouble(partes[3]);		
					String fechas=partes[4];
					this.listaChorip[cantCho]=new Choripan("Choripan",this.nombre,fechas,largo,ancho);
					cantCho++;
					}
				}
			}
		
		String format="%-15s %-15s %n"; 
		System.out.printf(format,this.nombre,cantCho);
	}
	public Choripan[] getListaChorip() {
		return listaChorip;
	}
	public Terremoto[] getListaterremoto() {
		return listaterremoto;
	}
	public void setListaChorip(Choripan[] listaChorip) {
		this.listaChorip = listaChorip;
	}
	public void setListaterremoto(Terremoto[] listaterremoto) {
		this.listaterremoto = listaterremoto;
	}
	public void getCanPersonaTerremoto() {
		Scanner scan=null;
		
		File file=new File("Consumido.txt");
		try {
			scan=new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error al ingresar valores.");
		}
		
		while(scan.hasNextLine()) {
			String linea=scan.nextLine();
			String[] partes=linea.split(";");
			String tip=partes[0];
			String nomb=partes[1];
			
			if(this.nombre.equalsIgnoreCase(nomb)) {
				if(tip.equalsIgnoreCase("Terremoto")) {
					double Litro=Double.parseDouble(partes[2]);
							
					String fechas=partes[3];
					this.listaterremoto[cantTerr]=new Terremoto("Terremoto",nomb,fechas,Litro);
					cantTerr++;
					}
				}
			}
		
		String format="%-15s %-15s %n"; 
		System.out.printf(format,this.nombre,cantTerr);
		
	}

	public void calPerPersona(Consumidor cons) {
		
	}
	
	
	
	

}

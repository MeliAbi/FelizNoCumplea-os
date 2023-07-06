package fnc;

public class Alimento {

	private Alimentos nombre=null;
	private Double precio=0.0;
	
	public Alimento (Alimentos nombre,Double precio) {
		this.nombre=nombre;
		this.precio=precio;
	}

	public Alimentos getNombre() {
		return nombre;
	}

	public void setNombre(Alimentos nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}

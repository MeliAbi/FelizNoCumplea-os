package fnc;

import java.util.HashSet;
import java.util.Set;

public class Supermercado {

	private String nombre="";
	private Set <Alimento> listaAlimentos;

	public Supermercado(String nombre) {
		this.nombre = nombre;
		listaAlimentos = new HashSet<Alimento>();
		agregarAListaAlimentos();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Alimento> getListaAlimentos() {
		return listaAlimentos;
	}
	
	public Alimento buscarAlimento(Alimentos nombre) {
		Alimento a=null;

		for(Alimento actual:listaAlimentos) {
			if(actual.getNombre().equals(nombre)) {
				a=actual;
			}
		}
		
		return a;
	}

	public void agregarAListaAlimentos() {
		listaAlimentos.add(new Alimento(Alimentos.ALFAJORES,200.00));
		listaAlimentos.add(new Alimento(Alimentos.BAGELS,300.00));
		listaAlimentos.add(new Alimento(Alimentos.BOCADITOS_DE_CHOCOLATE,150.00));
		listaAlimentos.add(new Alimento(Alimentos.CARAMELOS,50.00));
		listaAlimentos.add(new Alimento(Alimentos.GOMITAS,10.00));
		listaAlimentos.add(new Alimento(Alimentos.MASITAS,500.00));
	}
	
}

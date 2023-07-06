package fnc;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Personaje {
	
	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dineroParaComprar;
	private ArrayList <Alimentos> alimentosComprados;
	private Set <Alimentos> alimentosQueEncojen;

	public Personaje(Double altura, Double peso, String nombre, Integer edad, Double dineroParaComprar) {
		this.altura=altura;
		this.peso=peso;
		this.nombre=nombre;
		this.edad=edad;
		this.dineroParaComprar=dineroParaComprar;
		alimentosComprados= new ArrayList <Alimentos>();
		alimentosQueEncojen = new TreeSet<Alimentos>();
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDineroParaComprar() {
		return dineroParaComprar;
	}

	public void setDineroParaComprar(Double dineroParaComprar) {
		this.dineroParaComprar = dineroParaComprar;
	}

	public Boolean comprarEnSupermercado(Supermercado nuevo,ArrayList<Alimentos> alimentosAComprar) throws NoPuedeComprarException {
		Double precioAPagar=0.0;
		Boolean resultado=false;
		
		for(Alimentos actual: alimentosAComprar) {
			if(nuevo.buscarAlimento(actual)!=null) {
				precioAPagar+=nuevo.buscarAlimento(actual).getPrecio();
				
				System.out.println(precioAPagar);
				
			}
		}
		
		if(precioAPagar!=0.0 && dineroParaComprar >= precioAPagar) {
			
			setDineroParaComprar(dineroParaComprar-precioAPagar);
			alimentosComprados.addAll(alimentosAComprar);
			resultado=true;
			
		}else if(precioAPagar!=0.0 || dineroParaComprar < precioAPagar) {
			throw new NoPuedeComprarException("El personaje esta pobre");
		}
		System.out.println(dineroParaComprar);
		return resultado;
	}
	
	public Boolean crecer(Alimentos comida) throws NoPuedoCrecerException {
		Boolean resultado=false;
		if(altura <= 2.40) {
			Double alturaNueva = altura+0.4;
			setAltura(alturaNueva);
			alimentosComprados.remove(comida);
			resultado=true;
		}else if(resultado== false) {
			throw new NoPuedoCrecerException("No Pudo Crecer");	
		}

		return resultado;
	}
	
	public Boolean encoger(Alimentos comida) throws NoPuedoEncogerException {
		Boolean resultado=false;
		if(altura >= 1.0) {
			Double alturaNueva = altura-0.5;
			setAltura(alturaNueva);
			alimentosComprados.remove(comida);
			resultado=true;
		}else if(resultado== false) {
			throw new NoPuedoEncogerException("No Pudo Encoger");	
		}

		return resultado;
	}
	
	
	public Boolean comer(Alimentos comida) throws NoPuedoCrecerException, NoPuedoEncogerException {
		Boolean resultado=false;
		
		if(alimentosComprados.contains(comida)) {
			
			if((comida.equals(Alimentos.GOMITAS)||comida.equals(Alimentos.CARAMELOS)||comida.equals(Alimentos.BOCADITOS_DE_CHOCOLATE))) {
				try {
					crecer(comida);
				} catch (NoPuedoCrecerException e) {
					throw new NoPuedoCrecerException(e.getMessage());
				}
				resultado=true;
			}else if((comida.equals(Alimentos.ALFAJORES)||comida.equals(Alimentos.BAGELS)||comida.equals(Alimentos.MASITAS))) {
				try {
					encoger(comida);
				} catch (NoPuedoEncogerException e) {
					throw new NoPuedoEncogerException(e.getMessage());
				}
				resultado=true;
			}
			
		}
		
		
		return resultado;
	}

	public ArrayList<Alimentos> getAlimentosComprados() {
		return alimentosComprados;
	}

	public void ordenarAlimentosQueEncojen() {
		
		Set <Alimentos> local = new TreeSet<Alimentos>(new ordenarAlimentosQueEncojen());
		
		for(Alimentos actual :alimentosComprados) {
			if(actual.equals(Alimentos.ALFAJORES)||actual.equals(Alimentos.MASITAS)||actual.equals(Alimentos.BAGELS)) {
				local.add(actual);
			}
		}
		
		for(Alimentos actual :local) {
			System.out.println(actual);
		}

	}


	
}

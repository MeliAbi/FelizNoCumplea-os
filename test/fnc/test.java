package fnc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class test {
	
	@Test
	public void queSeCreeElPersonaje() {
		Double peso=45.5;
		Double dineroParaComprar=4000.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		
		assertNotNull(actual);
		//Altura, Peso, Nombre, Edad, Dinero para comprar, alimentos disponibles para consumir
		//Altura Inicial de Alicia 1,80 cm
	}
	
	@Test
	public void queSeCreeSupermercado() {
		Supermercado actual = new Supermercado("NombreGenerico");
		assertEquals(6,actual.getListaAlimentos().size());
		
	}
	
	@Test
	public void queSeDescuenteElDineroDisponible() throws NoPuedeComprarException {
		Double peso=45.5;
		Double dineroParaComprar=500.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.BOCADITOS_DE_CHOCOLATE);
		alimentosAComprar.add(Alimentos.BAGELS);
		
		Boolean valorEsperado=false;
		try {
			valorEsperado=actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
		assertTrue(valorEsperado);
		assertEquals((Double)50.0,actual.getDineroParaComprar());
	}
	
	@Test (expected=NoPuedeComprarException.class)
	public void queSeNoDescuenteElDineroDisponible() throws NoPuedeComprarException {
		Double peso=45.5;
		Double dineroParaComprar=500.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.BOCADITOS_DE_CHOCOLATE);
		alimentosAComprar.add(Alimentos.BAGELS);
		alimentosAComprar.add(Alimentos.BAGELS);
		
		Boolean valorEsperado=false;
		try {
			valorEsperado=actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
		assertFalse(valorEsperado);
		assertEquals((Double)500.0,actual.getDineroParaComprar());
	}
	
	@Test
	public void queAlComerSeHagaMasGrande() throws NoPuedeComprarException, NoPuedoCrecerException, NoPuedoEncogerException {

		Double peso=45.5;
		Double dineroParaComprar=500.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.GOMITAS);
		alimentosAComprar.add(Alimentos.CARAMELOS);
		
		try {
			actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
		System.out.println(actual.getAltura());
		actual.comer(Alimentos.GOMITAS);
		actual.comer(Alimentos.CARAMELOS);
		System.out.println(actual.getAltura());

		assertEquals(0,actual.getAlimentosComprados().size());
		assertEquals((Double)2.6,actual.getAltura());
		
	}
	
	@Test
	public void queAlComerSeHagaMasPequeña() throws NoPuedeComprarException, NoPuedoCrecerException, NoPuedoEncogerException {
		Double peso=45.5;
		Double dineroParaComprar=500.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.ALFAJORES);
		alimentosAComprar.add(Alimentos.BAGELS);
		
		
		try {
			actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
		System.out.println(actual.getAltura());
		actual.comer(Alimentos.ALFAJORES);
		actual.comer(Alimentos.BAGELS);
		System.out.println(actual.getAltura());

		assertEquals(0,actual.getAlimentosComprados().size());
		assertEquals((Double)0.8,actual.getAltura());
		
	}
	
	@Test (expected=NoPuedoCrecerException.class)
	public void queAlComerNoSeHagaMasGrande() throws NoPuedeComprarException,NoPuedoCrecerException,NoPuedoEncogerException {

		Double peso=45.5;
		Double dineroParaComprar=500.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.GOMITAS);
		alimentosAComprar.add(Alimentos.CARAMELOS);
		alimentosAComprar.add(Alimentos.CARAMELOS);
		
		try {
			actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
			System.out.println(actual.getAltura());
		try {
			actual.comer(Alimentos.GOMITAS);
		} catch (NoPuedoCrecerException | NoPuedoEncogerException e) {
			throw new NoPuedoCrecerException(e.getMessage());
		}
			System.out.println(actual.getAltura());
		try {
			actual.comer(Alimentos.CARAMELOS);
		} catch (NoPuedoCrecerException | NoPuedoEncogerException e) {
			throw new NoPuedoCrecerException(e.getMessage());
		}
			System.out.println(actual.getAltura());
		try {
			actual.comer(Alimentos.CARAMELOS);
		} catch (NoPuedoCrecerException | NoPuedoEncogerException e) {
			throw new NoPuedoCrecerException(e.getMessage());
		}
			System.out.println(actual.getAltura());

		assertEquals(1,actual.getAlimentosComprados().size());
		assertEquals((Double)2.6,actual.getAltura());
		
	}
	
	@Test(expected=NoPuedoEncogerException.class)
	public void queNoPuedaSerMenorA50CM() throws NoPuedeComprarException, NoPuedoEncogerException, NoPuedoCrecerException {

		Double peso=45.5;
		Double dineroParaComprar=700.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.ALFAJORES);
		alimentosAComprar.add(Alimentos.ALFAJORES);
		alimentosAComprar.add(Alimentos.BAGELS);
		
		try {
			actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
			System.out.println(actual.getAltura());
		try {
			actual.comer(Alimentos.ALFAJORES);
		} catch (NoPuedoCrecerException | NoPuedoEncogerException e) {
			throw new NoPuedoEncogerException(e.getMessage());
		}
			System.out.println(actual.getAltura());
		try {
			actual.comer(Alimentos.ALFAJORES);
		} catch (NoPuedoCrecerException | NoPuedoEncogerException e) {
			throw new NoPuedoEncogerException(e.getMessage());
		}
			System.out.println(actual.getAltura());
		try {
			actual.comer(Alimentos.BAGELS);
		} catch (NoPuedoCrecerException | NoPuedoEncogerException e) {
			throw new NoPuedoEncogerException(e.getMessage());
		}
			System.out.println(actual.getAltura());

		assertEquals(1,actual.getAlimentosComprados().size());
		assertEquals((Double)0.8,actual.getAltura());
	}
	
	@Test
	public void queSePuedaOrdenarDescendentementeLosAlimentosQueEnconjen() throws NoPuedeComprarException {
		Double peso=45.5;
		Double dineroParaComprar=1000.00;
		Double altura=1.80;
		String nombre="Alicia";
		Integer edad=11;
		ArrayList <Alimentos> alimentosAComprar= new ArrayList <Alimentos>();
		
		Personaje actual = new Personaje(altura,peso,nombre,edad,dineroParaComprar);
		Supermercado nuevo = new Supermercado("NombreGenerico");
		
		alimentosAComprar.add(Alimentos.ALFAJORES);
		alimentosAComprar.add(Alimentos.BAGELS);
		alimentosAComprar.add(Alimentos.MASITAS);
		
		
		try {
			actual.comprarEnSupermercado(nuevo,alimentosAComprar);
		} catch (NoPuedeComprarException e) {
			throw new NoPuedeComprarException(e.getMessage());
		}
		
		actual.ordenarAlimentosQueEncojen();
		
		assertEquals(3,actual.getAlimentosComprados().size());
		
	}

}

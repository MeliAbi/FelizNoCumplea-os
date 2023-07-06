package fnc;

import java.util.Comparator;

public class ordenarAlimentosQueEncojen implements Comparator<Alimentos>{

	@Override
	public int compare(Alimentos o1, Alimentos o2) {
		return o2.ordinal() - o1.ordinal();
	}
	
}

import java.util.ArrayList;
import java.util.List;

public class Tablero {
	
	private List<Casillas> table = new ArrayList<Casillas>();
	private String[] lugares = {"Keller", "Aporpizza", "Essentia", "Incarlopsa", "El Abuelo", "Toria", "Xandros", "Mandioca", "Campanilla", "Massai", "La casa rosa", "AutoTarancon", "AutoGarcia","AutoRiansares","AutoSanCristobal", "AutoApto", "Towers", "Dolce Vita", "Mercadona", "Costa Rica", "La Juve", "MariaCristina", "Ferial", "HalliBaba", "China Maria", "Tabu", "Manao", "Zoo", "Martina", "Versalles", "Eclipse", "Veyllon", "Girasoles","Librado","Quiles", "Codere"};
	
	private int Precio = 500;
	
	public Tablero() {
		
		for (int i = 0; i<lugares.length; i++) {
			table.add(new Casillas(lugares[i], Precio, i));
			Precio = Precio + 100;
		}
		
	
	}
	
	public void info(int pos) {
		
		for (Casillas c: table) {
			if (c.pos() == pos) {
				System.out.println(c);
			}
		}
		
	}
	
}

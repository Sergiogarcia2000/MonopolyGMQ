import java.util.ArrayList;
import java.util.List;

public class Tablero {
	
	private int[] tablero = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39};
	private List<Casillas> table = new ArrayList<Casillas>();
	private String[] lugares = {"inicio", "Keller", "Aporpizza", "Essentia", "Incarlopsa", "El Abuelo", "Toria", "Xandros", "Mandioca", "Campanillo", "Massai", "La casa rosa", "AutoTarancon", "AutoGarcia","AutoRiansares","AutoSanCristobal", "AutoApto", "Towers", "Dolce Vita", "Mercadona", "Costa Rica", "La Juve", "MariaCristina", "Ferial", "HalliBaba", "China Maria", "Tabu", "Manao", "Zoo", "Martina", "Versalles", "Eclipse", "Veyllon", "Girasoles","Librado","Quiles", "Codere", "carcel", "ir carcel", "isla"};
	
	private int Precio = 500;
	private int Compra = 200;
	
	// Método constructor del tablero	
	
	public Tablero() {
		
		for (int i = 0; i < lugares.length; i++) {
			
			table.add(new Casillas(lugares[i], Precio, i, Compra));
			Precio = Precio + 100;
			Compra = Compra + 50;
		}
		
	
	}
	
	
	// Método que muestra la informacion de la casilla
	public void info(int pos) {
		
		for (Casillas c: table) {
			if (c.pos() == pos) {
				System.out.println(c);
			}
		}
		
	}
	
	// Método que devuelve booleana dependiendo del estado de la casilla
	public boolean comprada(int pos) {
		return table.get(pos).estaComprada();
	}
	
	// Método que devuelve la renta de la casilla
	public int renta(int pos) {
		return table.get(pos).dameRenta();
	}
	
	public int damePrecioCompra(int pos) {
		return table.get(pos).damePrecioCompra();
	}
	
	public int dameNivel(int pos) {
		return table.get(pos).dameNivel();
	}
	
	// Método que edita la casilla a comprada
	public void editarComprada(int pos) {
		table.get(pos).editarComprada();
	}
	
	public void mejorarNivel(int pos) {
		table.get(pos).mejorarNivel();
	}
	
	
}

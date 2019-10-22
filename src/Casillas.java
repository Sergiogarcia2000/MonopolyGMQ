
public class Casillas {

	private String casilla;
	private int renta;
	private int posicion;
	
	
	public Casillas(String casilla, int renta, int posicion) {
		
		this.casilla = casilla;
		this.renta = renta;
		this.posicion = posicion;
		
	}

	
	public int pos() {
		return this.posicion;
	}
	
	
	@Override
	public String toString() {
		return casilla + " Renta: " + renta + " Posición: " + posicion;
	}
	
}

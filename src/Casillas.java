
public class Casillas {

	private String casilla;
	private int renta;
	private int posicion;
	private boolean estaComprada = false;
	
	// M�todo constructor
	public Casillas(String casilla, int renta, int posicion) {
		
		this.casilla = casilla;
		this.renta = renta;
		this.posicion = posicion;
		
	}

	// M�todo que devuelve la posicion de la casilla
	public int pos() {
		return this.posicion;
	}
	
	// M�todo que devuelve la renta de la casilla
	public int dameRenta() {
		return this.renta;
	}
	
	public boolean estaComprada() {
		return this.estaComprada;
	}
	
	public void editarComprada() {
		estaComprada = true;
	}
	
	
	
	// M�todo que permite imprimir como string toda la informacion de una casilla
	@Override
	public String toString() {
		return casilla + " Renta: " + renta + " Posici�n: " + "Est� comprada: " + estaComprada;
	}
	
}


public class Casillas {

	private String casilla;
	private int renta;
	private int posicion;
	private boolean estaComprada = false;
	
	// Método constructor
	public Casillas(String casilla, int renta, int posicion) {
		
		this.casilla = casilla;
		this.renta = renta;
		this.posicion = posicion;
		
	}

	// Método que devuelve la posicion de la casilla
	public int pos() {
		return this.posicion;
	}
	
	// Método que devuelve la renta de la casilla
	public int dameRenta() {
		return this.renta;
	}
	
	
	// Método que devuelve una booleana sobre el estado
	public boolean estaComprada() {
		return this.estaComprada;
	}
	
	// Método que cambia el valor
	public void editarComprada() {
		estaComprada = true;
	}
	
	
	
	// Método que permite imprimir como string toda la informacion de una casilla
	@Override
	public String toString() {
		return casilla + " Renta: " + renta + " Posición: " + "Está comprada: " + estaComprada;
	}
	
}

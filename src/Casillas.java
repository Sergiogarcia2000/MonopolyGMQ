
public class Casillas {

	private String casilla;
	private int renta;
	private int precioCompra;
	private int posicion;
	private int nivel = 1;
	private boolean estaComprada = false;
	
	// M�todo constructor
	public Casillas(String casilla, int renta, int posicion, int precioCompra) {
		
		this.casilla = casilla;
		this.renta = renta;
		this.precioCompra = precioCompra;
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
	
	public int damePrecioCompra() {
		return this.precioCompra;
	}
	
	public int dameNivel() {
		return this.nivel;
	}
	
	public void mejorarNivel() {
		this.nivel++;
		this.renta = this.renta * ((this.nivel + 10) / 10);
	}
	
	
	// M�todo que devuelve una booleana sobre el estado
	public boolean estaComprada() {
		return this.estaComprada;
	}
	
	// M�todo que cambia el valor
	public void editarComprada() {
		this.estaComprada = true;
	}
	
	
	
	// M�todo que permite imprimir como string toda la informacion de una casilla
	@Override
	public String toString() {
		return casilla + "El Precio de compra: " + precioCompra + " Posici�n: " + posicion + " Est� comprada: " + estaComprada + " nivel: " + nivel;
	}
	
}

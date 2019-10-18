
public class Casillas {

	private String casilla;
	private int renta;
	private int posicion;
	
	
	public Casillas(String casilla, int renta, int posicion) {
		
		this.casilla = casilla;
		this.renta = renta;
		this.posicion = posicion;
		
	}
	
	public String DisplayCasilla() {
		
		return casilla;
		
	}
	
	public int DisplayRenta() {
		return renta;
	}
	
	public int DisplayPosicion() {
		return posicion;
	}
	
}

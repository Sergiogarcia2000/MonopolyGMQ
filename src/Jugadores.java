
public class Jugadores {
	
	private String nombre;
	private int dinero;
	private int posicion;
	private int [] posicionesEnPropiedad = new int[40];
	private int indexJ;
	//Constructor
	public Jugadores(String nombre) {
		this.nombre=nombre;
		dinero = 15000;
		posicion = 0;
		indexJ = -1;
	}
	//Setter para editar el dinero
	public void editarDinero(int dinero) {
		this.dinero=dinero;
	}
	//setter para editar posicion
	public void editarPosicion(int posicion) {
		this.posicion = posicion;
	}
	public void addCasilla(int posicion, int index) {
		posicionesEnPropiedad[index] = posicion;	
	}
	public int dameIndex() {
		indexJ+=1;
		return indexJ;
	}
	public int dameCasillaEnPropiedad(int index) {
		return posicionesEnPropiedad[index];
	}
	//Getter para obtener el dinero
	public int dameDinero() {
		return dinero;
		
	}
	public String dameNombre() {
		return nombre;
		
	}
	public int damePosicion() {
		return posicion;
		
	}
}

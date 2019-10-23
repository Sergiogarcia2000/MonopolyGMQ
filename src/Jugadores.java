
public class Jugadores {
	
	private String nombre;
	private int dinero;
	private int posicion;
	//Constructor
	public Jugadores(String nombre) {
		this.nombre=nombre;
		dinero = 15000;
		posicion = 0;
	}
	//Setter para editar el dinero
	public void editarDinero(int dinero) {
		this.dinero=dinero;
	}
	//setter para editar posicion
	public void editarPosicion(int posicion) {
		this.posicion = posicion;
	}
	//Getter para obtener el dinero
	public int dameDinero() {
		return  dinero;
		
	}
	public String dameNombre() {
		return nombre;
		
	}
	public int damePosicion() {
		return posicion;
		
	}
}

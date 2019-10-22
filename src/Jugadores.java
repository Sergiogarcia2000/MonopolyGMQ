
public class Jugadores {
	private String nombre;
	private int dinero;
	private int posicion;
	
	public Jugadores(String nombre) {
		this.nombre=nombre;
		dinero = 15000;
		posicion = 0;
	}
	//Setter para editar el dinero
	public void Cuentas(int dinero) {
		this.dinero=dinero;
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

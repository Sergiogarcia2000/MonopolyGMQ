
public class Jugadores {
	
	private String nombre;
	private int dinero;
	private int posicion;
	private int [] posicionesEnPropiedad = new int[40];
	private int indexJ;
	private int turnoCarcel;
	private boolean encarcelado= false;
	private boolean bancarrota=false;
	private boolean msgBancarrota= true;
	//Constructor
	public Jugadores(String nombre) {
		this.nombre=nombre;
		dinero = 15000;
		posicion = 0;
		indexJ = -1;
		turnoCarcel = 0;
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
	public void resetTodasCasillas(int index) {
		posicionesEnPropiedad[index] = -5;
	}
	public void editarEncarcelado(boolean state) {
		encarcelado=state;
	}
	public void sumarTurnoCarcel() {
		turnoCarcel++;
	}
	public void resetTurnoCarcel() {
		turnoCarcel = 0;
	}
	public void editarBancarrota(boolean state) {
		bancarrota = state;
	}
	public void editarMsgBancarrota(boolean state) {
		msgBancarrota = state;
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
	public int dameTurnoCarcel() {
		return turnoCarcel;
	}
	public boolean dameEncarcelado() {
		return encarcelado;
	}
	public boolean dameBancarrota() {
		return bancarrota;
	}
	public boolean dameMsgBancarrota() {
		return msgBancarrota;
	}
}

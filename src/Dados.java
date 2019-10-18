
public class Dados {
	
	private byte PrimerDado;
	private byte SegundoDado;
	private byte Resultado;
	
	public Dados() {
		
		 PrimerDado=(byte)(Math.random() * 6 + 1 );
		 SegundoDado=(byte)(Math.random() * 6 + 1);
		 Resultado = (byte)(PrimerDado + SegundoDado);
		 
	}
	public int TirarPrimerDado() {
		return PrimerDado;
		
	}
	public int TirarSegundoDado() {
		return SegundoDado;
		
	}
	public int TirarDados() {
		return Resultado;
		
	}
		
	
}

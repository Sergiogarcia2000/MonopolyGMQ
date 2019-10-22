
public class Dados {
	
	private byte PrimerDado;
	private byte SegundoDado;
	private byte Resultado;
	
	public Dados() {
		
		 PrimerDado=(byte)(Math.random() * 6 + 1 );
		 SegundoDado=(byte)(Math.random() * 6 + 1);
		 Resultado = (byte)(PrimerDado + SegundoDado);
		 
	}
	
	public String TirarDados() {
		return "En el primer dado ha salido un "+ PrimerDado + "\n" + "En el segundo dado ha salido un " + SegundoDado + "\n" + "El resultado es " + Resultado;
		
	}
		
	
}

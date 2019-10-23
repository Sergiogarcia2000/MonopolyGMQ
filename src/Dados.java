
public class Dados {
	
	private byte primerDado;
	private byte segundoDado;
	private byte resultado;
	
	public Dados() {
		
		 primerDado=(byte)(Math.random() * 6 + 1 );
		 segundoDado=(byte)(Math.random() * 6 + 1);
		 resultado = (byte)(primerDado + segundoDado);
		 
	}
	
	public void tirarDados() {
		primerDado=(byte)(Math.random() * 6 + 1 );
		segundoDado=(byte)(Math.random() * 6 + 1);
		resultado = (byte)(primerDado + segundoDado);
	}
	
	public String dameDatosDados() {
		return "En el primer dado ha salido un "+ primerDado + "\n" + "En el segundo dado ha salido un " + segundoDado + "\n" + "El resultado es " + resultado;
		
	}
	public int dameResulDados(){
		return resultado;
	}
		
	
}

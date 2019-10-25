
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
		return "Primer dado: "+ primerDado + "\n" + "Segundo dado: " + segundoDado + "\n" + "El resultado es:  " + resultado;
		
	}
	public int dameResulDados(){
		return resultado;
	}
		
	
}

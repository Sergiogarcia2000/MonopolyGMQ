import javax.swing.*;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		Jugadores[] jugador = new Jugadores[5];
		
		int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos jugadores?"));
		
		
		for (int i = 0 ; i <= numJugadores-1 ; i++) {
			
		jugador[i] = new Jugadores(JOptionPane.showInputDialog("Nombre del jugador " + (i+1)));
			
		}
		
		
		
		//Dados Dado= new Dados();
		//System.out.println(Dado.TirarDados());
	
	}

}

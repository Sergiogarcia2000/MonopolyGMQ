import javax.swing.*;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		boolean juego= true;
		int dadoComienzo;
		Tablero tablero= new Tablero();
		Dados dado = new Dados();
		Jugadores[] jugador = new Jugadores[5];
		
		//Pedir al usuario cuantos jugadores vana  jugar
		int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos jugadores?"));	
		
		//for para crear jugadores
		for (int i = 0 ; i <= numJugadores-1 ; i++) {
			
			jugador[i] = new Jugadores(JOptionPane.showInputDialog("Nombre del jugador " + (i+1)));
		}
			//elige aleatoriamente al primer jugador en empezar
		dadoComienzo =(int)Math.random()*numJugadores;
		while (juego) {
		
			System.out.println("Turno del jugador " + jugador[dadoComienzo].dameNombre());
			
			//Crear panel que dice tirar dados
			JOptionPane.showOptionDialog(null, null, "Tire los dados", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Tirar los dados"}, null);	
			//Cambio el valor de los dados
			dado.tirarDados();
			//escribo los datos de los dados
			System.out.println(dado.dameDatosDados());
			//cambio la `posicion
			jugador[dadoComienzo].editarPosicion(dado.dameResulDados()+jugador[dadoComienzo].damePosicion());
			//si la casilla es superior a 40 empieza de nuevo
			if(jugador[dadoComienzo].damePosicion() >= 40) {
				jugador[dadoComienzo].editarPosicion(dado.dameResulDados());
			}
			//consultar datos de la posicion
			tablero.info(jugador[dadoComienzo].damePosicion());
			
			jugador[dadoComienzo].damePosicion();
			//comprobacion si esta comprada la posicion
			if(tablero.comprada(jugador[dadoComienzo].damePosicion()) == false) {
				
				int comprar = JOptionPane.showOptionDialog(null, "¿Quiere comprar la casilla?", "Casilla sin comprar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Si", "No"}, null);	 
				
				if(comprar == 0) {
					
					jugador[dadoComienzo].editarDinero(jugador[dadoComienzo].dameDinero()- tablero.renta(jugador[dadoComienzo].damePosicion()));
					
					tablero.editarComprada(jugador[dadoComienzo].damePosicion());
					
					System.out.println("Comprada");
					System.out.println("Te queda "+ jugador[dadoComienzo].dameDinero() + "€");
						
				}
			}
			if(dadoComienzo < numJugadores-1) {
				dadoComienzo+=1;
			}else { 
				dadoComienzo=0;
			}
		}
		
		
	
	}

}

import javax.swing.*;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		boolean juego= true;
		boolean pagado= false;
		int actual;
		double dadoAleatorio;
		String jugadorPagado = "";
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
		dadoAleatorio =Math.random()*numJugadores;
		actual=(int)dadoAleatorio;
		
		System.out.println(actual);
		while (juego) {
			JOptionPane.showMessageDialog(null,"Turno del jugador " + jugador[actual].dameNombre());
			
			//Crear panel que dice tirar dados
			JOptionPane.showOptionDialog(null, null, "Tire los dados", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Tirar los dados"}, null);	
			//Cambio el valor de los dados
			dado.tirarDados();
			//escribo los datos de los dados
			JOptionPane.showMessageDialog(null,dado.dameDatosDados());
			//System.out.println(dado.dameDatosDados());
			//cambio la `posicion
			jugador[actual].editarPosicion(dado.dameResulDados()+jugador[actual].damePosicion());
			//si la casilla es superior a 40 empieza de nuevo
			if(jugador[actual].damePosicion() >= 40) {
				
				jugador[actual].editarPosicion( jugador[actual].damePosicion() - 40 );
			}
			//consultar datos de la posicion
			tablero.info(jugador[actual].damePosicion());
			
			jugador[actual].damePosicion();
			//comprobacion si esta comprada la posicion
			if(tablero.comprada(jugador[actual].damePosicion())) {
				
				for (int i = 0 ; i <= numJugadores-1 ; i++) {
					for(int j = 0;j <= 39;j++) {
						if(jugador[actual].dameCasillaEnPropiedad(j) == jugador[actual].damePosicion()) {
							System.out.println("La casilla es tuya");
							if (tablero.dameNivel(jugador[actual].damePosicion()) <= 3) {

								int mejorar = JOptionPane.showOptionDialog(null, tablero.informacion(jugador[actual].damePosicion())+ "Desea Comprar la casilla", "Casilla sin mejorar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Si", "No"}, null);	 
								
								if (mejorar == 0) {
									tablero.mejorarNivel(jugador[actual].damePosicion());
									JOptionPane.showMessageDialog(null,"Se ha mejorado la casilla");
									break;
								}
					
							}
						}
						else if (jugador[i].dameCasillaEnPropiedad(j) == jugador[actual].damePosicion()){
								jugador[i].editarDinero(jugador[i].dameDinero()+ tablero.renta(actual));
								jugador[actual].editarDinero(jugador[actual].dameDinero() - tablero.renta(jugador[actual].damePosicion()));
								pagado = true;
								jugadorPagado = jugador[i].dameNombre();
						}
					}
					
				}
				if (pagado) {
					JOptionPane.showMessageDialog(null,"El sitio es de:  " +   jugadorPagado + "\n" + "Has pagado de renta " + tablero.renta(jugador[actual].damePosicion()) + " Te queda " + jugador[actual].dameDinero() + "€");
				pagado = false;
				}
				}else {
					int comprar = JOptionPane.showOptionDialog(null, tablero.informacion(jugador[actual].damePosicion()) + "\n"+"¿Quiere comprar la casilla?", "Casilla sin comprar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Si", "No"}, null);	 
				
					if(comprar == 0) {
					
						jugador[actual].editarDinero(jugador[actual].dameDinero()- tablero.damePrecioCompra(jugador[actual].damePosicion()));
					
						tablero.editarComprada(jugador[actual].damePosicion());
						jugador[actual].addCasilla(jugador[actual].damePosicion(),jugador[actual].dameIndex());
					
						JOptionPane.showMessageDialog(null,"Comprada" + "\n" + "Te queda "+ jugador[actual].dameDinero() + "€");
				}
			}
			
			
			
			
			if(actual < numJugadores-1) {
				actual+=1;
			}else { 
				actual=0;
			}
		}
		
		
	
	}

}

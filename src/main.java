import javax.swing.*;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		boolean juego= true;
		boolean esTuya= false;
		boolean pagado= false;
		int actual;
		int cartaElegida;
		int posicionElegida;
		int casillaInicio = 2000;
		double dadoAleatorio;
		double cartaAleatoria;
		double posicionAleatoria;
		String jugadorPagado = "";
		String casillasEnPropiedad = "";
		Tablero tablero= new Tablero();
		Dados dado = new Dados();
		Jugadores[] jugador = new Jugadores[8];
		
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
			if(jugador[actual].dameBancarrota() == false) {
			JOptionPane.showMessageDialog(null,"Turno del jugador " + jugador[actual].dameNombre());
			
			while (juego) {
				
			
			//Crear panel que dice tirar dados
			int opciones= JOptionPane.showOptionDialog(null,"Jugador que deseas hacer ", "Opciones ", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Tirar los dados","Consultar dinero","Consultar posiciones en propiedad"}, null);	
			//Cambio el valor de los dados
			dado.tirarDados();
			//escribo los datos de los dados
			if(opciones == 1) {
				JOptionPane.showMessageDialog(null,"Su dinero actual es " + jugador[actual].dameDinero() + "€" );
			}
			else if(opciones == 2) {
				for(int i = 0; i <= 39; i++) {
					if(jugador[actual].dameCasillaEnPropiedad(i) >= 1) {
						casillasEnPropiedad += tablero.dameCasilla(jugador[actual].dameCasillaEnPropiedad(i)) + "\n";
					
				}}
				
				JOptionPane.showMessageDialog(null, "Sus casillas son: " + "\n" + casillasEnPropiedad);
				casillasEnPropiedad = "";
			}
			else if(opciones == 0) {
			JOptionPane.showMessageDialog(null,dado.dameDatosDados());
			//System.out.println(dado.dameDatosDados());
			//cambio la `posicion
			if(jugador[actual].dameEncarcelado() == false) {
				jugador[actual].editarPosicion(dado.dameResulDados()+jugador[actual].damePosicion());
				
			}else {
				int Carcel = JOptionPane.showOptionDialog(null, "Desea pagar la tasa de libertad", "Encarcelado", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Pagar 500€","Saltar turno"}, null);	
				if(Carcel == 0) {
					jugador[actual].editarDinero(jugador[actual].dameDinero() - 500);
					jugador[actual].editarPosicion(dado.dameResulDados()+jugador[actual].damePosicion());
					jugador[actual].editarEncarcelado(false);
				}else if(Carcel == 1) {
					jugador[actual].sumarTurnoCarcel();
				}if(jugador[actual].dameTurnoCarcel() == 3) {
					JOptionPane.showMessageDialog(null,"Ya no puedes saltar mas turnos" + "\n" + "Se le cobrara la tasa de 500€");
					jugador[actual].editarDinero(jugador[actual].dameDinero() - 500);
					jugador[actual].editarPosicion(dado.dameResulDados()+jugador[actual].damePosicion());
					jugador[actual].resetTurnoCarcel();
					jugador[actual].editarEncarcelado(false);
				}
			}
			//si la casilla es superior a 40 empieza de nuevo
			break;
			}}
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
							esTuya = true;
							
						}
						
						else if (jugador[i].dameCasillaEnPropiedad(j) == jugador[actual].damePosicion()){
								jugador[i].editarDinero(jugador[i].dameDinero()+ tablero.renta(actual));
								jugador[actual].editarDinero(jugador[actual].dameDinero() - tablero.renta(jugador[actual].damePosicion()));
								pagado = true;
								jugadorPagado = jugador[i].dameNombre();
						}
					}
					
				} if(esTuya) {
					JOptionPane.showMessageDialog(null, "La casilla"+ tablero.dameCasilla(jugador[actual].damePosicion()) + " es tuya");
					
					if (tablero.dameNivel(jugador[actual].damePosicion()) <= 3) {

						int mejorar = JOptionPane.showOptionDialog(null, tablero.informacion(jugador[actual].damePosicion())+ "\n" + "Desea Mejorar la casilla", "Casilla sin mejorar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Si", "No"}, null);	 
						
						if (mejorar == 0) {
							tablero.mejorarNivel(jugador[actual].damePosicion());
							JOptionPane.showMessageDialog(null,"Se ha mejorado la casilla");
							
						}
			
					}
					esTuya = false;
				}
				if (pagado) {
					JOptionPane.showMessageDialog(null,"Sitio: " + tablero.dameCasilla(jugador[actual].damePosicion()) + "\n" + "El sitio es de:  " +   jugadorPagado + "\n" + "Has pagado de renta " + tablero.renta(jugador[actual].damePosicion()) + " Te queda " + jugador[actual].dameDinero() + "€");
				pagado = false;
				}
				}else {
					
					if (jugador[actual].damePosicion() == 0) {
						JOptionPane.showMessageDialog(null, "Estas en  Inicio" + "\n" + "Ganas 2000€");
						jugador[actual].editarDinero(jugador[actual].dameDinero() + casillaInicio);	
					}else if(jugador[actual].damePosicion() == 9 &&  jugador[actual].dameEncarcelado() == false) {
						JOptionPane.showMessageDialog(null, "Estas en  Carcel" + "\n" + "Pero solo de visita");
					}else if(jugador[actual].damePosicion() == 9 &&  jugador[actual].dameEncarcelado() == true) {
						JOptionPane.showMessageDialog(null, "Pues te quedas en la carcel");
						
					}else if(jugador[actual].damePosicion() == 29  ) {
						JOptionPane.showMessageDialog(null, "Vas directo a la carcel");
						jugador[actual].editarPosicion(9);
						jugador[actual].editarEncarcelado(true);
					}else if(jugador[actual].damePosicion() == 7 || jugador[actual].damePosicion() == 17 || jugador[actual].damePosicion() == 22 || jugador[actual].damePosicion() == 33){
						
						cartaAleatoria = Math.random()*5;
						cartaElegida = (int)cartaAleatoria;
						
						
						JOptionPane.showMessageDialog(null, "Has caido en carta aleatoria");
						
						if (cartaElegida == 0) {
							JOptionPane.showMessageDialog(null, "Ganas 2500€");
							jugador[actual].editarDinero(jugador[actual].dameDinero() + 2500);
							
						}else if (cartaElegida == 1) {
							JOptionPane.showMessageDialog(null, "Pierdes 2500€");
							jugador[actual].editarDinero(jugador[actual].dameDinero() - 2500);
							
						}else if (cartaElegida == 2) {
							JOptionPane.showMessageDialog(null, "Vas directo a la cárcel");
							jugador[actual].editarPosicion(9);
							jugador[actual].editarEncarcelado(true);
							
						}else if (cartaElegida == 3) {
							JOptionPane.showMessageDialog(null, "Ve al inicio");
							jugador[actual].editarPosicion(0);
							jugador[actual].editarDinero(jugador[actual].dameDinero() + casillaInicio);
						
							
						}else if (cartaElegida == 4) {
							JOptionPane.showMessageDialog(null, "Vas a una casilla aleatoria sin que ocurra nada");

							posicionAleatoria = Math.random()*40;
							posicionElegida = (int)posicionAleatoria;
							
							jugador[actual].editarPosicion(posicionElegida);
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
			}
			
			
			
			
			
			}else {
				if(jugador[actual].dameMsgBancarrota())
					JOptionPane.showMessageDialog(null,"El jugador " + jugador[actual].dameNombre() + " esta en bancarrota");
				jugador[actual].editarMsgBancarrota(false); 
			}
		}if(actual < numJugadores-1) {
			actual+=1;
		}else { 
			actual=0;
		}
		
		
	
	}

}

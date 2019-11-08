import javax.swing.*;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		
		// VARIABLES DE JUEGO
		boolean juego= true;
		boolean esTuya= false;
		boolean pagado= false;
		int jugadoresEnBancarrota = 0;
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
			
			// Mensaje del jugador actual 
			
			JOptionPane.showMessageDialog(null,"Turno del jugador " + jugador[actual].dameNombre());
			
			// Comprobar si el usuario está en bancarrota, si es así cambiar su estado
			
			if (jugador[actual].dameVidas() == 1) {
				jugador[actual].editarBancarrota(true);
			}
			
			// Comprobar si su dinero está en negativo, si es así informar de los turnos que le quedan y restarle un turno
			
			if(jugador[actual].dameDinero() < 0) {
				JOptionPane.showMessageDialog(null, "Esta de por debajo de 0€, si no lo recupera en " + jugador[actual].dameVidas() + " turnos quedará en bancarrota y se liberaran sus posesiones." );
				jugador[actual].restarVidas();
				
			// Si se consigue poner en positivo se le reinician los turnos
				
			}else {
				jugador[actual].resetVidas();
			}
			
			
			
			// Si tan solo queda 1 jugador terminar la partida
			
			if(jugador[actual].dameBancarrota() == false) {
				
				
				if (jugadoresEnBancarrota >= numJugadores - 1) {
					JOptionPane.showMessageDialog(null, "El jugador " + jugador[actual].dameNombre() + " ha ganado la partida!!" );
					System.exit(0);
				}
				
				
			
				while (juego) {
				
					
					
					//Crear panel que dice tirar dados
					int opciones= JOptionPane.showOptionDialog(null,"Jugador que deseas hacer ", "Opciones ", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Tirar los dados","Consultar dinero","Consultar posiciones en propiedad"}, null);	
					//Cambio el valor de los dados
					dado.tirarDados();
					//escribo los datos de los dados
					if(opciones == 1) {
						JOptionPane.showMessageDialog(null,"Su dinero actual es " + jugador[actual].dameDinero() + "€" );
					}
					
					// Mostrar las casillas que tiene el jugador
					
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
					
					// Encarcelar al jugador
						
					}else {
						int Carcel = JOptionPane.showOptionDialog(null, "Desea pagar la tasa de libertad", "Encarcelado", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null,new Object[] {"Pagar 500€","Saltar turno"}, null);	
						
						// Opciones dentro de la carcel
						
						// Salir de la carcel pagando 500€
						if(Carcel == 0) {
							
							jugador[actual].editarDinero(jugador[actual].dameDinero() - 500);
							jugador[actual].editarPosicion(dado.dameResulDados()+jugador[actual].damePosicion());
							jugador[actual].editarEncarcelado(false);
							
						// Mantenerse en la carcel	
						}else if(Carcel == 1) {
							
							jugador[actual].sumarTurnoCarcel();
							
							
						// Si lleva 3 turnos en la carcel sacarlo y cobrarle los 500€
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
						// Si la casilla es tuya
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
						
						// Posiciones especiales
						
						}else{
							
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
							
							// Caer en carta aleatoria
								
							}else if(jugador[actual].damePosicion() == 7 || jugador[actual].damePosicion() == 17 || jugador[actual].damePosicion() == 22 || jugador[actual].damePosicion() == 33){
								
								// Se generan cartas aleatorias
								
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
								
						// Comprar la casilla
								
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
			
					// Bancarrota
					
			}else {
				if(jugador[actual].dameMsgBancarrota()) {
					JOptionPane.showMessageDialog(null,"El jugador " + jugador[actual].dameNombre() + " esta en bancarrota");
				for (int i = 0;i <= 39;i++){
					tablero.reiniciarNivel(jugador[actual].dameCasillaEnPropiedad(i));//eliminar el nivel de estas casillas
					
					jugador[actual].resetTodasCasillas(i);//va a borrar todas las casillas de este jugador
					
					jugadoresEnBancarrota++;
					jugador[actual].editarMsgBancarrota(false); 
				}
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

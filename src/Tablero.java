
public class Tablero {
	
	public Casillas table[];
	
	public Tablero() {
		
		table[0] = new Casillas("Inicio", 0, 0);
		table[1] = new Casillas("Inicio", 0, 1);
		table[2] = new Casillas("Inicio", 0, 2);
		table[3] = new Casillas("Inicio", 0, 3);
		table[4] = new Casillas("Inicio", 0, 4);
		table[5] = new Casillas("Inicio", 0, 5);
		table[6] = new Casillas("Inicio", 0, 6);
		table[7] = new Casillas("Inicio", 0, 7);
		table[8] = new Casillas("Inicio", 0, 8);
		table[9] = new Casillas("Inicio", 0, 9);
		table[10] = new Casillas("Inicio", 0, 10);
		table[11] = new Casillas("Inicio", 0, 11);
		table[12] = new Casillas("Inicio", 0, 12);
		table[13] = new Casillas("Inicio", 0, 13);
		table[14] = new Casillas("Inicio", 0, 14);
		table[15] = new Casillas("Inicio", 0, 15);
		table[16] = new Casillas("Inicio", 0, 16);
		table[17] = new Casillas("Inicio", 0, 17);
		table[18] = new Casillas("Inicio", 0, 18);
		table[19] = new Casillas("Inicio", 0, 19);
		table[20] = new Casillas("Inicio", 0, 20);
		table[21] = new Casillas("Inicio", 0, 21);
		table[22] = new Casillas("Inicio", 0, 22);
		table[23] = new Casillas("Inicio", 0, 23);
		table[24] = new Casillas("Inicio", 0, 24);
		table[25] = new Casillas("Inicio", 0, 25);
		table[26] = new Casillas("Inicio", 0, 26);
		table[27] = new Casillas("Inicio", 0, 27);
		table[28] = new Casillas("Inicio", 0, 28);
		table[29] = new Casillas("Inicio", 0, 29);
		table[30] = new Casillas("Inicio", 0, 30);
		table[31] = new Casillas("Inicio", 0, 31);
		table[32] = new Casillas("Inicio", 0, 32);
		table[33] = new Casillas("Inicio", 0, 33);
		table[34] = new Casillas("Inicio", 0, 34);
		table[35] = new Casillas("Inicio", 0, 35);
		table[36] = new Casillas("Inicio", 0, 36);
		table[37] = new Casillas("Inicio", 0, 37);
		table[38] = new Casillas("Inicio", 0, 38);
		table[39] = new Casillas("Inicio", 0, 39);
		table[40] = new Casillas("Inicio", 0, 40);
	
		

	}

	
	public String display(int index) {
		
		return table[index].DisplayCasilla();
		
	}
		
	
}

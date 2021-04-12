package com.example;

public class Principal {
	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.init();
		// ...
		
		var t = juego.getTablero();
		System.out.println("Dentro del Juego");
		for(int f = 0; f < 8; f++)
			for(int c = 0; c < 8; c++)
				if(t.hayPieza(f, c))
					System.out.println("Hay pieza en " + f + "-" + c);
				else 
					System.out.println("No hay pieza en " + f + "-" + c);
		// ...
		t.ponPieza(0, 0, null);
		System.out.println("Fuera del juego");
		Juego juego2 = juego.clone();
		// juego.tablero.ponPieza(0, 0, null);
		juego.mover(0, 0, 0, 1);
		var otro = juego2.getTablero();
		for(int f = 0; f < 8; f++)
			for(int c = 0; c < 8; c++)
				if(otro.hayPieza(f, c))
					System.out.println("Hay pieza en " + f + "-" + c);
				else 
					System.out.println("No hay pieza en " + f + "-" + c);
	}
}

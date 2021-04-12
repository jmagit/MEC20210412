package com.example;

public class Principal {
	public static void main() {
		Juego juego = new Juego();
		juego.init();
		// ...
		
		var t = juego.getTablero();
		t.ponPieza(0, 0, null);
	}
}

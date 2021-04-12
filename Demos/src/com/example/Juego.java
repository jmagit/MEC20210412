package com.example;

public class Juego {
	private Tablero tablero = new Tablero();
	
	public void init() {
		tablero.ponPieza(0, 0, new Pieza());
		// ...
	}
	
	public Tablero getTablero() {
		return tablero;
	}
}

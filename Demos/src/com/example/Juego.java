package com.example;

import com.example.juego.Tablero;

public class Juego {
	private Tablero tablero = new Tablero();
	
	public void init() {
		tablero.ponPieza(0, 0, new Pieza());
		// ...
	}
	
	public Tablero getTablero() {
		return tablero.clone();
	}
	
	public void mover(int filaini, int columnaini, int filafin, int columnafin) {
		tablero.ponPieza(filafin, columnafin, tablero.damePieza(filaini, columnaini));
		tablero.quitaPieza(filaini, columnaini);
	}
	
	@Override
	public Juego clone()  {
		Juego copiaJuego = new Juego();
		copiaJuego.tablero = tablero.clone();
		return copiaJuego;
	}
}

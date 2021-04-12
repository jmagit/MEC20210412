package com.example;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];
	
	public void ponPieza(int fila, int columna, Pieza pieza) {
		piezas[fila][columna] = pieza;
	}
	public boolean hayPieza(int fila, int columna) {
		return piezas[fila][columna] != null;
	}
	public Pieza damePieza(int fila, int columna) {
		return piezas[fila][columna];
	}
	public void quitaPieza(int fila, int columna) {
		piezas[fila][columna] = null;
	}
}

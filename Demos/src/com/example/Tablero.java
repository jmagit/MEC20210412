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
	
	@Override
	public Tablero clone() {
		Tablero copiaTablero = new Tablero();
		for(int f = 0; f < 8; f++)
			for(int c = 0; c < 8; c++)
				copiaTablero.piezas[f][c] = piezas[f][c];
		return copiaTablero;
	}
}

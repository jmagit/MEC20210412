package com.example.juego;

import java.util.Optional;

import com.example.JuegoException;
import com.example.Pieza;
import com.example.Posicion;

public class Tablero {
	private Pieza[][] piezas = new Pieza[8][8];
	
	public void ponPieza(int fila, int columna, Pieza pieza) throws JuegoException {
		ponPieza(new Posicion(fila, columna), pieza);
		assert piezas[fila][columna] == pieza : "Falla";
	}
	public void ponPieza(Posicion posicion, Pieza pieza) {
		piezas[posicion.getFila()][posicion.getColumna()] = pieza;
	}
	public boolean hayPieza(int fila, int columna) {
		return piezas[fila][columna] != null;
	}
	public Pieza damePieza(int fila, int columna) throws JuegoException {
		if(!hayPieza(fila, columna))
			throw new JuegoException("No hay pieza");
		return piezas[fila][columna];
	}
	public Optional<Pieza> damePieza(Posicion posicion) throws JuegoException {
		return Optional.ofNullable(piezas[posicion.getFila()][posicion.getColumna()]);
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

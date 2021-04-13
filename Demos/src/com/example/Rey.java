package com.example;

import com.example.juego.Tablero;

public class Rey extends Pieza {

	public Rey(Color color) {
		super(color);
	}

	@Override
	public boolean esValido(int filaini, int columnaini, int filafin, int columnafin, Tablero t) {
		return false;
	}

}

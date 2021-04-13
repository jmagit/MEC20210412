package com.example;

import com.example.juego.Tablero;

public abstract class Pieza {
	public enum Color { BLANCO, NEGRO }
	
	private final Color color;
	
	public Pieza(Color color) {
		this.color = color;
	}
	
	public final Color getColor() { return color; }
	
	public abstract boolean esValido(int filaini, int columnaini, int filafin, int columnafin, Tablero t);
	
}

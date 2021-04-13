package com.example;

import com.example.Pieza.Color;
import com.example.juego.Tablero;

@Autor(nombre = "Javier")
public class Juego {
	private Tablero tablero = new Tablero();
	private Color turno;
	
	public void init() {
		turno = Color.BLANCO;
		tablero.ponPieza(0, 0, new Rey(Color.BLANCO));
		// ...
	}
	
	public Tablero getTablero() {
		return tablero.clone();
	}
	
	@Deprecated
	public void mover(int filaini, int columnaini, int filafin, int columnafin) {
		if(tablero.hayPieza(filaini, columnaini) && 
				tablero.damePieza(filaini, columnaini).getColor() == turno &&
				tablero.damePieza(filaini, columnaini).esValido(filaini, columnaini, filafin, columnafin, tablero)) {
			tablero.ponPieza(filafin, columnafin, tablero.damePieza(filaini, columnaini));
			tablero.quitaPieza(filaini, columnaini);
			turno = turno == Color.BLANCO ? Color.NEGRO : Color.BLANCO;
		}
	}
	public void mover(Posicion ini, Posicion fin) {
		mover(ini.getFila(),  ini.getColumna(), fin.getFila(), fin.getColumna());
	}
	public void mover(String movimiento) {
		// [A-H][1-8][A-H][1-8]
		// mover(ini.getFila(),  ini.getColumna(), fin.getFila(), fin.getColumna());
	}
	
	
	@Override
	public Juego clone()  {
		Juego copiaJuego = new Juego();
		copiaJuego.tablero = tablero.clone();
		return copiaJuego;
	}
}

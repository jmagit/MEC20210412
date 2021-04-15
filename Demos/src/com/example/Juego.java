package com.example;

import java.util.Optional;

import com.example.Pieza.Color;
import com.example.juego.Tablero;

@Autor(nombre = "Javier")
public class Juego {
	private Tablero tablero = new Tablero();
	private Color turno;
	
	public void init() throws JuegoException {
		turno = Color.BLANCO;
		tablero.ponPieza(0, 0, new Rey(Color.BLANCO));
		// ...
	}
	
	public Tablero getTablero() {
		return tablero.clone();
	}
	
	@Deprecated
	public void mover(int filaini, int columnaini, int filafin, int columnafin) throws JuegoException {
		assert 0 <= filaini && filaini < 8 : "Fila inicial fuera de rango";
		if(tablero.hayPieza(filaini, columnaini) && 
				tablero.damePieza(filaini, columnaini).getColor() == turno &&
				tablero.damePieza(filaini, columnaini).esValido(filaini, columnaini, filafin, columnafin, tablero)) {
			tablero.ponPieza(filafin, columnafin, tablero.damePieza(filaini, columnaini));
			tablero.quitaPieza(filaini, columnaini);
			turno = turno == Color.BLANCO ? Color.NEGRO : Color.BLANCO;
			var p = tablero.damePieza(new Posicion(filafin, columnafin));
			if(p.isPresent())
				p.get().getColor();
		}
	}

	public void mover(Posicion ini, Posicion fin) throws JuegoException {
		if(ini == null)
			throw new JuegoException("Falta la posicion inicial");
		if(fin == null)
			throw new JuegoException("Falta la posicion final");
		mover(ini.getFila(),  ini.getColumna(), fin.getFila(), fin.getColumna());
	}
	public void mover(Posicion ini) throws JuegoException {
		if(ini == null)
			throw new JuegoException("Falta la posicion inicial");
		mover(ini.getFila(),  ini.getColumna(), ini.getFila(), ini.getColumna());
	}
	public void pasaNulo(Optional<Posicion> pos) throws JuegoException {
		if(pos == null)
			throw new JuegoException("Falta la posicion");
		if(pos.isEmpty()) {
			// ...
		} else {
			var p = pos.get();
			// ...
		}
		
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

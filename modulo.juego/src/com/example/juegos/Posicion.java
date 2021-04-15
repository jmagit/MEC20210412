package com.example.juegos;

import com.example.anotations.Autor;
import com.example.exceptions.JuegoException;

@Autor(nombre = "Yo mismo")
//@Table("POSICIONES")
//@Value
public class Posicion {
//	@Colum("kk")
//	@NotNull
//	@Range(min=0, max=7)
	
//	@Textbox()
//	@Title("Fila:")
	private int fila;
	private int columna;

	public Posicion(int fila, int columna) throws JuegoException {
		if(0 > fila || fila > 7)
			throw new JuegoException("Fila fuera de rango");
		if(0 > columna || columna > 7)
			throw new JuegoException("Columna fuera de rango");
		this.fila = fila;
		this.columna = columna;
	}

	@Autor(nombre = "Yo mismo", fecha = "Otra fecha")
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	
}

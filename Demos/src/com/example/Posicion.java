package com.example;

@Autor(nombre = "Yo mismo")
//@Table("POSICIONE")
public class Posicion {
//	@Colum("kk")
//	@NotNull
//	@Range(min=0, max=7)
	private int fila, columna;

	public Posicion(int fila, int columna) {
		if(0 > fila || fila > 7)
			throw new IndexOutOfBoundsException();
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

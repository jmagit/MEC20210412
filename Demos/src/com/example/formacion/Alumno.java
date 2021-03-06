package com.example.formacion;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona {
	public class Nota {
		private Asinatura asinatura;
		private double resultado;
		public Nota(Asinatura asinatura, double resultado) {
			this.asinatura = asinatura;
			this.resultado = resultado;
		}
		public Asinatura getAsinatura() {
			return asinatura;
		}
		public double getResultado() {
			return resultado;
		}
	}
	private List<Nota> resultados = new ArrayList<>();
	
	public Alumno(int id, String nombre, String apellidos, int edad) {
		super(id, nombre, apellidos, edad);
	}
}

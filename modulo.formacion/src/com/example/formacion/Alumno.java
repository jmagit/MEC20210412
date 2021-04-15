package com.example.formacion;

import java.util.ArrayList;
import java.util.List;

import com.example.formacion.db.Repository;

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
	
	public void guardar() {
		var dao = new Repository();
		dao.save();
	}
	
	public double getResultado(Asinatura asignatura) {
		return resultados.stream()
					.filter(item -> item.getAsinatura().getId() == asignatura.getId())
					.mapToDouble(item -> item.getResultado())
					.sum();
	}
}

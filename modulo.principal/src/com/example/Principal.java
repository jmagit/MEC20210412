package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.formacion.Alumno;
import com.example.formacion.Asinatura;
import com.example.formacion.Persona;
import com.example.formacion.Profesor;

public class Principal {

	public Principal() {
	
	}

	public static void main(String[] args) {
		consultas();

	}
	public static void consultas() {
		List<Persona> l = new ArrayList<>();
		l.add(new Alumno(1, null, null, 0));
		l.add(new Alumno(2, null, null, 0));
		l.add(new Profesor(3, null, null, 0));
		l.add(new Alumno(4, null, null, 0));
		l.add(new Alumno(2, null, null, 0));
		System.out.println("Hola mundo");
//		var x = new Aula();
//		var x = new com.example.formacion.db.Repository();
		var a = new Alumno(1, null, null, 0);
		a.guardar();
		
		l.stream().filter(item -> item instanceof Alumno)
			.map(item -> (Alumno)item)
			.skip(1)
			.limit(2)
			.forEach(item -> System.out.println(item.getId() + " " + item.getResultado(new Asinatura(0, null))));
	}

}

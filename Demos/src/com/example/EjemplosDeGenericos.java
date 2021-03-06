package com.example;

import java.util.ArrayList;
import java.util.List;

public class EjemplosDeGenericos {
	interface Validable {
		boolean esValido();
	}
	abstract class Persona {
		public void saluda() { }
	}
	class Profesor extends Persona {
		
	}
	class Alumno extends Persona implements Validable {

		@Override
		public boolean esValido() {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
	class Aula implements Validable {

		@Override
		public boolean esValido() {
			// TODO Auto-generated method stub
			return false;
		}
		
		<U extends Persona> U setAsistente(U asistente) {
			// 
			asistente.saluda();
			return asistente;
		}
		<U extends Persona> void setAsistentes(U asistente) {
			// 
			asistente.saluda();
			//return asistente;
		}
//		<U extends Persona> U getAsistente(Class tipo) {
//			// 
//			try {
//			U var;
//				U var = (U)tipo.newInstance();
//			return var;
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new JuegoException("Algo", e);
//			}
//			
//		}
		
	}

	// Interfaz con genericos
	interface Repositorio<T, K> {
		List<T> getAll();
		T getById(K id);
		void add(T item);
		void modify(T item);
		void delete(T item);
		void deleteById(K id);
	}
	
	// Interfaz que resuelve los genericos
	interface ProfesorRepository extends Repositorio<Profesor, Integer> {
		
	}
	// Implementar el interfaz con los tipos resueltos
	class ProfesorRepositoryImpl implements ProfesorRepository {

		@Override
		public List<Profesor> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Profesor getById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(Profesor item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void modify(Profesor item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Profesor item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteById(Integer id) {
			// TODO Auto-generated method stub
			
		}
		
	}
	interface AlumnoRepository extends Repositorio<Alumno, Integer> {
		
	}
	interface AulaRepository extends Repositorio<Aula, String> {
		
	}
	
	class AlumnoRepositoryImpl implements AlumnoRepository {

		@Override
		public List<Alumno> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Alumno getById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(Alumno item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void modify(Alumno item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Alumno item) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteById(Integer id) {
			// TODO Auto-generated method stub
			
		}
	}
// Restringir los posibles tipos
//	class Elemento<K extends Persona & Validable> {
//	class Elemento<K extends Validable & Otro> {
//	class Elemento<K extends Persona> {
	class Elemento<K> {
		private K key;
		private String value;
		
		public Elemento(K key, String value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public void setKey(K key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	class ElementoCadena extends Elemento<String> {
		public ElementoCadena(String key, String value) {
			super(key, value);
		}
		public ElementoCadena() {
			this("", "");
		}
	}
/*	Demasiado flexible
	class Elemento {
		private Object key;
		private String value;
		
		public Elemento(Object key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		public Object getKey() {
			return key;
		}
		public void setKey(Object key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
*/
	
	// Poco flexible
	class ElementoInt {
		private int key;
		private String value;
		
		public ElementoInt(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	class ElementoChar {
		private char key;
		private String value;
		
		public ElementoChar(char key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		public char getKey() {
			return key;
		}
		public void setKey(char key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}

	// Resoluci?n de los tipos genericos
	void test() {
		/* Object
		var provincia = new Elemento(28, "Madrid");
		var genero = new Elemento('M', "Masculino");
		var codigo = new Elemento("M33", "Silla");
		genero.setKey(1);
		*/
		var provincia = new Elemento<Integer>(28, "Madrid");
		var genero = new Elemento<Character>('M', "Masculino");
		var codigo = new Elemento<String>("M33", "Silla");
		genero.setKey('m');
		var alum = new Elemento<Alumno>(new Alumno(), "Silla");
		var aula = new Elemento<Aula>(new Aula(), "Silla");
//		alum.setKey(new Profesor());
		List<? extends Persona> lista = new ArrayList<Alumno>();
		procesa(new ArrayList<Alumno>());
		//procesa(new ArrayList<Aula>());
//		if(genero instanceof Elemento)
		Aula a = new Aula();
		var rslt = a.setAsistente(new Alumno());
		
	}
	// Restringir los posibles tipos usados
	void procesa(List<? extends Persona> lista) {
		
	}
}

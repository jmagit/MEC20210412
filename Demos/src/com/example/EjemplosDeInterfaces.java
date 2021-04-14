package com.example;

public class EjemplosDeInterfaces {
	
	interface Grafico {
		static final int MAX = 1024;
		static int resolucion(int filas, int columnas) {
			return filas * columnas;
		}
		void pintate();
		void test();
		default void resumen() {
			test();
		}
	}
	interface Validable {
		boolean esValido();
		void test();
		default void resumen() {
			test();
		}
	}
	
	interface Grande {
		void m1();
		void m2();
		void m3();
		void m4();
		void m5();
		void m6();
		void m7();
		void m8();
		void m9();
	}
	
	interface GraficoValido extends Grafico, Validable {

		@Override
		default void resumen() {
			// TODO Auto-generated method stub
			Grafico.super.resumen();
		}
		
	}
	class Y implements GraficoValido {

		@Override
		public void pintate() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean esValido() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}
		
	}
	class X implements Grafico, Validable {

		@Override
		public void pintate() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean esValido() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void test() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void resumen() {
			// TODO Auto-generated method stub
			Grafico.super.resumen();
		}
	}
	
	void prueba() {
		GraficoValido g;
		var x = new X();
		x.resumen();
	}
}

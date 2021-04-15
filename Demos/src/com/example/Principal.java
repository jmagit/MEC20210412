package com.example;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;



public class Principal {
	public enum Genero {
		DESCONOCIDO, MASCULINO, FEMENINO, NEUTRO
	}

	public enum Day {
		SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

		private int numericValue;

		private Day(int value) {
			numericValue = value;
		}

		public int getValue() {
			return numericValue;
		}

		public static Day getEnum(int key) {
			return switch (key) {
			case 1 -> SUNDAY;
			case 2 -> MONDAY;
			case 3 -> TUESDAY;
			case 4 -> WEDNESDAY;
			case 5 -> THURSDAY;
			case 6 -> FRIDAY;
			case 7 -> SATURDAY;
			default -> throw new IllegalArgumentException("Unexpected value: " + key);
			};
		}
	}

	public static void main(String[] args) {
		Factura.Estado estado = Factura.Estado.NUEVA;
		Pedido.Estado otroEstado = Pedido.Estado.NUEVA;
		Factura.Direccion dir = new Factura.Direccion();
		var fac = new Factura();
//		Factura.Linea l = new fac.Linea(null, 0);
		
		
		reflexion("com.example.Posicion", "getColumna");
//		reflexion("com.example.Posicion", "getFila");
		Posicion p;
		try {
			p = new Posicion(0, 0);
			System.out.println(p.getClass().getAnnotation(Autor.class).nombre());
		} catch (JuegoException e) {
		}
		mover(0, 0, 20, 0);
	}

	public static void mover(int filaini, int columnaini, int filafin, int columnafin) {
		assert 0 <= filaini && filaini < 8 : "Fila inicial fuera de rango";
		assert 0 <= filafin && filafin < 8 : "Fila final fuera de rango";
		// ...
		System.out.println("OK");
	}

	public static void reflexion(String nombre, String metodo) {
		try {
			Class<?> clase = Class.forName(nombre);
//		Class<?> clase = Posicion.class;
//		clase = Juego.class;

			for (var m : clase.getDeclaredMethods())
				System.out.println(m.getName());
			for (var f : clase.getDeclaredFields())
				System.out.println(f.getName());

			Object o = clase.getConstructors()[0].newInstance(1, 2);
			// var m = clase.getDeclaredMethods()[0];
			var f = clase.getDeclaredField(metodo.substring(3).toLowerCase());
			f.setAccessible(true);
			System.out.println(f.get(o));
			f.set(o, 666);
			var m = clase.getDeclaredMethod(metodo);
			System.out.println(m.invoke(o));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Enumerado(String[] args) {
		int i = 9;
		Genero genero = Genero.DESCONOCIDO;
		// genero = 0;
		Day day = Day.FRIDAY;
		i = day.getValue();
		day = Day.getEnum(2);

		System.out.println("Es un valor " + switch (i) {
		case 1, 3, 5, 7, 9: {
			yield "Impar";
		}
		case 2, 4, 6, 8: {
			yield "Par";
		}
		default:
			yield "muy grande";
		});

		System.out.println("Es un valor " + switch (++i) {
		case 1, 3, 5, 7, 9 -> "Impar";
		case 2, 4, 6, 8 -> "Par";
		default -> "muy grande";
		});
	}

	public static void Clonacion() throws Exception {
		Juego juego = new Juego();
		juego.init();
		// ...

		var t = juego.getTablero();
		var s = "";
		var x = (short) 4;
		List<Pieza> list = new ArrayList<Pieza>();

		System.out.println("Dentro del Juego");
		for (int f = 0; f < 8; f++)
			for (int c = 0; c < 8; c++)
				if (t.hayPieza(f, c))
					System.out.println("Hay pieza en " + f + "-" + c);
				else
					System.out.println("No hay pieza en " + f + "-" + c);
		// ...
		t.ponPieza(0, 0, null);
		System.out.println("Fuera del juego");
		Juego juego2 = juego.clone();
		// juego.tablero.ponPieza(0, 0, null);
		try {
			juego.mover(0, 0, 0, 1);
			juego.mover(null, null);
			if(true) throw new JuegoException("");
			// ...
		} catch (JuegoException e) {
			// ...
			throw e;
		}
		juego.mover("A1B2");
		var otro = juego2.getTablero();
		for (int f = 0; f < 8; f++)
			for (int c = 0; c < 8; c++)
				if (otro.hayPieza(f, c))
					System.out.println("Hay pieza en " + f + "-" + c);
				else
					System.out.println("No hay pieza en " + f + "-" + c);
		if (t.damePieza(0, 0) instanceof Rey) {
			Rey rey = (Rey) t.damePieza(0, 0);
			// ...
		}
//		if(t.damePieza(0, 0) instanceof Rey rey) {
//			// ...
//		}

	}
}

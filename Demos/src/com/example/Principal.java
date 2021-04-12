package com.example;

import java.util.ArrayList;
import java.util.List;


public class Principal {
	public enum Genero { DESCONOCIDO, MASCULINO, FEMENINO, NEUTRO }
	public enum Day {
	    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4),
	    THURSDAY(5), FRIDAY(6), SATURDAY(7);
		
	    private int numericValue;
	    
	    private Day(int value) { numericValue = value; }

	    public int getValue() { return numericValue; }
	    public static Day getEnum(int key) {
	    	return switch (key) {
			case 1 -> SUNDAY;  case 2 -> MONDAY; case 3 -> TUESDAY; case 4 -> WEDNESDAY;
			case 5 -> THURSDAY; case 6 -> FRIDAY; case 7 -> SATURDAY;
			default -> throw new IllegalArgumentException("Unexpected value: " + key);
			};
	    }
	}

	public static void main(String[] args) {
		int i = 9;
		Genero genero = Genero.DESCONOCIDO;
		//genero = 0;
		Day day = Day.FRIDAY;
		i = day.getValue();
		day = Day.getEnum(2);
		
		System.out.println("Es un valor " + switch (i) {
		case 1, 3, 5, 7, 9: {			
			yield "Impar";
		}
		case 2,4,6,8: {			
			yield "Par";
		}
		default:
			yield "muy grande";
		});
		
		System.out.println("Es un valor " + switch (++i) {
			case 1, 3, 5, 7, 9 -> "Impar"; case 2,4,6,8 -> "Par"; default -> "muy grande";
		});
	}
	public static void Clonacion() {
		Juego juego = new Juego();
		juego.init();
		// ...
		
		var t = juego.getTablero();
		var s = "";
		var x = (short)4;
		List<Pieza> list = new ArrayList<Pieza>();
		
		System.out.println("Dentro del Juego");
		for(int f = 0; f < 8; f++)
			for(int c = 0; c < 8; c++)
				if(t.hayPieza(f, c))
					System.out.println("Hay pieza en " + f + "-" + c);
				else 
					System.out.println("No hay pieza en " + f + "-" + c);
		// ...
		t.ponPieza(0, 0, null);
		System.out.println("Fuera del juego");
		Juego juego2 = juego.clone();
		// juego.tablero.ponPieza(0, 0, null);
		juego.mover(0, 0, 0, 1);
		var otro = juego2.getTablero();
		for(int f = 0; f < 8; f++)
			for(int c = 0; c < 8; c++)
				if(otro.hayPieza(f, c))
					System.out.println("Hay pieza en " + f + "-" + c);
				else 
					System.out.println("No hay pieza en " + f + "-" + c);
		if(t.damePieza(0, 0) instanceof Rey) {
			Rey rey = (Rey) t.damePieza(0, 0);
			// ...
		}
//		if(t.damePieza(0, 0) instanceof Rey rey) {
//			// ...
//		}

	
	}
}

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Delegados {
	@FunctionalInterface
	interface Comparable {
		int compara(String uno, String otro);
	}

	// Ejemplos con clases explicitas
	static class ComparaAsc implements Comparable {
		@Override
		public int compara(String a, String b) {
			return a.compareTo(b);
		}
	}

	static class ComparaDesc implements Comparable {
		@Override
		public int compara(String a, String b) {
			return -a.compareTo(b);
		}
	}
	public static int comparaDesc(String a, String b) {
		return -a.compareTo(b);
	}
	public static Comparable defaultComparator() {
		return new ComparaAsc();
	}
	public int comparaLocal(String a, String b) {
		return -a.compareTo(b);
	}

	void test() {
		String[] t = new String[100];
		var d = new Delegados();
		// ....
		ordena(t,  new ComparaAsc());
		ordena(t,  new ComparaDesc());
		ordena(t,  Delegados::comparaDesc);
		ordena(t,  Delegados.defaultComparator());
		ordena(t,  d::comparaLocal);
		ordena(t,  String::compareTo);
		
		ordena(t, new Comparable() {
			@Override
			public int compara(String a, String b) {
				return a.compareTo(b);
			}
		});
		ordena(t, new Comparable() {
			@Override
			public int compara(String a, String b) {
				return -a.compareTo(b);
			}
		});
		ordena(t, new Comparable() {
			@Override
			public int compara(String a, String b) {
				return a.compareToIgnoreCase(b);
			}
		});
		ordena(t, new Comparable() {
			@Override
			public int compara(String a, String b) {
				return -a.compareToIgnoreCase(b);
			}
		});
		ordena(t, (a, b) -> {
			a = a.toLowerCase();
			return -a.compareToIgnoreCase(b);
			});
		filtra(t, new Predicate<String>() {
			@Override
			public boolean test(String cad) {
				return cad.startsWith("P");
			}
		});
		filtra(t, s -> s.startsWith("P"));
	}

	// Version 3: Delegados, 
	List<String> filtra(String[] tabla, Predicate<String> where) {
		List<String> rslt = new ArrayList<String>();
		for(var item: tabla) 
			if(where.test(item))
				rslt.add(item);
		return rslt;
	}
	void ordena(String[] tabla, Comparable comparador) {
		String a = "", b = "";
		// ...
		if (comparador.compara(a, b) < 0) {

		} else if (comparador.compara(a, b) == 0) {

		} else {

		}
		// ...
	}
	/*
	 * Version 2: Tipo
	 * enum Tipo { ASC, DESC, TEXT, BIN } void ordena(String[] tabla, Tipo tipo) {
	 * String a, b; // ... switch (tipo) { case ASC: if(a < b) {
	 * 
	 * } else if(a == b) {
	 * 
	 * } else {
	 * 
	 * } break; case DESC: if(a > b) {
	 * 
	 * } else if(a == b) {
	 * 
	 * } else {
	 * 
	 * } break;
	 * 
	 * Version 1: Corta y pega
	 * 
	 * default: break; // Excepcion } // ... } void ordenaDesc(String[] tabla) {
	 * String a, b; // ... if(a > b) {
	 * 
	 * } else if(a == b) {
	 * 
	 * } else {
	 * 
	 * } // ... }
	 */
}

package com.example;

import java.util.Hashtable;
import java.util.List;

public class Factura {
	public static enum Estado { NUEVA, PENDIENTE, PAGADA, CANCELADA }
	public static class Direccion {
		
	}
	private int numFactura;
	private Estado estado;
	
	public class Linea {
		private String concepto; 
		private double cantidad;

		public Linea(String concepto, double cantidad) {
			this.concepto = concepto;
			this.cantidad = cantidad;
		}

		public String getConcepto() {
			return concepto;
		}
		public void setConcepto(String concepto) {
			this.concepto = concepto;
		}

		public double getCantidad() {
			return cantidad;
		}
		public void setCantidad(double cantidad) {
			this.cantidad = cantidad;
		}

		public int getNumFactura() {
			return numFactura;
		}
	}
	
	List<Linea> lineas;
	
	public void add(String concepto, double cantidad) {
		lineas.add(new Linea(concepto, cantidad));		
	}

	public int getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(int numFactura) {
		this.numFactura = numFactura;
//		lineas.forEach(item -> item.setNumFactura(numFactura));
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Linea> getLineas() {
		int local = 0;
		class M {
			public int name() {
				return local;
			}
		}
		M m = new M();
		
		return lineas; // clonar
	}
	
}

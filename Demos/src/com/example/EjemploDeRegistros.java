package com.example;

public class EjemploDeRegistros {
//	record Rectangle(double length, double width) { }

	class Rectangle {
		private final double length;
		private final double width;
		public Rectangle(double length, double width) {
			super();
			this.length = length;
			this.width = width;
		}
		public double getLength() {
			return length;
		}
		public double getWidth() {
			return width;
		}
		
	}
}

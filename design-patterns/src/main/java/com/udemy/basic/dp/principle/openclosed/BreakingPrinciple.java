package com.udemy.basic.dp.principle.openclosed;

/*it break open closed principle*/

public class BreakingPrinciple {

	class Rectangle {
		private int length;
		private int width;
	}

	class Circle {
		private int radius;
	}

	// any one come and modified for new shape area calculation
	public class AreaCaluclator {
		public double calculateRectangleArea(Rectangle rectangle) {
			return rectangle.length * rectangle.width;
		}

		public double clculateCrcleArea(Circle circle) {
			return (22 / 7) * circle.radius * circle.radius;
		}
	}
}

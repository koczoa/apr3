package optiSim;

public class Vector {
	private double x;
	private double y;
	
	Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y);
	}
	
	Vector subtract(Vector v) {
		return new Vector(x - v.x, y - v.y);
	}
	
	double getLenghtSqr() {
		return (x * x + y * y);
	}
	
	double getLenght() {
		return Math.sqrt(x * x + y * y);
	}
	
	Vector normalize() {
		double l = getLenght();
		x = x / l;
		y = y / l;
		return this;
	}
	
	Vector scale(double t) {
		x *= t;
		y *= t;
		return this;
	}
	
	double getAngle() {
		return Math.atan2(x, y);
	}
	
	double dist(Vector v) {
		double tx = (x < v.x) ? v.x - x : v.x - x;
		double ty = (y < v.y) ? v.y - y : v.y - y;
		return Math.sqrt(tx * tx + ty * ty);
	}
	
	
	Vector getNormalVector() {
		return new Vector(-this.getY(), this.getX());
	}
	
	double dotProduct(Vector a) {
		return a.getX() * x + a.getY() * y;
	}
	
	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
}
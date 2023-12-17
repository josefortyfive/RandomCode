package doomtest2.vector;

public class Vec2 {

	public double x;
	public double y;
	
	
	public Vec2() {
		
	}
	
	public Vec2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2(Vec2 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void rotate(double angle) {
		double nx = x * Math.cos(angle) - y * Math.sin(angle);
		double ny = x * Math.sin(angle) + y * Math.cos(angle);
		set(nx, ny);
 	}
	
	public void translate(double x, double y) {
		set(this.x + x, this.y + y);
	}
	
	public void scale(double s) {
		set(this.x * s, this.y * s);
	}
	
	public void add(Vec2 vec) {
		double nx = x + vec.x;
		double ny = y + vec.y;
		set(nx, ny);
	}
	
	public void sub(Vec2 vec) {
		double nx = x - vec.x;
		double ny = y - vec.y;
		set(nx, ny);
	}
	
	
	public static void sub(Vec2 r, Vec2 a, Vec2 b) {
		double nx = a.x - b.x;
		double ny = a.y - b.y;
		r.set(nx, ny);
	}

	public int getSign(Vec2 vector) {
		return (y * vector.x > x * vector.y) ? -1 : 1;
	}
	
	public double getLength() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Vec2 perp() {
		return new Vec2(-y, x);
	}
	
	public static void perp(Vec2 r, Vec2 v) {
		double nx = -v.y;
		double ny = v.x;
		r.set(nx, ny);
	}
	
	public double dot(Vec2 v) {
		return x * v.x + y * v.y;
	}
	
	public double cross(Vec2 v) {
		return x * v.y - y * v.x;
	}
	
	public double perpDot(Vec2 v) {
		return perp().dot(v);
	}
	
	public void normalize() {
		double length = getLength();
		
		if(length == 0) {
			x = 0;
			y = 0;
		}
		else {
			double den = 1 / length;
			x *= den;
			y *= den;
			
		}
	}
	
	
	public double getRelativeAngleBetween(Vec2 v) {
		return getSign(v) * Math.acos(dot(v) / (getLength() * v.getLength()));
	}
	
	public String toString() {
		return "Vec2{" + "x=" +x+ ", y=" +y+"}";
	}
}

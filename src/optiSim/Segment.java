package optiSim;

import java.awt.*;
import java.util.ArrayList;

public abstract class Segment implements Movable {
	Vector pos;
	Vector dir;
	double len;
	
	Segment(Vector pos, Vector dir, double len) {
		this.pos = pos;
		this.dir = dir;
		this.len = len;
	}
	
	public abstract void show(Graphics2D g2d);
	public abstract void hitByRay(ArrayList<Ray> rays, Ray asdf, Vector pls);
	
	public Vector getPos() {
		return pos;
	}
	public void setPos(Vector v) {
		this.pos = pos.add(v);
	}
	public Vector getDir() {
		return dir;
	}
	public void setDir(Vector v) {
		this.dir = dir.add(v);
	}
	
	public boolean clicked(double x, double y) {
		Vector c = new Vector(x, y);
		Vector r = this.getPos().subtract(c);
		double d = this.getPos().getNormalVector().dotProduct(r);
		double l = this.getDir().dotProduct(r);
		if(l > 0 && l < len && Math.abs(d) < 10) {
			return true;
		}
		return false;
	}
	
}
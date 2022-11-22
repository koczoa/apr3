package optiSim;

import java.awt.*;
import java.util.List;

public abstract class LightManipulatingElement implements Clickable {
	protected Vector pos;
	protected Vector dir;
	protected double len;
	
	public LightManipulatingElement(Vector pos, Vector dir, double len) {
		this.pos = pos;
		this.dir = dir;
		this.len = len;
	}
	
	public LightManipulatingElement(double x1, double y1, double x2, double y2) {
		Vector startPos = new Vector(x1, y1);
		Vector endPos = new Vector(x2, y2);
		Vector dir = endPos.subtract(startPos);
		this.pos = startPos;
		this.dir = dir.normalize();
		this.len = dir.getLenght();
	}
	
	public abstract void show(Graphics2D g2d);
	public abstract void hitByRay(List<Ray> rays, Ray asdf, Vector pls);
	public abstract Vector cast(Ray ray);
	
	public Vector getPos() {
		return pos;
	}
	public void setPos(Vector v) {
		this.pos = v;
	}
	public Vector getDir() {
		return dir;
	}
	public void setDir(Vector v) {
		this.dir = v;
	}
	public double getLen() {
		return len;
	}
	public void setLen(double len) {
		this.len = len;
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
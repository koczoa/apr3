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
		this.dir.normalize();
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
	
}
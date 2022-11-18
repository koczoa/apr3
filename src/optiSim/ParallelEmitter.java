package optiSim;

import java.util.ArrayList;
import java.util.List;

public class ParallelEmitter implements Emitter, Movable {
	private Vector pos;
	private Vector dir;
	private int len;
	private int n;

	public ParallelEmitter(double x, double y, double dx, double dy, int len, int n) {
		this.pos = new Vector(x, y);
		this.dir = new Vector(dx, dy);
		this.len = len;
		this.n = n;
	}
	
	
	@Override
	public List<Ray> emit() {
		ArrayList<Ray> rays = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			Vector deltaPos = new Vector((this.pos.getX() + this.dir.getX() * i * len / n), (this.pos.getY() + this.dir.getY() * i * len / n));
			rays.add(new Ray(deltaPos, new Vector(1, 0), 255));
		}
		return rays;
	}
	
	
	@Override
	public Vector getPos() {
		return pos;
	}

	@Override
	public void setPos(Vector v) {
		this.pos = v;
	}

	@Override
	public Vector getDir() {
		return this.dir;
	}

	@Override
	public void setDir(Vector v) {
		this.dir = v;
		
	}

	@Override
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

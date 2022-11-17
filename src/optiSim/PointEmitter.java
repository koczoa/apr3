package optiSim;

import java.util.ArrayList;
import java.util.List;

public class PointEmitter implements Emitter, Movable {
	private Vector pos;
	private int n;
	
	public PointEmitter(double x, double y, int n) {
		this.pos = new Vector(x, y);
		this.n = n;
	}

	@Override
	public List<Ray> emit() {
		ArrayList<Ray> rays = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			double angle = 2*Math.PI * i / n;
			Vector dir = new Vector(Math.cos(angle), Math.sin(angle));
			rays.add(new Ray(this.pos, dir, 255));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDir(Vector v) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean clicked(double x, double y) {
		Vector c = new Vector(x, y);
		if(this.getPos().subtract(c).getLenghtSqr() < 100) {
			return true;
		}
		return false;
	}
}

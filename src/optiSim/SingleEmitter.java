package optiSim;

import java.util.ArrayList;
import java.util.List;

public class SingleEmitter implements Emitter, Movable {
	private Vector pos;
	private Vector dir;
	
	public SingleEmitter(double x, double y, double dx, double dy){
		this.pos = new Vector(x, y);
		this.dir = new Vector(dx, dy);
	}
	
	@Override
	public List<Ray> emit() {
		ArrayList<Ray> rays = new ArrayList<>();
		rays.add(new Ray(this.pos, this.dir, 255));
		return rays;
	}

	@Override
	public Vector getPos() {
		return this.pos;
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
		if(this.getPos().subtract(c).getLenghtSqr() < 100) {
			return true;
		}
		return false;
	}



}

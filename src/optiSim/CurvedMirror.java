package optiSim;

import java.awt.Graphics2D;
import java.util.List;

public class CurvedMirror extends LightManipulatingElement {
	private double r1;
	private Vector endPoint1, endPoint2;
/*
	public CurvedMirror(double x1, double y1, double x2, double y2, double r1) {
		endPoint1 = new Vector(x1, y1);
		endPoint2 = new Vector(x2, y2);
		Vector mid = new Vector((endPoint1.getX() + endPoint2.getX())/2, (endPoint1.getY() + endPoint2.getY())/2);
		super(mid, mid.getAngle(), endPoint1.subtract(endPoint2).getLenght());
		
	}*/
	public CurvedMirror(double x1, double y1, double x2, double y2, double r1) {
		super(x1, y1, x2, y2);
		this.r1 = r1;
	}
	

	@Override
	public void show(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hitByRay(List<Ray> rays, Ray asdf, Vector pls) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector cast(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

}

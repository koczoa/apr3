package optiSim;

import java.awt.*;
import java.util.List;

public class Blocker extends LightManipulatingElement {
	public Blocker(Vector pos, Vector dir, double len) {
		super(pos, dir, len);
	}
	
	public Blocker(double x1, double y1, double x2, double y2) {
		super(x1, y1, x2, y2);
	}	
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawLine((int)pos.getX(), (int)pos.getY(), (int)(pos.getX() + len * dir.getX()), (int)(pos.getY() + len * dir.getY()));
		g2d.setStroke(new BasicStroke(1));
	}
	
	public Vector cast(Ray ray) {
		double x1 = this.pos.getX();
		double y1 = this.pos.getY();
		double x2 = this.pos.getX() + (this.len * this.dir.getX());
		double y2 = this.pos.getY() + (this.len * this.dir.getY());
		
		double x3 = ray.pos.getX();
		double y3 = ray.pos.getY();
		double x4 = ray.pos.getX() + ray.dir.getX();
		double y4 = ray.pos.getY() + ray.dir.getY();
		
		double den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 -x4);
		if(den != 0) {
			double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4))/den;
			double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3))/den;
			if(t > 0 && t < 1 && u > 0) {
				return  new Vector(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
			}
		}
		return null;
	}
	
	public void hitByRay(List<Ray> rays, Ray asdf, Vector pls) {
		
	}
}
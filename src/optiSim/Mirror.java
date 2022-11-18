package optiSim;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Mirror extends Segment {
	public Mirror(Vector pos, Vector dir, double len) {
		super(pos, dir, len);
	}
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
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
	
	public void hitByRay(ArrayList<Ray> rays, Ray ray, Vector point) {
		if(ray.ttl > 2) {
			Vector sn = this.dir.getNormalVector();
			Vector pd = ray.dir.subtract(sn.scale(2*ray.dir.dotProduct(sn)));
			rays.add(new Ray(point, pd, ray.ttl - 1));
		}
	}
}
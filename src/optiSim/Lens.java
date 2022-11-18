package optiSim;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Lens extends Segment {
	double r1, r2, ri;
	Vector p1, p2;
	
	public Lens(Vector pos, Vector dir, double len, double r1, double r2, double ri) {
		super(pos, dir, len);
		this.r1 = r1;
		this.r2 = r2;
		this.ri = ri;
		Vector mid = new Vector((pos.getX() + (len/2 * dir.getX())), (pos.getY() + (len/2 * dir.getY())));
		double d1 = Math.sqrt(r1*r1 - (len*len/4));
		double d2 = Math.sqrt(r2*r2 - (len*len/4));
		double p1x = mid.getX() + d1 * dir.getNormalVector().getX();
		double p2x = mid.getX() - d2 * dir.getNormalVector().getX();
		double p1y = mid.getY() + d1 * dir.getNormalVector().getY();
		double p2y = mid.getY() - d2 * dir.getNormalVector().getY();
		this.p1 = new Vector(p1x, p1y);
		this.p2 = new Vector(p2x, p2y);
	}
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawLine((int)pos.getX(), (int)pos.getY(), (int)(pos.getX() + len * dir.getX()), (int)(pos.getY() + len * dir.getY()));
		g2d.setStroke(new BasicStroke(1));
		g2d.drawOval((int)(p1.getX() - r1), (int)(p1.getY() - r1), (int)(2*r1), (int)(2*r1));
		g2d.drawOval((int)(p2.getX() - r2), (int)(p2.getY() - r2), (int)(2*r2), (int)(2*r2));
	}
	
	public Vector cast(Ray ray) {
		Vector tempPos = ray.pos.subtract(p2);
		double a = ray.dir.getNormalVector().getX();
		double b = ray.dir.getNormalVector().getY();
		double r = this.r2;
		double c = a * tempPos.getX() + b * tempPos.getY();
		if((r*r - c*c) > 0) {
			double under = Math.sqrt(r*r - c*c);
			double x1 = (a * c + b * under);
			double y1 = (b * c - a * under);
			double x2 = (a * c - b * under);
			double y2 = (b * c + a * under);
			Vector first = new Vector(x1 + p2.getX(), y1 + p2.getY());
			Vector second = new Vector(x2 + p2.getX(), y2 + p2.getY());
			if(this.pos.dist(first) < this.pos.dist(second)) {
				return first;
			} else {
				return second;
			}
		}
		return null;
	}
	
	public void hitByRay(ArrayList<Ray> rays, Ray ray, Vector point) {
		if(ray.ttl > 2) {
			
		}
	}
}

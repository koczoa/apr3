package optiSim;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Lens extends LightManipulatingElement {
	private double r1, r2, ri;
	private Vector p1, p2;
	double d1, d2;
	Vector mid;
	
	public Lens(Vector pos, Vector dir, double len, double r1, double r2, double ri) {
		super(pos, dir, len);
		this.r1 = r1;
		this.r2 = r2;
		this.ri = ri;
		mid = new Vector((pos.getX() + (len/2 * dir.getX())), (pos.getY() + (len/2 * dir.getY())));
		if(r1 > 0) {
			d1 = Math.sqrt(r1*r1 - (len*len/4));
		} else {
			d1 = -1*Math.sqrt(r1*r1 - (len*len/4));
		} 
		if(r2 > 0) {
			d2 = Math.sqrt(r2*r2 - (len*len/4));
		} else {
			d2 = -1*Math.sqrt(r2*r2 - (len*len/4));
		}
		double p1x = mid.getX() + d1 * dir.getNormalVector().getX();
		double p2x = mid.getX() - d2 * dir.getNormalVector().getX();
		double p1y = mid.getY() + d1 * dir.getNormalVector().getY();
		double p2y = mid.getY() - d2 * dir.getNormalVector().getY();
		this.p1 = new Vector(p1x, p1y);
		this.p2 = new Vector(p2x, p2y);
	}
	
	public Lens(double x1, double y1, double x2, double y2, double r1, double r2, double ri) {
		super(x1, y1, x2, y2);
		this.r1 = r1;
		this.r2 = r2;
		this.ri = ri;
		mid = new Vector((pos.getX() + (len/2 * dir.getX())), (pos.getY() + (len/2 * dir.getY())));
		if(r1 > 0) {
			d1 = Math.sqrt(r1*r1 - (len*len/4));
		} else {
			d1 = -1*Math.sqrt(r1*r1 - (len*len/4));
		} 
		if(r2 > 0) {
			d2 = Math.sqrt(r2*r2 - (len*len/4));
		} else {
			d2 = -1*Math.sqrt(r2*r2 - (len*len/4));
		}
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
		g2d.drawOval((int)(p1.getX() - Math.abs(r1)), (int)(p1.getY() - Math.abs(r1)), (int)(2*Math.abs(r1)), (int)(2*Math.abs(r1)));
		g2d.drawOval((int)(p2.getX() - Math.abs(r2)), (int)(p2.getY() - Math.abs(r2)), (int)(2*Math.abs(r2)), (int)(2*Math.abs(r2)));
		
		double dist1 = r1 - p1.subtract(mid).getLenght();
		double dist2 = r2 - p2.subtract(mid).getLenght();
		Vector up = new Vector((mid.getX() - dist2), pos.getY());
		double width = dist1 + dist2;
		double height = len;
		g2d.drawOval((int)(mid.getX() + dist1 - 5), (int)(mid.getY() - 5), 10, 10);
		g2d.drawOval((int)(mid.getX() - dist2 - 5), (int)(mid.getY() - 5), 10, 10);
		g2d.drawRect((int)up.getX(), (int)up.getY(), (int)width, (int)height);
		
		
	}
	
	public Vector cast(Ray ray) {
		List<Vector> intersections = new ArrayList<>();
		Vector tempPos = ray.pos.subtract(p1);
		double a = ray.dir.getNormalVector().getX();
		double b = ray.dir.getNormalVector().getY();
		double r = this.r1;
		double c = a * tempPos.getX() + b * tempPos.getY();
		if((r*r - c*c) > 0) {
			double under = Math.sqrt(r*r - c*c);
			double x1 = (a * c + b * under);
			double y1 = (b * c - a * under);
			double x2 = (a * c - b * under);
			double y2 = (b * c + a * under);
			intersections.add(new Vector(x1 + p1.getX(), y1 + p1.getY()));
			intersections.add(new Vector(x2 + p1.getX(), y2 + p1.getY()));
		}
		tempPos = ray.pos.subtract(p2);
		r = this.r2;
		c = a * tempPos.getX() + b * tempPos.getY();
		if((r*r - c*c) > 0) {
			double under = Math.sqrt(r*r - c*c);
			double x1 = (a * c + b * under);
			double y1 = (b * c - a * under);
			double x2 = (a * c - b * under);
			double y2 = (b * c + a * under);
			intersections.add(new Vector(x1 + p2.getX(), y1 + p2.getY()));
			intersections.add(new Vector(x2 + p2.getX(), y2 + p2.getY()));
		}
		
		
		
		
		/*
		if(intersections.size() == 4) {
			Vector closest = null;
			double record = Math.abs(r1*r2);
			for(int i = 0; i < 4; i++) {
				double d = intersections.get(i).subtract(ray.pos).getLenght();
				if(d < record) {
					d = record;
					closest = intersections.get(i);
				}
			}
			return closest;
		}
		*/
		return null;
	}
	
	public void hitByRay(List<Ray> rays, Ray ray, Vector point) {
		if(ray.ttl > 2) {
			
		}
	}
}
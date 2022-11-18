package optiSim;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class Ray {
	Vector pos;
	Vector dir;
	int ttl;
	
	public Ray(double x, double y, double dx, double dy, int ttl) {
		this(new Vector(x, y), new Vector(dx, dy), ttl);
	}
	public Ray(Vector pos, Vector angle, int ttl) {
		this.pos = pos;
		this.dir = angle;
		this.ttl = ttl;
	}
	/*
	//line line intersection
	public <T extends Segment> Vector cast(T stuff) {
		double x1 = stuff.pos.getX();
		double y1 = stuff.pos.getY();
		double x2 = stuff.pos.getX() + (stuff.len * stuff.dir.getX());
		double y2 = stuff.pos.getY() + (stuff.len * stuff.dir.getY());
		
		double x3 = this.pos.getX();
		double y3 = this.pos.getY();
		double x4 = this.pos.getX() + this.dir.getX();
		double y4 = this.pos.getY() + this.dir.getY();
		
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
	*/
	
	//line "circle" intersection
	
	public <T extends Segment> Vector cast(T stuff) {
		Vector tempPos = this.pos.subtract(new Vector(900, 450));
		double a = this.dir.getNormalVector().getX();
		double b = this.dir.getNormalVector().getY();
		double r = 250;
		double c = a * tempPos.getX() + b * tempPos.getY();
		if((r*r - c*c) > 0) {
			double under = Math.sqrt(r*r - c*c);
			double x1 = (a * c + b * under);
			double y1 = (b * c - a * under);
			double x2 = (a * c - b * under);
			double y2 = (b * c + a * under);
			Vector first = new Vector(x1 + 900, y1 + 450);
			Vector second = new Vector(x2 + 900, y2 + 450);
			if(this.pos.dist(first) < this.pos.dist(second)) {
				return first;
			} else {
				return second;
			}
		}
		return null;
	}
	
	public void castAll(ArrayList<Ray> rays, ArrayList<Segment> segments, Graphics2D g2d) {
		g2d.setColor(Color.YELLOW);
		g2d.setStroke(new BasicStroke(1));
		double record = Main.width;
		Vector closest = null;
		Segment that = null;
		for(int i = 0; i < segments.size(); i++) {
			Vector nominee = this.cast(segments.get(i));
			
			if(nominee != null) {
				double d = this.pos.dist(nominee);
				if(d < record && d > 0.000000000001) {
					record = d;
					closest = nominee;
					that = segments.get(i);
				}
			}
		}
		
		if(closest != null) {
			
			g2d.draw(new Line2D.Double(this.pos.getX(), this.pos.getY(), closest.getX(), closest.getY()));
			that.hitByRay(rays, this, closest);
		}
	}
}
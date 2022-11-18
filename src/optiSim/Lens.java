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
		g2d.drawOval((int)p1.getX() - 5, (int)p1.getY() - 5, 10, 10);
		g2d.drawOval((int)p2.getX() - 5, (int)p2.getY() - 5, 10, 10);
	}
	
	public void hitByRay(ArrayList<Ray> rays, Ray ray, Vector point) {
		if(ray.ttl > 2) {
			
		}
	}

}

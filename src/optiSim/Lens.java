package optiSim;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Lens extends Segment {
	
	double r1, r2, ri;
	
	public Lens(Vector pos, Vector dir, double len, double r1, double r2, double ri) {
		super(pos, dir, len);
		this.r1 = r1;
		this.r2 = r2;
		this.ri = ri;
	}
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawLine((int)pos.getX(), (int)pos.getY(), (int)(pos.getX() + len * dir.getX()), (int)(pos.getY() + len * dir.getY()));
		g2d.setStroke(new BasicStroke(1));
	}
	
	public void hitByRay(ArrayList<Ray> rays, Ray ray, Vector point) {
		if(ray.ttl > 2) {
			
		}
	}

}

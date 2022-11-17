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
	
	public void hitByRay(ArrayList<Ray> rays, Ray ray, Vector point) {
		if(ray.ttl > 2) {
			Vector sn = this.dir.getNormalVector();
			Vector pd = ray.dir.subtract(sn.scale(2*ray.dir.dotProduct(sn)));
			rays.add(new Ray(point, pd, ray.ttl - 1));
		}
	}
}
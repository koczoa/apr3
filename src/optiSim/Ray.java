package optiSim;

import java.awt.*;
import java.awt.geom.*;
import java.util.List;

public class Ray {
	Vector pos;
	Vector endPos;
	Vector dir;
	int ttl;
	
	public Ray(double x, double y, double dx, double dy, int ttl) {
		this(new Vector(x, y), new Vector(dx, dy), ttl);
	}
	
	public Ray(Vector pos, Vector angle, int ttl) {
		this.pos = pos;
		this.dir = angle;
		this.ttl = ttl;
		this.endPos = null;
	}
	
	public void castAll(List<Ray> rays, List<LightManipulatingElement> segments) {
		double record = Main.width;
		LightManipulatingElement that = null;
		for(int i = 0; i < segments.size(); i++) {
			Vector nominee = segments.get(i).cast(this);
			if(nominee != null) {
				double d = this.pos.dist(nominee);
				if(d < record && d > 0.000000000001) {
					record = d;
					endPos = nominee;
					that = segments.get(i);
				}
			}
		}
		
		if(endPos != null) {
			that.hitByRay(rays, this, endPos);
		}
	}
	
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.YELLOW);
		g2d.setStroke(new BasicStroke(1));
		if(this.endPos != null) {
			g2d.draw(new Line2D.Double(this.pos.getX(), this.pos.getY(), endPos.getX(), endPos.getY()));			
		}
	}
}
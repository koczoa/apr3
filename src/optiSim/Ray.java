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
	
	public void castAll(ArrayList<Ray> rays, ArrayList<Segment> segments, Graphics2D g2d) {
		g2d.setColor(Color.YELLOW);
		g2d.setStroke(new BasicStroke(1));
		double record = Main.width;
		Vector closest = null;
		Segment that = null;
		for(int i = 0; i < segments.size(); i++) {
			Vector nominee = segments.get(i).cast(this);
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
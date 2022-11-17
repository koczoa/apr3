package optiSim;

import java.awt.*;
import java.util.ArrayList;

public class Blocker extends Segment {
	public Blocker(Vector pos, Vector dir, double len) {
		super(pos, dir, len);
	}
	
	public void show(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawLine((int)pos.getX(), (int)pos.getY(), (int)(pos.getX() + len * dir.getX()), (int)(pos.getY() + len * dir.getY()));
		g2d.setStroke(new BasicStroke(1));
	}
	
	public void hitByRay(ArrayList<Ray> rays, Ray asdf, Vector pls) {
		
	}
}
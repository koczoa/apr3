package optiSim;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;

public class Sim implements ComponentListener, MouseListener, MouseMotionListener{
	public final List<Emitter> emitters;
	public final List<LightManipulatingElement> segments;
	public final List<Ray> rays;
	private final Blocker topwall;
	private final Blocker leftwall;
	private final Blocker bottomwall;
	private final Blocker rightwall;
	private MouseMode mm;
	
	public Sim() {
		mm = MouseMode.MOVE;
		int w = 100;
		int h = 100;
		emitters = new ArrayList<>();
		//emitters.add(new PointEmitter(100, 450, 360));
		//emitters.add(new SingleEmitter(100,  450, 1, 0));
		//emitters.add(new ParallelEmitter(100, 100, 0, 1, 700, 50));
		segments = new ArrayList<>();
		topwall = (new Blocker(new Vector(0, 0), new Vector(1, 0), w)); //top
		leftwall = (new Blocker(new Vector(0, 0), new Vector(0, 1), h)); // left
		bottomwall = (new Blocker(new Vector(0, h), new Vector(1, 0), w)); // bottom
		rightwall = (new Blocker(new Vector(w, 0), new Vector(0, 1), h)); //right
		segments.add(topwall);
		segments.add(leftwall);
		segments.add(bottomwall);
		segments.add(rightwall);
		//segments.add(new Lens(new Vector(750, 250), new Vector(1, 1), 400, 300, 250, 1.5));
		//segments.add(new Mirror(new Vector(750, 250), new Vector(1, 1), 200));
		//segments.add(new Mirror(new Vector(750, 550), new Vector(1, 1), 200));
		
		rays = new ArrayList<>();
	}
	
	public void update() {
		rays.clear();
		for(var e : emitters) {
			rays.addAll(e.emit());
		}
		
		for(int i = 0; i < rays.size(); i++) {
			rays.get(i).castAll(rays, segments);
		}
	}
	
	public void setMouseMode(MouseMode m) {
		this.mm = m;
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		int w = e.getComponent().getWidth();
		int h = e.getComponent().getHeight();
		topwall.setLen(w);
		leftwall.setLen(h);
		bottomwall.setPos(new Vector(0, h));
		bottomwall.setLen(w);
		rightwall.setPos(new Vector(w, 0));
		rightwall.setLen(h);
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(mm == MouseMode.POINT_EMITTER) {
			emitters.add(new PointEmitter(e.getX(), e.getY(), 180));
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

package optiSim;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final ArrayList<Emitter> emitters;
	private Timer looper = new Timer(1000/60, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	});
	
	public MyPanel() {
		emitters = new ArrayList<>();
		//emitters.add(new PointEmitter(100, 450, 360));
		//emitters.add(new SingleEmitter(100,  450, 1, 1));
		emitters.add(new ParallelEmitter(100, 300, 0, 1, 300, 10));
		looper.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		//g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.setBackground(Color.BLACK);
		
		//all stuff	
		ArrayList<Segment> segments = new ArrayList<Segment>() {
			private static final long serialVersionUID = 1L;
			{
				/*
				add(new Blocker(new Vector(0, 0), new Vector(1, 0), getWidth())); //top
				add(new Blocker(new Vector(0, 0), new Vector(0, 1), getHeight())); // left
				add(new Blocker(new Vector(0, getHeight()), new Vector(1, 0), getWidth())); // bottom
				add(new Blocker(new Vector(getWidth(), 0), new Vector(0, 1), getHeight())); //right
				*/
			}
		};
		
		//mirrors
		/*
		Mirror m1 = new Mirror(new Vector(750, 250), new Vector(1, 1), 200);
		Mirror m2 = new Mirror(new Vector(750, 550), new Vector(1, 1), 200);
		segments.add(m1);
		segments.add(m2);	
		*/
		//lenses
		segments.add(new Lens(new Vector(750, 250), new Vector(0, 1), 400, 300, 250, 1.5));
	
		//rays	
		ArrayList<Ray> tempRays = new ArrayList<>();
		for(var e : emitters) {
			tempRays.addAll(e.emit());
		}		
		
		for(int i = 0; i < tempRays.size(); i++) {
			tempRays.get(i).castAll(tempRays, segments, g2d);	
		}

		//showing segments
		for(int i = 0; i < segments.size(); i++) {
			segments.get(i).show(g2d);
		}
	}
}
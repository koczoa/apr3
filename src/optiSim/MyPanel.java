package optiSim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Sim sim;
	
	private Timer looper = new Timer(1000/60, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	});
	
	public MyPanel(Sim sim) {
		this.sim = sim;
		looper.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		//g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.setBackground(Color.BLACK);
		
		sim.update();
		
		//showing rays
		for(int i = 0; i < sim.rays.size(); i++) {
			sim.rays.get(i).show(g2d);
		}

		//showing segments
		for(int i = 0; i < sim.segments.size(); i++) {
			sim.segments.get(i).show(g2d);
		}
	}
	
	
}
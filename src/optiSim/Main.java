package optiSim;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;


public class Main implements Runnable {
	public static final int width = 1920;
	public static final int height = 900;

	
	public void run() {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(width, height));
		frame.setTitle("OptiSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JButton ray = new JButton("Ray");
		JButton blocker = new JButton("Blocker");
		JButton fmirror = new JButton("Mirror");
		JButton cmirror = new JButton("Curved Mirror");
		
		
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		
		west.add(ray);
		west.add(blocker);
		west.add(fmirror);
		west.add(cmirror);
		
		frame.add(west, BorderLayout.WEST);
		frame.add(east, BorderLayout.EAST);
		
		MyPanel panel = new MyPanel();	
		frame.add(panel);		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		javax.swing.SwingUtilities.invokeLater(m);
	}
}
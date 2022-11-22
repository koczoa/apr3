package optiSim;

import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;


public class Main{
	public static final int width = 1920;
	public static final int height = 900;

	public static void main(String[] args) {
		Sim sim = new Sim();
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(width, height));
		frame.setTitle("OptiSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		MyPanel panel = new MyPanel(sim);
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		
		for(var m : MouseMode.values()) {
			JButton button = new JButton(m.name);
			button.addActionListener(new MouseModeSelectorButtonListener(m, sim));
			west.add(button);
		}
		
		frame.add(west, BorderLayout.WEST);
		frame.add(east, BorderLayout.EAST);
		
			
		panel.addComponentListener(sim);
		panel.addMouseListener(sim);
		panel.addMouseMotionListener(sim);
		frame.add(panel);		
		frame.setVisible(true);
	}
}
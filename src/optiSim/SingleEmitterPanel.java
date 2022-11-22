package optiSim;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SingleEmitterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final SingleEmitter se;
	private JTextField x1tf, y1tf, x2tf, y2tf, ntf;
	
	
	public SingleEmitterPanel(SingleEmitter se) {
		this.se = se;
		JLabel x1l = new JLabel("x1: ");
		JLabel y1l = new JLabel("y1: ");
		JLabel x2l = new JLabel("x2: ");
		JLabel y2l = new JLabel("y2: ");
		JLabel nl = new JLabel("n: ");
		x1tf = new JTextField();
		y1tf = new JTextField();
		x2tf = new JTextField();
		y2tf = new JTextField();
		ntf = new JTextField();
		JPanel x1 = new JPanel();
		x1.add(x1l, x1tf);
		this.add(x1);
	}
}

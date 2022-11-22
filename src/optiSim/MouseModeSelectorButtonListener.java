package optiSim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseModeSelectorButtonListener implements ActionListener {
	private final MouseMode mm;
	private final Sim sim;
	
	public MouseModeSelectorButtonListener(MouseMode m, Sim s) {
		this.sim = s;
		this.mm = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sim.setMouseMode(mm);		
	}
}
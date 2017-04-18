package edu.gvsu.cis162.project4.GUI;

import edu.gvsu.cis162.project4.Interfaces.QueueListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * *************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI - by Preston Garno
 ***************************************************/
public class MainQueueDisplay extends JPanel implements QueueListener {

	//private static final Dimension PREF_SIZE = new Dimension(400, 300);
	private JPanel HOLDER;

	private final Icon runningIc;
	private final Icon regularIc;
	private final Icon handicapIc;
	private final List<JLabel> icons;

	/*****************************************
	 * Makes a mainQueue display
	 ****************************************/
	public MainQueueDisplay() {
		regularIc = Util.getRegularIcon();
		runningIc = Util.getRunningIcon();
		handicapIc = Util.getSpecialNeedsIcon();
		// adding the components to the panel
		JLabel titleLabel = new JLabel("~ Main Queue ~");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(titleLabel);
		titleLabel.setMaximumSize(new Dimension(200, 30));
		titleLabel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		HOLDER = new JPanel(new FlowLayout(FlowLayout.CENTER));
		this.add(HOLDER);
		HOLDER.setOpaque(true);
		HOLDER.setVisible(true);

		// add border for layout changes
		Border border = BorderFactory.createLoweredBevelBorder();
		this.setBorder(border);

		// swing configuration stuff
		this.setFocusable(false);
		this.setOpaque(false);
		this.setVisible(true);
		icons = new ArrayList<>();
	}

	@Override
	public void onUpdateQueue(List<PersonType> line) {
		HOLDER.setPreferredSize(new Dimension(getParent().getWidth(),
				getParent().getHeight() - 100));
		HOLDER.removeAll();
		int i;
		for (i = 0; i < line.size(); i++) {
			JLabel label = new JLabel();

			switch (line.get(i)) {
				case REGULAR:
					label.setIcon(this.regularIc);
					break;
				case HURRIED:
					label.setIcon(this.runningIc);
					break;
				case DISABLED:
					label.setIcon(this.handicapIc);
					break;
			}
			label.setOpaque(false);
			label.setVisible(true);
			HOLDER.add(label);
			HOLDER.revalidate();
		}
		HOLDER.repaint();
	}

	@Override
	public void onPersonLeaveQueue(int index) {
		if (!icons.isEmpty()) {
			icons.remove(index);
			HOLDER.revalidate();
			HOLDER.repaint();
		}
	}
}

package edu.gvsu.cis162.project4.GUI;

import edu.gvsu.cis162.project4.Interfaces.QueueListener;

import javax.swing.*;
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
		icons = new ArrayList<>();
		setLayout(new BorderLayout());
		JLabel title;
		add(title = new JLabel("Main Queue"), BorderLayout.NORTH);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		regularIc = Util.getRegularIcon();
		runningIc = Util.getRunningIcon();
		handicapIc = Util.getSpecialNeedsIcon();
		HOLDER = new JPanel(new FlowLayout());
		HOLDER.setVisible(true);
		this.add(HOLDER, BorderLayout.CENTER);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(500,400));
	}

	@SuppressWarnings("Duplicates")
	@Override
	public void onUpdateQueue(List<PersonType> line) {
		int i = 0;
		while (i++ > line.size()) {
			JLabel label;
			if (i > HOLDER.getComponentCount()) {
				label = (JLabel) HOLDER.getComponent(i);
			} else label = new JLabel();

			switch (line.get(i)) {
				case REGULAR:
					label.setIcon(this.regularIc);
				case HURRIED:
					label.setIcon(this.runningIc);
				case DISABLED:
					label.setIcon(this.handicapIc);
			}
			label.setOpaque(true);
			label.setVisible(true);
			label.setSize(40, 40);
			HOLDER.add(label);
			label.repaint();
		}
	}

	@SuppressWarnings("Duplicates")
	private void updateIcons(Iterator<Icon> it) {
		// update all of the existing icons
		int i;
		for (i = 0; i < HOLDER.getComponentCount() && it.hasNext(); i++) {
			JLabel label = (JLabel) HOLDER.getComponent(i);
			label.setIcon(it.next());
			label.setOpaque(true);
			label.setVisible(true);
			it.remove();
			label.repaint();
		}

		// if the updated queue is small
		if (!it.hasNext()) {
			while (i < HOLDER.getComponentCount()) {
				HOLDER.remove(i++);
			}
		}
		// add all remaining icons in the iterator
		while (it.hasNext() /*&& i < icons.getComponentCount()*/) {
			Icon icon = it.next();
			JLabel label = new JLabel(icon);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setOpaque(true);
			label.setVisible(true);
			HOLDER.add(label);
			it.remove();
			label.repaint();
		}
	}

	@Override
	public void onPersonLeaveQueue(int index) {
		if (!icons.isEmpty()) {
			icons.remove(index);
		}
	}
}

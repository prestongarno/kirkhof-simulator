package edu.gvsu.cis162.project4.GUI;

import edu.gvsu.cis162.project4.Interfaces.QueueListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.stream.Collectors;

/**
 * Created by preston on 4/16/17.
 */
public final class EateryCheckoutPanel extends JPanel implements ItemListener, QueueListener {

	private final Icon runningIc;
	private final Icon regularIc;
	private final Icon handicapIc;
	/**
	 * the Jpanel that holds all of the icons for each person
	 */

	private final JPanel HOLDER;

	public final List<JLabel> icons;
	private final JLabel titleLabel;
	private String title;
	private JCheckBox eateryCheckbox;

	public EateryCheckoutPanel(String title) {
		this.title = title;
		eateryCheckbox = new JCheckBox("Active");
		eateryCheckbox.setForeground(Color.GREEN);
		eateryCheckbox.addItemListener(this);
		eateryCheckbox.setMaximumSize(new Dimension(50, 20));

		regularIc = Util.getRegularIcon();
		runningIc = Util.getRunningIcon();
		handicapIc = Util.getSpecialNeedsIcon();
		// adding the components to the panel
		this.setLayout(new BorderLayout());
		titleLabel = new JLabel(title);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(eateryCheckbox, BorderLayout.PAGE_END);
		HOLDER = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		this.add(HOLDER, BorderLayout.CENTER);
		HOLDER.setOpaque(true);
		HOLDER.setVisible(true);

		// add border for layout changes
		Border border = BorderFactory.createLineBorder(Color.black);
		this.setBorder(border);

		// swing configuration stuff
		this.setFocusable(false);
		this.setOpaque(false);
		this.setVisible(true);
		icons = new ArrayList<>();
	}

	/*****************************************
	 * Getter for property 'title'.
	 *
	 * @return Value for property 'title'.
	 ****************************************/
	public String getTitle() {
		return title;
	}

	/*****************************************
	 * Setter for property 'title'.
	 *
	 * @param title Value to set for property 'title'.
	 ****************************************/
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (eateryCheckbox.isSelected()) {
			eateryCheckbox.setForeground(Color.GREEN);
		} else {
			eateryCheckbox.setForeground(Color.RED);
		}
	}

	@SuppressWarnings("Duplicates")
	@Override
	public void onUpdateQueue(List<PersonType> line) {
		int i;
		for (i = 0; i < line.size(); i++) {
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
			label.setOpaque(false);
			label.setVisible(true);
			label.setSize(40, 40);
			HOLDER.add(label);
			HOLDER.repaint();
		}

		while (++i < HOLDER.getComponentCount()) {
			HOLDER.remove(i);
			HOLDER.repaint();
		}
	}

	@Override
	public void onPersonLeaveQueue(int index) {
		if (!icons.isEmpty()) {
			icons.remove(index);
		}
	}
}

package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Interfaces.QueueListener;
import KirkhofSimulatorPack.LinkedList.CustomLinkedList;
import KirkhofSimulatorPack.people.Person;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


/** **************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI - by Preston Garno
 *
 * ***************************************************/
public class MainQueueDisplay extends JPanel implements QueueListener {
	
	private JPanel LINE;
	
	/*****************************************
	 * Makes a mainQueue display
	 ****************************************/
	public MainQueueDisplay() {
		setLayout(new BorderLayout());
		add(new JLabel("Main Queue"), BorderLayout.NORTH);
		LINE = new JPanel(new FlowLayout());
		this.add(LINE, BorderLayout.CENTER);

		this.setOpaque(true);
		this.setVisible(true);

	}
	
	@Override
	public void onUpdateQueue(List<PersonType> line) {
		for (PersonType t : line) {
			// TODO: 4/16/17 update from here
            JLabel label = new JLabel(t.getIcon());
		}
	}

	@Override
	public void onPersonLeaveQueue(int index) {

	}
}

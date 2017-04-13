package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.LinkedList.CustomLinkedList;
import KirkhofSimulatorPack.people.Person;

import javax.swing.*;
import java.awt.*;


/** **************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI - by Preston Garno
 * ***************************************************/
public class MainQueueDisplay extends JPanel {
	
	private JPanel LINE;
	
	/*****************************************
	 * Makes a mainQueue display
	 ****************************************/
	public MainQueueDisplay() {
		setLayout(new BorderLayout());
		add(new JLabel("Main Queue"));
		LINE = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
	
	/*****************************************
	 * Updates the image of the people in line
	 * @param queue
	 ****************************************/
	public void updateQueue(CustomLinkedList<Person> queue) {
		
		int i = 0;
		while (i < LINE.getComponentCount()) {
			
			Icon current = i < queue.size() ? queue.get(i).getIconRepresentation() : null;
			
			final Component existing = LINE.getComponent(i);
			
			if(!existing.equals(current)){
				((JLabel) existing).setIcon(current);
			}
			i++;
		}
		
		while (i++ < queue.size()) {
			LINE.add(new JLabel(queue.get(i).getIconRepresentation()));
		}
	}
	
}

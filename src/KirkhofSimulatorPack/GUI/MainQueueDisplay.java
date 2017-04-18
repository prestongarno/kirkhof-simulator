package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Interfaces.QueueListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


/** **************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI - by Preston Garno
 *
 * ***************************************************/
public class MainQueueDisplay extends JPanel implements QueueListener {

    private static final Dimension PREF_SIZE = new Dimension(200, 300);
	private JPanel HOLDER;
	private final JLabel title;

    private final List<JLabel> icons;
	/*****************************************
	 * Makes a mainQueue display
	 ****************************************/
	public MainQueueDisplay() {
        icons = new ArrayList<>();
		setLayout(new BorderLayout());
		add(title = new JLabel("Main Queue"), BorderLayout.NORTH);
		HOLDER = new JPanel(new FlowLayout());
		this.add(HOLDER, BorderLayout.CENTER);

		this.setOpaque(true);
		this.setVisible(true);
        this.setPreferredSize(PREF_SIZE);
	}
	
    @SuppressWarnings("Duplicates")
    @Override
    public void onUpdateQueue(List<PersonType> line) {
        SwingUtilities.invokeLater(() -> {
            // get an iterator of icons
            Iterator<Icon> it = line.stream().map(PersonType::getIcon)
                    .collect(Collectors.toCollection(ArrayList::new)).iterator();
            this.updateIcons(it);
        });
    }

    @SuppressWarnings("Duplicates")
    private void updateIcons(Iterator<Icon> it) {
        // update all of the existing icons
        HOLDER.removeAll();
        int i;
        for (i = 0; i < icons.size() && it.hasNext(); i++) {
            ((JLabel) this.HOLDER.getComponent(i)).setIcon(it.next());
            it.remove();
        }

        // if the updated queue is small
        if(!it.hasNext()) {
            while(i < HOLDER.getComponentCount()) {
                HOLDER.remove(i++);
            }
        }
        // add all remaining icons in the iterator
        while(it.hasNext() /*&& i < icons.getComponentCount()*/) {
            HOLDER.add(new JLabel(it.next()));
            it.remove();
        }
    }

	@Override
	public void onPersonLeaveQueue(int index) {
        this.HOLDER.remove(index);
	}
}

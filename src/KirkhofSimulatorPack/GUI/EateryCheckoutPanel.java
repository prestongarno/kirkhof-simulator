package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Interfaces.QueueListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.stream.Collectors;

/**
 * Created by preston on 4/16/17.
 */
public final class EateryCheckoutPanel extends JPanel implements ItemListener, QueueListener {

    private static final int PREF_WTH = 70;
    private static final int PREF_HGHT = 140;
    /** the Jpanel that holds all of the icons for each person
     */
    private final JPanel HOLDER;

    private final List<JLabel> icons;
    private final JLabel titleLabel;
    private String title;
    private JCheckBox eateryCheckbox;

    private final Dimension PREF_SIZE;

    public EateryCheckoutPanel(String title) {
        this.title = title;
        eateryCheckbox = new JCheckBox("Active");
        eateryCheckbox.setForeground(Color.GREEN);
        eateryCheckbox.addItemListener(this);

        // adding the components to the panel
        this.setLayout(new BorderLayout());
        titleLabel = new JLabel(title);
        this.add(titleLabel);
        this.add(eateryCheckbox, BorderLayout.PAGE_END);
        HOLDER = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.add(HOLDER);
        //icons = new LinkedList<>();

        // add border for layout changes
        Border border = BorderFactory.createLineBorder(Color.black);
        this.setBorder(border);

        PREF_SIZE = new Dimension(PREF_HGHT, PREF_WTH);
        //component sizing
        setPreferredSize(PREF_SIZE);
        // swing configuration stuff
        this.setFocusable(false);
        this.setOpaque(true);
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
        SwingUtilities.invokeLater(() -> {

            // get an iterator of icons
            Iterator<Icon> it = line.stream().map(PersonType::getIcon)
                    .collect(Collectors.toCollection(ArrayList::new)).iterator();
            this.updateIcons(it);
        });
    }

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
            icons.remove(index);
    }
}

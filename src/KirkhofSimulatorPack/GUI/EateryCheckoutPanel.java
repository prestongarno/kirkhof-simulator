package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Eatery;
import KirkhofSimulatorPack.Interfaces.QueueListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by preston on 4/16/17.
 */
public final class EateryCheckoutPanel extends JPanel implements ItemListener, QueueListener {

    /** the Jpanel that holds all of the icons for each person
     */
    private final JPanel line;

    //private final List<JLabel> icons; <-- just recreate labels for now each time
    private final JLabel titleLabel;
    private String title;
    private JCheckBox eateryCheckbox;

    public EateryCheckoutPanel(String title) {
        this.title = title;
        eateryCheckbox = new JCheckBox("Active");
        eateryCheckbox.setForeground(Color.GREEN);
        eateryCheckbox.addItemListener(this);

        // adding the components to the panel
        this.setLayout(new BorderLayout());
        titleLabel = new JLabel(title);
        this.add(titleLabel);
        this.add(eateryCheckbox, BorderLayout.AFTER_LAST_LINE);
        line = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.add(line);
        //icons = new LinkedList<>();

        // swing configuration stuff
        this.setFocusable(false);
        this.setOpaque(true);
        this.setVisible(true);
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

    @Override
    public void onUpdateQueue(List<PersonType> people) {
        // update the list of jlabels here
        this.line.removeAll();
        for (PersonType p : people) {
            line.add(new JLabel(p.getIcon()));
        }

    }

    @Override
    public void onPersonLeaveQueue(int index) {
        line.remove(index);

    }
}

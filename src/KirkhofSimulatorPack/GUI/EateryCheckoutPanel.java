package KirkhofSimulatorPack.GUI;

import KirkhofSimulatorPack.Eatery;
import KirkhofSimulatorPack.Interfaces.QueueListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by preston on 4/16/17.
 */
public final class EateryCheckoutPanel extends JPanel implements ItemListener, QueueListener {

    private Eatery eatery;
    private String title;
    private final List<JLabel> icons;
    private JCheckBox eateryCheckbox;

    public EateryCheckoutPanel(String title) {
        this.eatery = eatery;
        this.title = title;
        eateryCheckbox = new JCheckBox("Active");
        eateryCheckbox.setForeground(Color.GREEN);
        eateryCheckbox.addItemListener(this);
        icons = new ArrayList<>(10);
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
    public void onUpdateQueue(List<PersonType> line) {
        
    }

    @Override
    public void onPersonLeaveQueue(int index) {

    }
}

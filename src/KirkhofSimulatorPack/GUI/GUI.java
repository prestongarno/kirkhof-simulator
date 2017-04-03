package KirkhofSimulatorPack.GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.text.*;

/**
 * Created by Alex on 4/2/2017.
 */
public class GUI extends JFrame implements KeyListener, ActionListener  {

    /**panel for the GUI elements to be placed on*/
    JPanel panel;

    /**panel to use for the main program graphics */
    JPanel centerPanel;

    public GUI(){
        panel = new JPanel();
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,5));
        panel.setLayout(new BorderLayout());
        panel.setVisible(true);
        panel.setFocusable(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

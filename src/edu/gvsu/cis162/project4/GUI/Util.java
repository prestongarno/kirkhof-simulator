package edu.gvsu.cis162.project4.GUI;

import org.omg.CORBA.IMP_LIMIT;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


/**
 * *************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI
 * Static utility methods for handling resources and
 * icons
 *
 * @author Preston, Alex, Jessica, Chad
 * @version 4/18/17
 ****************************************/
public final class Util {

	private static final int ICON_HEIGHT = 40;
	private static final int ICON_WIDTH = 40;
	/*****************************************
	 * Variable icon to represent hurried person
	 ****************************************/
	public static Icon getRunningIcon() {
		return Util.loadIcon("RUNNING_PERSON.png", "");
	}
	/*****************************************
	 * Variable icon to represent regular person
	 ****************************************/
	public static Icon getRegularIcon() {
		return Util.loadIcon("REGULAR_PERSON.png", "");
	}
	/*****************************************
	 * Variable icon to represent special needs person
	 ****************************************/
	public static Icon getSpecialNeedsIcon() {
		return loadIcon("SPECIAL_NEEDS_PERSON.png", "");
	}

	/*****************************************
	 * Method to load icons for GUI
	 * @param resourceName name of icon to load
	 * @param description type of icon to load
	 * @return icon the image of icon loaded
	 * @throws RuntimeException Icon is not of expected name
	 ****************************************/
	public static Icon loadIcon(String resourceName, String description) {
		final ImageIcon icon;
		System.out.println(Util.class.getClassLoader());
		try {
			System.out.println(new File(".").getCanonicalPath());
			Image img = ImageIO.read(new File("res/" + resourceName)).getScaledInstance(ICON_WIDTH, ICON_HEIGHT, 8);
			icon = new ImageIcon(img);
			return icon;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new IllegalStateException();
	}

}

package KirkhofSimulatorPack.GUI;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


/** **************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI 
 * Static utility methods for handling resources and 
 * icons
 * @author Preston, Alex, Jessica, Chad
 * @version 4/18/17
 * ***************************************************/
public final class Util {
	/**Variable icon to represent hurried person*/
	public static final Icon RUNNING_PERSON;
	/**Variable icon to represent regular person*/
	public static final Icon REGULAR_PERSON;
	/**Variable icon to represent special needs person*/
	public static final Icon SPECIAL_NEEDS_PERSON;
	
	static {
		REGULAR_PERSON = Util.loadIcon("REGULAR_PERSON.png", "");
		SPECIAL_NEEDS_PERSON = loadIcon("SPECIAL_NEEDS_PERSON.png", "");
		RUNNING_PERSON = Util.loadIcon("RUNNING_PERSON.png", "");
	}
	

	/*****************************************************************
	 * Method to load icons for GUI
	 * @param resourceName name of icon to load
	 * @param description type of icon to load
	 * @return icon the image of icon loaded
	 * @throws RuntimeException Icon is not of expected name
	 ****************************************************************/
	public static Icon loadIcon(String resourceName, String description) {
		final ImageIcon icon;
		try {
			icon = new ImageIcon((new File("/src/res/" + resourceName).toPath().toUri()).toURL());
		} catch (MalformedURLException e) {
			throw new RuntimeException("Unknown resource name.");
		}
		icon.setDescription(description);
		return icon;
	}
	
}

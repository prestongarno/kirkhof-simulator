package KirkhofSimulatorPack.GUI;

import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


/** **************************************************
 * kirkhof-simulator - KirkhofSimulatorPack.GUI - by Preston Garno on 4/10/17
 *
 * static utility methods for handling resources
 * ***************************************************/
public final class Util {
	public static final Icon RUNNING_PERSON;
	public static final Icon REGULAR_PERSON;
	public static final Icon SPECIAL_NEEDS_PERSON;
	
	static {
		REGULAR_PERSON = Util.loadIcon("REGULAR_PERSON.png", "");
		SPECIAL_NEEDS_PERSON = loadIcon("SPECIAL_NEEDS_PERSON.png", "");
		RUNNING_PERSON = Util.loadIcon("RUNNING_PERSON.png", "");
	}
	
	@Nullable
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

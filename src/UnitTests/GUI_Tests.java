package UnitTests;

import KirkhofSimulatorPack.GUI.Util;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/** **************************************************
 * kirkhof-simulator - UnitTests - by Preston Garno on 4/10/17
 * ***************************************************/
public class GUI_Tests {
	
	
	@Test
	public void testImageLoader() throws Exception {
		assertNotNull(Util.loadIcon("REGULAR_PERSON.png", ""));
	}
	
	@Test
	public void testImageLoader_RunningPerson() throws Exception {
		assertNotNull(Util.loadIcon("RUNNING_PERSON.png", ""));
	}
	
	@Test
	public void testImageLoader_DisabledPerson() throws Exception {
		assertNotNull(Util.loadIcon("SPECIAL_NEEDS_PERSON.png", ""));
	}
}

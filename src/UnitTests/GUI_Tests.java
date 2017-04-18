package UnitTests;

import edu.gvsu.cis162.project4.GUI.Util;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * *************************************************
 * kirkhof-simulator - UnitTests - by Preston Garno on 4/10/17
 ***************************************************/
public class GUI_Tests {


	@Before
	public void setUp() throws Exception {
		//frame = new JFrame("test display icon");
	}

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

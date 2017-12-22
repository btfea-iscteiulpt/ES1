package gui_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.ConfigPanel;

public class ConfigPanelTestCase {
	
	@Test
	public void testGetRegras() {
		assertEquals(0,ConfigPanel.getRegras().size());
	}

}

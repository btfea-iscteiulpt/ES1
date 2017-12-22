package gui_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.TopPanel;
import gui.UserMenu;

public class TopPanelTestCase {
	
	@Test
	public void testTopPanel() {
		assertEquals("TopPanel", new TopPanel(new UserMenu()).getClass().getSimpleName());
		//Se for passada uma referência de user nula lança uma excepção. Para isto correr bem significa
		//que o user dado é válido
	}
	
	@Test
	public void testTopPanel_null() {
		new TopPanel(null);
	//	assertEquals("TopPanel", 
		//Se for passada uma referência de user nula lança uma excepção. Para isto correr bem significa
		//que o user dado é válido
	}

}

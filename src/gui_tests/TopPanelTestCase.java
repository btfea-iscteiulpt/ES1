package gui_tests;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.TopPanel;
import gui.UserMenu;

public class TopPanelTestCase {
	
	@Test
	public void testTopPanel() {
		assertEquals("TopPanel", new TopPanel(new UserMenu()).getClass().getSimpleName());
		//Se for passada uma refer�ncia de user nula lan�a uma excep��o. Para isto correr bem significa
		//que o user dado � v�lido
	}
	
	@Test
	public void testTopPanel_null() {
		new TopPanel(null);
	//	assertEquals("TopPanel", 
		//Se for passada uma refer�ncia de user nula lan�a uma excep��o. Para isto correr bem significa
		//que o user dado � v�lido
	}

}

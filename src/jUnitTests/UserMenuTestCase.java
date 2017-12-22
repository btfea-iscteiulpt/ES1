package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.UserMenu;

public class UserMenuTestCase {
UserMenu menu= new UserMenu();

	
	@Test
	public final void testGetManual_config() {
		assertEquals(null, menu.getManual_config());
	}

	@Test
	public final void testGetFrame() {
		menu.init();
		assertEquals("JFrame", menu.getFrame().getClass().getSimpleName());
	}

	@Test
	public final void testGetAuto_config() {
		assertEquals(null, menu.getAuto_config());
	}

	@Test
	public final void testGetFile_list() {
		assertEquals(0,menu.getFile_list().size());
	}
	
	
}

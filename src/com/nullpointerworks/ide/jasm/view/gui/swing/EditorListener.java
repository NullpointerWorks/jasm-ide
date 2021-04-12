package com.nullpointerworks.ide.jasm.view.gui.swing;

import java.awt.Component;

import javax.swing.JTabbedPane;

public interface EditorListener 
{
	
	
	
	void onTabOpening(JTabbedPane parent, Component child);
	
	void onTabClosing(JTabbedPane parent, Component child);

	void onModification();
	
}

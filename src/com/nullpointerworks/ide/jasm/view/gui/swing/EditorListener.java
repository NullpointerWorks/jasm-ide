package com.nullpointerworks.ide.jasm.view.gui.swing;

import javax.swing.JTabbedPane;

public interface EditorListener 
{
	
	
	
	void onTabOpening(JTabbedPane parent, ClosableTabHeader child);
	
	void onTabClosing(JTabbedPane parent, ClosableTabHeader child);

	void onModification();
	
}

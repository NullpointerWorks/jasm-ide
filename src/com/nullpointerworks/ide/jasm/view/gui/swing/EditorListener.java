package com.nullpointerworks.ide.jasm.view.gui.swing;

public interface EditorListener 
{
	void onTabHeaderLink(ClosableTabHeader t);
	
	void onTabOpening();
	void onTabClosing();

	void onModification();
	
	void onSaveAction();
	
	
	
}

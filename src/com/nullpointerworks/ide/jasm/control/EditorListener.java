package com.nullpointerworks.ide.jasm.control;

import com.nullpointerworks.ide.jasm.view.swing.ClosableTabHeader;

public interface EditorListener 
{
	void onTabHeaderLink(ClosableTabHeader t);
	
	void onTabOpening();
	void onTabClosing();

	void onModification();
	
	void onSaveAction();
	
	
	
}

package com.nullpointerworks.ide.jasm.control;

import com.nullpointerworks.ide.jasm.view.gui.swing.ClosableTabHeader;

public class EditorFileController implements EditorListener
{

	private ClosableTabHeader link;
	
	@Override
	public void onTabHeaderLink(ClosableTabHeader link) 
	{
		this.link = link;
	}
	
	@Override
	public void onTabOpening() 
	{
		System.out.println("tab opened: "+link.getTitle());
	}
	
	@Override
	public void onTabClosing() 
	{
		System.out.println("tab closed: "+link.getTitle());
	}

	@Override
	public void onModification() 
	{
		System.out.println("editor modification");
		link.setPreTitle("*");
	}

	@Override
	public void onSaveAction() 
	{
		
	}
	
	
	
	
}

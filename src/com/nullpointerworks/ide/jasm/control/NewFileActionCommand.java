package com.nullpointerworks.ide.jasm.control;

import javax.swing.JTabbedPane;

import com.nullpointerworks.ide.jasm.model.FileHandler;
import com.nullpointerworks.ide.jasm.model.FileHandlerPool;
import com.nullpointerworks.ide.jasm.util.PathBuilder;
import com.nullpointerworks.ide.jasm.view.AssemblerView;
import com.nullpointerworks.ide.jasm.view.gui.swing.ClosableTabHeader;
import com.nullpointerworks.ide.jasm.view.gui.swing.EditorListener;

public class NewFileActionCommand implements ActionCommand, EditorListener
{
	private AssemblerView view;
	private FileHandlerPool mHandlerPool;
	
	public NewFileActionCommand(AssemblerView v, FileHandlerPool mfhp)
	{
		view = v;
		mHandlerPool = mfhp;
	}
	
	@Override
	public void execute() 
	{
		
		
		
		FileHandler fh = mHandlerPool.getNewFileHandler("src/com/nullpointerworks/ide/examples/");
		
		view.createNewSourceFile(fh.getFileName(), this);
		
		
		
		
		
	}
	
	@Override
	public void onTabOpening(JTabbedPane parent, ClosableTabHeader child) 
	{
		
		System.out.println("tab opened: "+child.getTitle());
		
	}
	
	@Override
	public void onTabClosing(JTabbedPane parent, ClosableTabHeader child) 
	{
		
		System.out.println("tab closed: "+child.getTitle());
		
	}

	@Override
	public void onModification() 
	{
		
		System.out.println("editor modification");
		
	}
}

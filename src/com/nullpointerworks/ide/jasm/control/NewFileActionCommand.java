package com.nullpointerworks.ide.jasm.control;

import com.nullpointerworks.ide.jasm.view.AssemblerView;

public class NewFileActionCommand implements ActionCommand
{
	private AssemblerView view;
	
	public NewFileActionCommand(AssemblerView v)
	{
		view = v;
	}
	
	@Override
	public void execute() 
	{
		
		view.createNewSourceFile("src/com/nullpointerworks/ide/examples/");
		
	}

}

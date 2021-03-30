package com.nullpointerworks.ide.jasm;

import java.io.File;

import com.nullpointerworks.ide.jasm.control.ActionCommand;
import com.nullpointerworks.ide.jasm.control.NewFileActionCommand;
import com.nullpointerworks.ide.jasm.control.OpenFileActionCommand;
import com.nullpointerworks.ide.jasm.model.config.Configuration;
import com.nullpointerworks.ide.jasm.view.AssemblerView;
import com.nullpointerworks.ide.jasm.view.gui.swing.UILookAndFeel;

public class MainAssemblerIDE 
{
	public static void main(String[] args) 
	{
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		Configuration configuration;
		AssemblerView asmView = new AssemblerView();
		
		
		ActionCommand acNewButton = new NewFileActionCommand(asmView);
		ActionCommand acOpenButton = new OpenFileActionCommand(asmView);
		
		asmView.setNewButtonAction(acNewButton);
		asmView.setOpenButtonAction(acOpenButton);
		asmView.setVisible(true);
		
		
		
		File f = new File("src/com/nullpointerworks/ide/examples/main.jasm");
		//asmView.openSourceFile(f);
	}
}

package com.nullpointerworks.ide.jasm;

import java.io.File;

import com.nullpointerworks.ide.jasm.control.ActionCommand;
import com.nullpointerworks.ide.jasm.control.OpenActionCommand;
import com.nullpointerworks.ide.jasm.view.AssemblerView;
import com.nullpointerworks.ide.jasm.view.gui.swing.UILookAndFeel;

public class MainAssemblerIDE 
{
	public static void main(String[] args) 
	{
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		AssemblerView asmView = new AssemblerView();
		

		ActionCommand acOpenButton = new OpenActionCommand(asmView);
		
		
		
		asmView.setOpenButtonAction(acOpenButton);
		asmView.setVisible(true);
		
		
		File f = new File("src/com/nullpointerworks/ide/examples/main.jasm");
		asmView.openSourceFile(f);
	}
}

package com.nullpointerworks.ide.jasm;

import com.nullpointerworks.ide.jasm.view.AssemblerView;
import com.nullpointerworks.ide.jasm.view.gui.swing.UILookAndFeel;

public class MainAssemblerIDE 
{
	public static void main(String[] args) 
	{
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		
		
		AssemblerView asmView = new AssemblerView();
		asmView.setVisible(true);
		
		
	}
}

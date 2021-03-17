package com.nullpointerworks.ide.jasm;

import com.nullpointerworks.ide.jasm.gui.AssemblerView;
import com.nullpointerworks.ide.jasm.gui.swing.UILookAndFeel;

public class MainAssemblerIDE 
{
	public static void main(String[] args) 
	{
		UILookAndFeel.setLookAndFeel( UILookAndFeel.WINDOWS );
		
		
		
		AssemblerView asmView = new AssemblerView();
		asmView.setVisible(true);
		
		
	}
}

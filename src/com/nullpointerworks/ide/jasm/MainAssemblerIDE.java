package com.nullpointerworks.ide.jasm;

import java.io.File;

import com.nullpointerworks.ide.jasm.control.ActionCommand;
import com.nullpointerworks.ide.jasm.control.NewFileActionCommand;
import com.nullpointerworks.ide.jasm.control.OpenFileActionCommand;
import com.nullpointerworks.ide.jasm.model.FileHandlerPool;
import com.nullpointerworks.ide.jasm.model.config.Configuration;
import com.nullpointerworks.ide.jasm.model.config.xml.XMLConfiguration;
import com.nullpointerworks.ide.jasm.util.PathBuilder;
import com.nullpointerworks.ide.jasm.view.AssemblerView;
import com.nullpointerworks.ide.jasm.view.gui.swing.UILookAndFeel;
import com.nullpointerworks.util.FileUtil;

public class MainAssemblerIDE 
{
	public static void main(String[] args) 
	{
		UILookAndFeel.setLookAndFeel( UILookAndFeel.NIMBUS );
		PathBuilder mPath = new PathBuilder(FileUtil.getSourceCodePath(MainAssemblerIDE.class));
		
		Configuration mConfiguration = new XMLConfiguration(mPath);
		FileHandlerPool mHandlerPool = new FileHandlerPool();
		AssemblerView vASMView = new AssemblerView();
		
		ActionCommand cNewButton = new NewFileActionCommand(vASMView, mHandlerPool);
		ActionCommand cOpenButton = new OpenFileActionCommand(vASMView, mHandlerPool);
		
		
		
		vASMView.setNewFileButtonAction(cNewButton);
		vASMView.setOpenButtonAction(cOpenButton);
		vASMView.setVisible(true);
		
		//File f = new File("src/com/nullpointerworks/ide/examples/main.jasm");
		//asmView.openSourceFile(f);
	}
}

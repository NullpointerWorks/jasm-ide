package com.nullpointerworks.ide.jasm.control;

import com.nullpointerworks.ide.jasm.model.FileHandler;
import com.nullpointerworks.ide.jasm.model.FileHandlerPool;
import com.nullpointerworks.ide.jasm.util.PathBuilder;
import com.nullpointerworks.ide.jasm.view.AssemblerView;

public class NewFileActionCommand implements ActionCommand
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
		
		FileHandler mHandler = mHandlerPool.getNewFileHandler("src/com/nullpointerworks/ide/examples/");
		
		EditorFileController cEditorListener = new EditorFileController();
		
		view.createNewSourceFile(mHandler.getFileName(), cEditorListener);
		
	}
	
	
}

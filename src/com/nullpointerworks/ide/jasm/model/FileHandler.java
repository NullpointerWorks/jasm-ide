package com.nullpointerworks.ide.jasm.model;

import com.nullpointerworks.ide.jasm.util.PathBuilder;

/*
 * source file container
 */
public class FileHandler
{
	private boolean isSaved;
	private PathBuilder path;
	private String fileName;
	
	public FileHandler()
	{
		isSaved = false;
		fileName = "";
	}
	
	public void setFilePath(PathBuilder pb)
	{
		path = pb.copy();
		fileName = path.fileName();
	}
	
	public String getFileName()
	{
		return fileName;
	}
	
	public boolean isSaved()
	{
		return isSaved;
	}
	
	
	
	
	
	
	
	
	
}

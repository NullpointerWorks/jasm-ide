package com.nullpointerworks.ide.jasm.model;

import com.nullpointerworks.ide.jasm.util.PathBuilder;

/*
 * source file container
 */
public class FileContainer
{
	private PathBuilder path;
	private String fileName = "";
	
	public FileContainer()
	{
		
	}
	
	public void setFileName(String fn)
	{
		fileName = fn;
	}
	
	
	
}

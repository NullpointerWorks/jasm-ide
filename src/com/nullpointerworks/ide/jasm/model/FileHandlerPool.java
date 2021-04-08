package com.nullpointerworks.ide.jasm.model;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.ide.jasm.util.PathBuilder;

public class FileHandlerPool 
{
	private List<FileHandler> pool;
	
	
	public FileHandlerPool()
	{
		pool = new ArrayList<FileHandler>();
		
		
	}
	
	public FileHandler getNewFileHandler(String sourcePath)
	{
		PathBuilder p = defaultFileName(sourcePath);
		FileHandler fh = new FileHandler();
		fh.setFilePath(p);
		pool.add(fh);
		return fh;
	}
	
	private PathBuilder defaultFileName(String sourcePath) 
	{
		boolean found = false;
		String newFileName = "new_1.jasm";
		int it = 1;
		while (!found)
		{
			newFileName = "new_"+it+".jasm";
			it++;
			found = true;
			for (FileHandler handle : pool)
			{
				if (handle.getFileName().equalsIgnoreCase(newFileName))
				{
					found = false;
					break;
				}
			}
		}
		PathBuilder path = new PathBuilder(sourcePath);
		path.fileName(newFileName);
		return path;
	}
}

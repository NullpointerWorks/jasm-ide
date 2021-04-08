package com.nullpointerworks.ide.jasm.model.config.xml;

import exp.nullpointerworks.xml.Element;

public class RecentlyOpenedConfig implements ConfigItem
{
	public RecentlyOpenedConfig()
	{
		
	}
	
	public String name()
	{
		return "RecentlyOpened";
	}
	
	@Override
	public Element make() 
	{
		return new Element("RecentlyOpened");
	}
	
	@Override
	public void verify(Element root) 
	{
		Element base = root.getChild("RecentlyOpened");
		if (base == null) 
		{
			root.addChild( make() );
		}
		else 
		{
			
			
		}
	}
}

package com.nullpointerworks.ide.jasm.model.config.xml;

import exp.nullpointerworks.xml.Element;

public interface ConfigItem 
{
	String name();
	Element make();
	void verify(Element root);
}

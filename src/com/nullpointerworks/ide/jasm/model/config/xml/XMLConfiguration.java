package com.nullpointerworks.ide.jasm.model.config.xml;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.ide.jasm.model.config.Configuration;
import com.nullpointerworks.ide.jasm.util.PathBuilder;
import com.nullpointerworks.ide.jasm.util.XMLLoader;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;
import exp.nullpointerworks.xml.Encoding;
import exp.nullpointerworks.xml.Version;
import exp.nullpointerworks.xml.prolog.XMLProlog;

/*
 * XML configuration singleton
 */
public class XMLConfiguration extends XMLLoader implements Configuration
{
	private List<ConfigItem> items;
	private Document doc = null;
	private Element root = null;
	
	public XMLConfiguration(PathBuilder app_url)
	{
		items = new ArrayList<ConfigItem>();
		items.add( new RecentlyOpenedConfig() );
		
		PathBuilder cnf = app_url.copy().fileName("config.xml");
		if (!existsXML(cnf))
		{
			doc = makeDefault(cnf);
		}
		else
		{
			doc = verifyFile(cnf);
		}
		root = doc.getRootElement();
	}
	
	// ===================================================================
	
	
	
	
	
	
	
	// ===================================================================
	
	private Document makeDefault(PathBuilder cnf)
	{
		Element root = makeDefaultRoot(cnf.folderPath());
		Document doc = new Document();
		doc.setProlog( new XMLProlog(Version.V10, Encoding.UTF8) );
		doc.setRootElement(root);
		saveXML(doc,cnf);
		return doc;
	}
	
	private Element makeDefaultRoot(String path)
	{
		Element root = new Element("Configuration");
		for (ConfigItem item : items)
		{
			root.addChild( item.make() );
		}
		return root;
	}
	
	// ===================================================================
	
	private Document verifyFile(PathBuilder cnf)
	{
		doc = loadXML(cnf);
		root = doc.getRootElement();
		
		if (root == null)
		{
			Element root = makeDefaultRoot(cnf.folderPath());
			doc.setProlog( new XMLProlog(Version.V10, Encoding.UTF8) );
			doc.setRootElement(root);
		}
		else
		{
			for (ConfigItem item : items)
			{
				item.verify(root);
			}
		}
		
		saveXML(doc,cnf);
		return doc;
	}
}

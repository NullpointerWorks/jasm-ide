package com.nullpointerworks.ide.jasm.model.config.xml;

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
	private static XMLConfiguration inst = new XMLConfiguration();
	public static XMLConfiguration getInstance() {return inst;}
	private XMLConfiguration() {}
	
	private Document doc = null;
	private Element root = null;
	
	public Configuration load(PathBuilder app_url)
	{
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
		
		return this;
	}
	
	// ===================================================================
	
	public String getWatchDirectory() 
	{
		Element scanroot = root.getChild("ScanRoot");
		return scanroot.getText();
	}
	
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
		//root.addChild( new Element("ScanRoot").setText( path+"scan/" ) );
		return root;
	}
	
	private Document verifyFile(PathBuilder cnf)
	{
		doc = loadXML(cnf);
		root = doc.getRootElement();
		
		/*
		 * create default if root is missing
		 */
		if (root == null)
		{
			Element root = makeDefaultRoot(cnf.folderPath());
			doc.setProlog( new XMLProlog(Version.V10, Encoding.UTF8) );
			doc.setRootElement(root);
		}
		else
		/*
		 * check current config value for validity
		 */
		{
			//checkPathData(root, "ScanRoot", "scan/");
		}
		
		saveXML(doc,cnf);
		return doc;
	}
	
	private void checkPathData(Element root, String elName, String defaultString)
	{
		Element scanroot = root.getChild(elName);
		if (scanroot==null) 
		{
			root.addChild( new Element(elName).setText(defaultString) );
		}
		else 
		{
			String txt = scanroot.getText();
			txt=txt.replace("\\", "/");
			if (!txt.endsWith("/"))
			{
				scanroot.setText(txt+"/");
			}
		}
	}
}

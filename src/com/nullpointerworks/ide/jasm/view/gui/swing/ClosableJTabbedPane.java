package com.nullpointerworks.ide.jasm.view.gui.swing;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JTabbedPane;

public class ClosableJTabbedPane extends JTabbedPane
{
	private static final long serialVersionUID = -8498443122815430449L;
	
	private List<Component> tracking;
	
	public ClosableJTabbedPane()
	{
		super();
		tracking = new ArrayList<Component>();
	}
	
	public ClosableTabHeader addClosableTab(String title, Icon icon, Component comp)
	{
		add(comp);
		int index = indexOfComponent(comp);
		if (index < 0) return null;
		
		ClosableTabHeader panel = getClosablePanel(this, icon, comp, title );
		setTabComponentAt( index, panel );
		return panel;
	}
	
	@Override
	public void addTab(String title, Icon icon, Component comp)
	{
		addClosableTab(title, icon, comp);
	}
	
	@Override
	public Component add(Component comp)
	{
		return add(comp.getName(), comp);
	}
	
	@Override
	public Component add(String title, Component comp)
	{
		if (tracking.contains(comp)) return comp;
		tracking.add(comp);
		super.add(title, comp);
		
		int index = indexOfComponent(comp);
		if (index < 0) return comp;
		ClosableTabHeader panel = getClosablePanel(this, null, comp, title );
		setTabComponentAt( index, panel );
		
		return comp;
	}
	
	private ClosableTabHeader getClosablePanel(ClosableJTabbedPane parent, Icon icon, final Component comp, String title) 
	{
		return new ClosableTabHeader(parent, title, comp, icon);
	}
	
	public void removeComponent(final Component comp)
	{
		remove(comp);
		tracking.remove(comp);
	}
}

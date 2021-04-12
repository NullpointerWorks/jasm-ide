package com.nullpointerworks.ide.jasm.view.gui.swing;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ClosableJTabbedPane extends JTabbedPane
{
	private static final long serialVersionUID = -8498443122815430449L;
	
	private List<EditorListener> listeners;
	private List<Component> tracking;
	
	public ClosableJTabbedPane()
	{
		super();
		listeners = new ArrayList<EditorListener>();
		tracking = new ArrayList<Component>();
	}
	
	public void addEditorListener(EditorListener ctl)
	{
		if (!listeners.contains(ctl)) listeners.add(ctl);
	}
	
	public void removeEditorListener(EditorListener ctl)
	{
		if (listeners.contains(ctl)) listeners.remove(ctl);
	}
	
	public void addTab(JLabel title, Icon icon, Component comp)
	{
		add(comp);
		int index = indexOfComponent(comp);
		if (index < 0) return;
		
		JPanel panel = getClosablePanel(this, icon, comp, title);
		setTabComponentAt( index, panel );
	}
	
	@Override
	public void addTab(String title, Icon icon, Component comp)
	{
		addTab(new JLabel(title), icon, comp);
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
		JPanel panel = getClosablePanel(this, null, comp, new JLabel(title) );
		setTabComponentAt( index, panel );
		
		for (EditorListener ctl : listeners)
		{
			ctl.onTabOpening(this, panel);
		}
		
		return comp;
	}
	
	private JPanel getClosablePanel(ClosableJTabbedPane parent, Icon icon, final Component comp, JLabel title) 
	{
		ClosableJPanel panel  = new ClosableJPanel(parent, title, comp, icon);
		for (EditorListener ctl : listeners)
		{
			panel.addEditorListener(ctl);
		}
		return panel;
	}
	
	public void removeComponent(final Component comp)
	{
		remove(comp);
		tracking.remove(comp);
	}
}

package com.nullpointerworks.ide.jasm.view.gui.swing;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nullpointerworks.ide.jasm.Resources;

public class ClosableJTabbedPane extends JTabbedPane
{
	private static final long serialVersionUID = -8498443122815430449L;
	
	private List<ClosableTabListener> listeners;
	private List<Component> tracking;
	
	public ClosableJTabbedPane()
	{
		super();
		listeners = new ArrayList<ClosableTabListener>();
		tracking = new ArrayList<Component>();
	}
	
	public void addClosableTabListener(ClosableTabListener ctl)
	{
		listeners.add(ctl);
	}
	
	public void removeClosableTabListener(ClosableTabListener ctl)
	{
		listeners.remove(ctl);
	}
	
	@Override
	public Component add(Component comp)
	{
		return add(comp.getName(), comp);
	}

	@Override
	public void addTab(String title, Icon icon, Component comp)
	{
		if (tracking.contains(comp)) return;
		tracking.add(comp);
		super.addTab(title, icon, comp);
		
		int index = indexOfComponent(comp);
		if (index < 0) return;
		
		JPanel panel = getClosablePanel(this, icon, comp, title);
		setTabComponentAt( index, panel );
		
		for (ClosableTabListener ctl : listeners)
		{
			ctl.onTabOpening(this, panel);
		}
	}
	
	@Override
	public Component add(String title, Component comp)
	{
		if (tracking.contains(comp)) return comp;
		tracking.add(comp);
		super.add(title, comp);
		
		int index = indexOfComponent(comp);
		if (index < 0) return comp;
		JPanel panel = getClosablePanel(this, null, comp, title);
		setTabComponentAt( index, panel );
		
		for (ClosableTabListener ctl : listeners)
		{
			ctl.onTabOpening(this, panel);
		}
		
		return comp;
	}
	
	/*
	 * code to create a close-button for tabs
	 */
	private final ImageIcon[] closeIcons = 
	{
		Resources.getTabCloseIdleIcon(),
		Resources.getTabCloseActiveIcon()
	};
	private final int IDLE = 0;
	private final int ACTIVE = 1;
	
	private JPanel getClosablePanel(JTabbedPane parent, Icon icon, final Component comp, String title) 
	{
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		titlePanel.setOpaque(false);
		
		JLabel titleLbl = new JLabel(" "+title+" ");
		titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
		
		JButton closeButton = new JButton();
		closeButton.setSize(10, 16);
		closeButton.setPreferredSize(closeButton.getSize());
		closeButton.setIcon( closeIcons[IDLE] );
		closeButton.setOpaque(false);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				for (ClosableTabListener ctl : listeners)
				{
					ctl.onTabClosing(parent, titlePanel);
				}
				parent.remove(comp);
				tracking.remove(comp);
			}
		});
		closeButton.getModel().addChangeListener(new ChangeListener() 
		{
	        @Override
	        public void stateChanged(ChangeEvent e) 
	        {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover())
	            {
	            	closeButton.setIcon( closeIcons[ACTIVE] );
	            }
	            else
	            {
	            	closeButton.setIcon( closeIcons[IDLE] );
	            }
	         }
	    });
		
		if (icon!=null)titlePanel.add(new JLabel(icon));
		titlePanel.add(titleLbl);
		titlePanel.add(closeButton);
		return titlePanel;
	}
}

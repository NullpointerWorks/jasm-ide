package com.nullpointerworks.ide.jasm.view.swing;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.nullpointerworks.ide.jasm.Resources;
import com.nullpointerworks.ide.jasm.control.EditorListener;

public class ClosableTabHeader extends JPanel
{
	private static final long serialVersionUID = -73302653717502663L;
	
	private final ImageIcon[] closeIcons = 
	{
		Resources.getTabCloseIdleIcon(),
		Resources.getTabCloseActiveIcon()
	};
	private final int IDLE = 0;
	private final int ACTIVE = 1;
	private List<EditorListener> listeners;
	private JLabel pretitle;
	private JLabel title;
	
	public ClosableTabHeader(ClosableJTabbedPane parent, String name, final Component comp, Icon icon)
	{
		listeners = new ArrayList<EditorListener>();
		
		pretitle = new JLabel("");
		title = new JLabel(" "+name+" ");
		title.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 4));
		
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setOpaque(false);
		
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
				for (EditorListener ctl : listeners)
				{
					ctl.onTabClosing();
				}
				parent.removeComponent(comp);
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
		
		if (icon!=null)add(new JLabel(icon));
		add(pretitle);
		add(title);
		add(closeButton);
	}
	
	public void addEditorListener(EditorListener ctl)
	{
		if (!listeners.contains(ctl)) listeners.add(ctl);
	}
	
	public void removeEditorListener(EditorListener ctl)
	{
		if (listeners.contains(ctl)) listeners.remove(ctl);
	}
	
	public void setPreTitle(String txt)
	{
		pretitle.setText(txt);
		this.repaint();
	}
	
	public void setTitle(String txt)
	{
		title.setText(txt);
		this.repaint();
	}
	
	public String getTitle()
	{
		return title.getText();
	}
	
	
	
}

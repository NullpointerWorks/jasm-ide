package com.nullpointerworks.ide.jasm.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ActionCommand extends ActionListener, Command
{
	@Override
	public default void actionPerformed(ActionEvent e)
	{
		onCommand();
	}
}

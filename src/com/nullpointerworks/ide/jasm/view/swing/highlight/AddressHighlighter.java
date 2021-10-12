package com.nullpointerworks.ide.jasm.view.swing.highlight;

import java.awt.Color;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;

public class AddressHighlighter implements HighlightValidator 
{
	private final Color REGISTER = new Color(255, 150, 0);
	
	@Override
	public boolean isValid(String token) 
	{
		if (token.startsWith("&")) return true;
		return false;
	}

	@Override
	public void setHighlight(MutableAttributeSet asNew) 
	{
		StyleConstants.setForeground(asNew, REGISTER);
	}
}

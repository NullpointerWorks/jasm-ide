package com.nullpointerworks.ide.jasm.view.swing;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

import com.nullpointerworks.ide.jasm.control.EditorListener;
import com.nullpointerworks.ide.jasm.view.swing.highlight.*;

public class CodeJScrollPane extends JScrollPane
{
	private static final long serialVersionUID = 1L;

	private List<EditorListener> listeners;
	private JTextArea lines;
	private HighlightingJTextPane jtp;
	
	public CodeJScrollPane()
	{
		Font font = new Font("Lucida Console", Font.PLAIN, 12);
		listeners = new ArrayList<EditorListener>();
		
		lines = new JTextArea(" 1 ");
		lines.setBackground(Color.LIGHT_GRAY);
		lines.setEditable(false);
		lines.setFont(font);
		lines.setCaret( new NoSelectCaret(lines) );
		lines.setBorder(null);
		
		jtp = new HighlightingJTextPane();
		jtp.setFont(font);
		jtp.addHighlightValidator( new DeclarationHighlighter() );
		jtp.addHighlightValidator( new InstructionHighlighter() );
		jtp.addHighlightValidator( new RegisterHighlighter() );
		jtp.addHighlightValidator( new NumberHighlighter() );
		jtp.addHighlightValidator( new AddressHighlighter() );
		jtp.addHighlightValidator( new DefaultHighlighter() );
		addDocumentListener(new DocumentListener()
		{
			private String getText()
			{
				int caretPosition = jtp.getDocument().getLength();
				Element root = jtp.getDocument().getDefaultRootElement();
				String text = " 1 " + System.getProperty("line.separator");
				for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++)
				{
					text += (" " + i + " " + System.getProperty("line.separator"));
				}
				return text;
			}
			
			@Override
			public void changedUpdate(DocumentEvent de) 
			{
				onModification();
				setLineText(getText());
			}
			
			@Override
			public void insertUpdate(DocumentEvent de) 
			{
				onModification();
				setLineText(getText());
			}
			
			@Override
			public void removeUpdate(DocumentEvent de) 
			{
				onModification();
				setLineText(getText());
			}
		});
		
		setViewportView(jtp);
		setRowHeaderView(lines);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	private void onModification()
	{
		for (EditorListener ctl : listeners) 
		{
			ctl.onModification();
		}
	}

	public void addEditorListener(EditorListener ctl) 
	{
		if (!listeners.contains(ctl)) listeners.add(ctl);
	}
	
	private void addDocumentListener(DocumentListener dl)
	{
		jtp.getDocument().addDocumentListener(dl);
	}
	
	public void append(String str) 
	{
		jtp.append(str);
	}
	
	public void appendLine(String str) 
	{
		jtp.appendLine(str);
	}
	
	private void setLineText(String text)
	{
		lines.setText(text);
	}
}

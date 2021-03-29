package com.nullpointerworks.ide.jasm.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.nullpointerworks.ide.jasm.Resources;
import com.nullpointerworks.ide.jasm.view.gui.awt.AbsoluteLayout;
import com.nullpointerworks.ide.jasm.view.gui.swing.CodeJScrollPane;
import com.nullpointerworks.ide.jasm.view.gui.swing.JTextAreaScrollPane;

public class AssemblerView
{
	private JFrame jfWindow;
	private JPanel jpInterface;
	private JToolBar jtbToolRibbon;
	private JTabbedPane jtpSourceTabs;
	private JTabbedPane jtpBottomTabs;
	
	private CodeJScrollPane cjspCode;

	private JButton jbNewFile;
	private JButton jbOpenFile;
	private JButton jbSaveFile;
	private JButton jbSaveAll;
	private JButton jbAssemble;
	private JButton jbRunVM;
	private JButton jbBuildNRun;
	
	private JTextArea jtaConsoleOut;
	
	
	
	
	public AssemblerView()
	{
		/*
		 * tool ribbon
		 */
		jbNewFile = new JButton(Resources.getNewIcon() );
		jbNewFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbNewFile.setHorizontalTextPosition(AbstractButton.CENTER);
		jbNewFile.setToolTipText("Create something new.");
		jbNewFile.setLocation(0, 0);
		jbNewFile.setSize(32, 32);
		jbNewFile.setPreferredSize(jbNewFile.getSize());
		
		jbOpenFile = new JButton(Resources.getOpenIcon() );
		jbOpenFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbOpenFile.setHorizontalTextPosition(AbstractButton.CENTER);
		jbOpenFile.setToolTipText("Open an existing source file.");
		jbOpenFile.setLocation(32, 0);
		jbOpenFile.setSize(32, 32);
		jbOpenFile.setPreferredSize(jbOpenFile.getSize());
		
		jbSaveFile = new JButton(Resources.getSaveIcon() );
		jbSaveFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbSaveFile.setHorizontalTextPosition(AbstractButton.CENTER);
		jbSaveFile.setToolTipText("Save the currently editing file.");
		jbSaveFile.setLocation(64, 0);
		jbSaveFile.setSize(32, 32);
		jbSaveFile.setPreferredSize(jbSaveFile.getSize());
		
		jbSaveAll = new JButton(Resources.getSaveAllIcon() );
		jbSaveAll.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbSaveAll.setHorizontalTextPosition(AbstractButton.CENTER);
		jbSaveAll.setToolTipText("Save all edited files.");
		jbSaveAll.setLocation(96, 0);
		jbSaveAll.setSize(32, 32);
		jbSaveAll.setPreferredSize(jbSaveAll.getSize());
		
		jbAssemble = new JButton(Resources.getAssembleIcon() );
		jbAssemble.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbAssemble.setHorizontalTextPosition(AbstractButton.CENTER);
		jbAssemble.setToolTipText("Assemble the current project.");
		jbAssemble.setLocation(128, 0);
		jbAssemble.setSize(32, 32);
		jbAssemble.setPreferredSize(jbAssemble.getSize());
		
		jbRunVM = new JButton(Resources.getRunIcon() );
		jbRunVM.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbRunVM.setHorizontalTextPosition(AbstractButton.CENTER);
		jbRunVM.setToolTipText("Run the previous build for this program.");
		jbRunVM.setLocation(160, 0);
		jbRunVM.setSize(32, 32);
		jbRunVM.setPreferredSize(jbRunVM.getSize());
		
		jbBuildNRun = new JButton(Resources.getBuildAndRunIcon() );
		jbBuildNRun.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbBuildNRun.setHorizontalTextPosition(AbstractButton.CENTER);
		jbBuildNRun.setToolTipText("Build and run the program.");
		jbBuildNRun.setLocation(192, 0);
		jbBuildNRun.setSize(32, 32);
		jbBuildNRun.setPreferredSize(jbBuildNRun.getSize());
		
		jtbToolRibbon = new JToolBar();
		jtbToolRibbon.add(jbNewFile);
		jtbToolRibbon.add(jbOpenFile);
		jtbToolRibbon.add(jbSaveFile);
		jtbToolRibbon.add(jbSaveAll);
		jtbToolRibbon.addSeparator();
		jtbToolRibbon.add(jbAssemble);
		jtbToolRibbon.add(jbRunVM);
		jtbToolRibbon.add(jbBuildNRun);
		
		/*
		 * construct upper tab pane
		 */
		jtpSourceTabs = new JTabbedPane();  
		jtpSourceTabs.setSize(800,350);
		jtpSourceTabs.setPreferredSize(jtpSourceTabs.getSize());
		
		/*
		 * construct lower tab pane
		 */
		JTextAreaScrollPane jtaScrolling = new JTextAreaScrollPane();
		jtaScrolling.setLocation(0, 0);
		jtaScrolling.setSize(800, 200);
		jtaConsoleOut = jtaScrolling.getJTextArea();
		
	    jtpBottomTabs = new JTabbedPane();
	    jtpBottomTabs.add("Console", jtaScrolling);
		
	    /*
	     * construct window
	     */
	    JSplitPane jspSplitScreen = new JSplitPane(SwingConstants.HORIZONTAL);
	    jspSplitScreen.setLocation(0, 64);
		jspSplitScreen.setSize(800, 536);
		jspSplitScreen.add(jtpSourceTabs);
		jspSplitScreen.add(jtpBottomTabs);
		
		jpInterface = new JPanel();
		jpInterface.setLayout(new BorderLayout());
		jpInterface.setLocation(0, 0);
		jpInterface.setSize(800, 600);
		jpInterface.add(jtbToolRibbon, BorderLayout.NORTH);
		jpInterface.add(jspSplitScreen);
		
		jfWindow = new JFrame();
		jfWindow.setTitle("JASM Assembler");
		jfWindow.setLayout( new AbsoluteLayout() );
		jfWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jfWindow.setResizable(false);
		jfWindow.add(jpInterface);
		jfWindow.pack();
		jfWindow.validate();
		jfWindow.setLocationRelativeTo(null);
		
		
		
		
		/*
		cjspCode = new CodeJScrollPane();
		cjspCode.appendLine(".def EXIT 0");
		cjspCode.appendLine(".def PRINT_A 1");
		cjspCode.appendLine("");
		cjspCode.appendLine("  load a,10");
		cjspCode.appendLine("loop:");
		cjspCode.appendLine("  int PRINT_A");
		cjspCode.appendLine("  dec a");
		cjspCode.appendLine("  jne loop");
		cjspCode.append("  int EXIT");
		jtpSourceTabs.add("main.jasm", cjspCode);
		//*/
	}
	
	public void setVisible(boolean b)
	{
		jfWindow.setVisible(b);
	}
	
	public void setOpenButtonAction(ActionListener al)
	{
		jbOpenFile.addActionListener(al);
	}
	
}

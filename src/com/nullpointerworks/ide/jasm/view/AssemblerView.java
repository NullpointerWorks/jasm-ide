package com.nullpointerworks.ide.jasm.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.nullpointerworks.ide.jasm.Resources;
import com.nullpointerworks.ide.jasm.control.EditorListener;
import com.nullpointerworks.ide.jasm.view.awt.AbsoluteLayout;
import com.nullpointerworks.ide.jasm.view.swing.ClosableJTabbedPane;
import com.nullpointerworks.ide.jasm.view.swing.ClosableTabHeader;
import com.nullpointerworks.ide.jasm.view.swing.CodeJScrollPane;
import com.nullpointerworks.ide.jasm.view.swing.JTextAreaScrollPane;

public class AssemblerView
{
	private JFrame jfWindow;
	private JPanel jpInterface;
	private ClosableJTabbedPane jtpSourceTabs;
	private JTabbedPane jtpBottomTabs;
	private JTextArea jtaConsoleOut;
	
	private JMenuBar jmbMenuBar;
	private JMenuItem jmiNewFile;
	private JMenuItem jmiNewProj;
	private JMenuItem jmiOpenFile;
	private JMenuItem jmiSave;
	private JMenuItem jmiSaveAs;
	private JMenuItem jmiSaveAll;
	private JMenuItem jmiExit;
	private JMenuItem jmiClearHistory;
	
	private JToolBar jtbToolRibbon;
	private JButton jbNewFile;
	private JButton jbOpenFile;
	private JButton jbSaveFile;
	private JButton jbSaveAll;
	private JButton jbConfigAll;
	private JButton jbAssemble;
	private JButton jbRunVM;
	private JButton jbBuildNRun;
	
	public AssemblerView()
	{
		/*
		 * menu bar
		 */
		jmiNewProj = new JMenuItem("Project", Resources.getNewProjectIcon() );
		jmiNewFile = new JMenuItem("File", Resources.getNewIcon() );
		jmiOpenFile = new JMenuItem("Open", Resources.getOpenIcon() );
		jmiSave = new JMenuItem("Save", Resources.getSaveIcon() );
		jmiSaveAs = new JMenuItem("Save As...", Resources.getSaveAsIcon() );
		jmiSaveAll = new JMenuItem("Save All", Resources.getSaveAllIcon() );
		jmiExit = new JMenuItem("Exit" );
		jmiClearHistory = new JMenuItem("Clear History" );
		
		JMenu jmNew = new JMenu("New");
		jmNew.setLocation(5, 0);
		jmNew.add(jmiNewProj);
		jmNew.addSeparator();
		jmNew.add(jmiNewFile);
		
		JMenu jmRecent = new JMenu("Recent");
		jmRecent.addSeparator();
		jmRecent.add(jmiClearHistory);
		
		JMenu jmProgram = new JMenu("File");
		jmProgram.add(jmNew);
		jmProgram.add(jmiOpenFile);
		jmProgram.add(jmRecent);
		jmProgram.addSeparator();
		jmProgram.add(jmiSave);
		jmProgram.add(jmiSaveAs);
		jmProgram.add(jmiSaveAll);
		jmProgram.addSeparator();
		jmProgram.add(jmiExit);
		
		jmbMenuBar = new JMenuBar();
		jmbMenuBar.add(jmProgram);
		
		/*
		 * tool ribbon
		 */
		jbNewFile = new JButton(Resources.getNewIcon() );
		jbNewFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbNewFile.setHorizontalTextPosition(AbstractButton.CENTER);
		jbNewFile.setToolTipText("Create a new file");
		jbNewFile.setLocation(0, 0);
		jbNewFile.setSize(32, 32);
		jbNewFile.setPreferredSize(jbNewFile.getSize());
		
		jbOpenFile = new JButton(Resources.getOpenIcon() );
		jbOpenFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbOpenFile.setHorizontalTextPosition(AbstractButton.CENTER);
		jbOpenFile.setToolTipText("Open an existing file");
		jbOpenFile.setLocation(32, 0);
		jbOpenFile.setSize(32, 32);
		jbOpenFile.setPreferredSize(jbOpenFile.getSize());
		
		jbSaveFile = new JButton(Resources.getSaveIcon() );
		jbSaveFile.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbSaveFile.setHorizontalTextPosition(AbstractButton.CENTER);
		jbSaveFile.setToolTipText("Save the current file");
		jbSaveFile.setLocation(64, 0);
		jbSaveFile.setSize(32, 32);
		jbSaveFile.setPreferredSize(jbSaveFile.getSize());
		
		jbSaveAll = new JButton(Resources.getSaveAllIcon() );
		jbSaveAll.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbSaveAll.setHorizontalTextPosition(AbstractButton.CENTER);
		jbSaveAll.setToolTipText("Save all files");
		jbSaveAll.setLocation(96, 0);
		jbSaveAll.setSize(32, 32);
		jbSaveAll.setPreferredSize(jbSaveAll.getSize());
		
		jbConfigAll = new JButton(Resources.getConfigIcon() );
		jbConfigAll.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbConfigAll.setHorizontalTextPosition(AbstractButton.CENTER);
		jbConfigAll.setToolTipText("Open configuration");
		jbConfigAll.setLocation(128, 0);
		jbConfigAll.setSize(32, 32);
		jbConfigAll.setPreferredSize(jbConfigAll.getSize());
		
		jbAssemble = new JButton(Resources.getAssembleIcon() );
		jbAssemble.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbAssemble.setHorizontalTextPosition(AbstractButton.CENTER);
		jbAssemble.setToolTipText("Assemble");
		jbAssemble.setLocation(160, 0);
		jbAssemble.setSize(32, 32);
		jbAssemble.setPreferredSize(jbAssemble.getSize());
		
		jbRunVM = new JButton(Resources.getRunIcon() );
		jbRunVM.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbRunVM.setHorizontalTextPosition(AbstractButton.CENTER);
		jbRunVM.setToolTipText("Run lastest build");
		jbRunVM.setLocation(192, 0);
		jbRunVM.setSize(32, 32);
		jbRunVM.setPreferredSize(jbRunVM.getSize());
		
		jbBuildNRun = new JButton(Resources.getBuildAndRunIcon() );
		jbBuildNRun.setVerticalTextPosition(AbstractButton.BOTTOM);
		jbBuildNRun.setHorizontalTextPosition(AbstractButton.CENTER);
		jbBuildNRun.setToolTipText("Assemble and run build");
		jbBuildNRun.setLocation(224, 0);
		jbBuildNRun.setSize(32, 32);
		jbBuildNRun.setPreferredSize(jbBuildNRun.getSize());
		
		jtbToolRibbon = new JToolBar();
		jtbToolRibbon.add(jbNewFile);
		jtbToolRibbon.add(jbOpenFile);
		jtbToolRibbon.add(jbSaveFile);
		jtbToolRibbon.add(jbSaveAll);
		jtbToolRibbon.addSeparator();
		jtbToolRibbon.add(jbConfigAll);
		jtbToolRibbon.addSeparator();
		jtbToolRibbon.add(jbAssemble);
		jtbToolRibbon.add(jbRunVM);
		jtbToolRibbon.add(jbBuildNRun);
		
		/*
		 * construct upper tab pane
		 */
		jtpSourceTabs = new ClosableJTabbedPane();  
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
		jfWindow.setTitle("JASM Assembler IDE");
		jfWindow.setLayout( new AbsoluteLayout() );
		jfWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		jfWindow.setResizable(false);
		jfWindow.setJMenuBar(jmbMenuBar);
		jfWindow.add(jpInterface);
		jfWindow.pack();
		jfWindow.validate();
		jfWindow.setLocationRelativeTo(null);
	}
	
	public void createNewSourceFile(String filename, EditorListener ctl)
	{
		CodeJScrollPane cjspCode = new CodeJScrollPane();
		ClosableTabHeader tab = jtpSourceTabs.addClosableTab(filename, Resources.getASMFileIcon(), cjspCode);
		
		cjspCode.addEditorListener(ctl); // listen to text modification
		tab.addEditorListener(ctl); // listen to the tab opening or closing
		
		
		
		
		
		ctl.onTabHeaderLink(tab); // pass a reference of the tab
		ctl.onTabOpening(); // trigger a "tab open" event
	}
	
	public void openSourceFile(File f)
	{
		/*
		CodeJScrollPane cjspCode = new CodeJScrollPane();
		cjspCode.appendLine(".def EXIT 0");
		cjspCode.appendLine(".def PRINT_A 1");
		cjspCode.appendLine("");
		cjspCode.appendLine("  load a,10");
		cjspCode.appendLine("loop:");
		cjspCode.appendLine("  int PRINT_A");
		cjspCode.appendLine("  dec a");
		cjspCode.appendLine("  jne loop");
		cjspCode.append("  int EXIT");
		jtpSourceTabs.addTab("main.jasm", Resources.getASMFileIcon(), cjspCode);
		//*/
	}
	
	public void printToConsole(String str)
	{
		jtaConsoleOut.append(str+"\n");
	}
	
	public void setVisible(boolean b)
	{
		jfWindow.setVisible(b);
	}
	
	public void setNewFileButtonAction(ActionListener al)
	{
		jbNewFile.addActionListener(al);
		jmiNewFile.addActionListener(al);
	}
	
	public void setOpenButtonAction(ActionListener al)
	{
		jbOpenFile.addActionListener(al);
		jmiOpenFile.addActionListener(al);
	}
}

package com.nullpointerworks.ide.jasm;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class Resources 
{
	private static String[] iconsURL = 
	{
		"/com/nullpointerworks/ide/resources/IP.png", // instruction pointer arrow
		"/com/nullpointerworks/ide/resources/SP.png", // stack pointer arrow
		"/com/nullpointerworks/ide/resources/IPSP.png" ,// IP and SP combination
		"/com/nullpointerworks/ide/resources/btn_NEW.png",
		"/com/nullpointerworks/ide/resources/btn_OPEN.png",
		"/com/nullpointerworks/ide/resources/btn_SAVE.png",
		"/com/nullpointerworks/ide/resources/btn_SAVEALL.png",
		"/com/nullpointerworks/ide/resources/btn_ASM.png",
		"/com/nullpointerworks/ide/resources/btn_RUN2.png",
		"/com/nullpointerworks/ide/resources/btn_DROP.png",
		"/com/nullpointerworks/ide/resources/btn_ASM_RUN2.png",
		"/com/nullpointerworks/ide/resources/tab_CloseActive.png",
		"/com/nullpointerworks/ide/resources/tab_CloseIdle.png",
		"/com/nullpointerworks/ide/resources/file_ASM.png",
		"/com/nullpointerworks/ide/resources/btn_CNFG.png",
		"/com/nullpointerworks/ide/resources/btn_NEW_PROJ.png"
	};
	
	public static ImageIcon getStreamedIcon(String path) 
	{
		InputStream is = Loader.getResourceAsStream(path);
        BufferedImage img = null;
		try 
		{
			img = ImageIO.read(is);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (img==null) return null;
		return new ImageIcon(img);
	}
	
	public static ImageIcon getIPIcon()
	{return getStreamedIcon(iconsURL[0]);}
	
	public static ImageIcon getSPIcon()
	{return getStreamedIcon(iconsURL[1]);}
	
	public static ImageIcon getIPSPIcon()
	{return getStreamedIcon(iconsURL[2]);}
	
	public static ImageIcon getNewIcon()
	{return getStreamedIcon(iconsURL[3]);}
	
	public static ImageIcon getOpenIcon()
	{return getStreamedIcon(iconsURL[4]);}
	
	public static ImageIcon getSaveIcon()
	{return getStreamedIcon(iconsURL[5]);}
	
	public static ImageIcon getSaveAllIcon()
	{return getStreamedIcon(iconsURL[6]);}
	
	public static ImageIcon getAssembleIcon()
	{return getStreamedIcon(iconsURL[7]);}
	
	public static ImageIcon getRunIcon()
	{return getStreamedIcon(iconsURL[8]);}
	
	public static ImageIcon getDropIcon()
	{return getStreamedIcon(iconsURL[9]);}
	
	public static ImageIcon getBuildAndRunIcon()
	{return getStreamedIcon(iconsURL[10]);}
	
	public static ImageIcon getTabCloseActiveIcon()
	{return getStreamedIcon(iconsURL[11]);}
	
	public static ImageIcon getTabCloseIdleIcon()
	{return getStreamedIcon(iconsURL[12]);}
	
	public static ImageIcon getASMFileIcon()
	{return getStreamedIcon(iconsURL[13]);}
	
	public static ImageIcon getConfigIcon()
	{return getStreamedIcon(iconsURL[14]);}
	
	public static ImageIcon getNewProjectIcon()
	{return getStreamedIcon(iconsURL[15]);}
}

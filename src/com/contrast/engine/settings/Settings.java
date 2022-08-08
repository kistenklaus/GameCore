package com.contrast.engine.settings;

@SuppressWarnings("unused")
public final class Settings {
	//CHANGABLES:
	private static boolean fullscreen = false;
	public static int resolution =320;
	
	//WINDOWFORMAT
	public static final float WindowScale = fullscreen ? 6.125f:3f;
	private static final double WindowFormatNORMAL= 0.5625d;
	private static final double WindowFormatSTECHED = 0.75;
	public static double WindowFormat = WindowFormatSTECHED;
	public static int getHeight(int width,double format){
		return (int)(width*format);
	}
	public static boolean WindowDecoration = !fullscreen;
	
	//FPS CAP:
	public static boolean FPSCAP = false;
	
}

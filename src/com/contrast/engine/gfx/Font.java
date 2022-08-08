package com.contrast.engine.gfx;

public class Font 
{
	public final static Font STANDART = new Font("res/fonts/Comic.png");
	
	private Image fontImage;
	private int[] offsets;
	private int[] width;
	
	public Font(String path)
	{
		fontImage = new Image(path);
		
		offsets = new int[256];
		width = new int[256];
		
		int unicode = 0;
		
		for(int i = 0 ; i<fontImage.getW() ; i++)
		{
			if(fontImage.getP()[i] == 0xff0000ff)
			{
				offsets[unicode] = i;
			}
			if(fontImage.getP()[i] == 0xffffff00)
			{
				width[unicode] = i-offsets[unicode];
				unicode++;
			}
		}
	}

	public Image getFontImage() {
		return fontImage;
	}

	public int[] getOffsets() {
		return offsets;
	}

	public int[] getWidth() {
		return width;
	}
}

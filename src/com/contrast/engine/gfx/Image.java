package com.contrast.engine.gfx;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image 
{
	private int w,h;
	private int[] p;
	private boolean alpha = false;

	
	public Image(String path,int width, int height){
		BufferedImage image = null;
		
		try {
			//image = ImageIO.read(Image.class.getResourceAsStream(path));
			image = ImageIO.read(new File(path));
			
			BufferedImage scaled = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB );
			AffineTransform at = new AffineTransform();
			at.scale((double)width/image.getWidth(), (double)height/image.getHeight());
			AffineTransformOp scaleOp =
					new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
			image= scaleOp.filter(image, scaled);
			BufferedImage newImg = new BufferedImage(width, height, image.getType());
			Graphics newG = newImg.getGraphics();
			newG.drawImage(image, 0, 0, null);
			newG.dispose();
			image = newImg;
			
			} 
		catch (IOException e) {e.printStackTrace();}
		
		
		
		w = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0, 0, w, h, null, 0, w);
		
		image.flush();
	}


	public Image(String path) 
	{
BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(path));}
		catch (IOException e) {e.printStackTrace();}
		
		w = image.getWidth();
		h = image.getHeight();
		p = image.getRGB(0, 0, w, h, null, 0, w);
		
		image.flush();
	}

	public Image(int[] p, int w,int h)
	{
		this.p=p;
		this.w=w;
		this.w=h;
	}
	
	
	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public int[] getP() {
		return p;
	}


	public void setP(int[] p) {
		this.p = p;
	}


	public boolean isAlpha() {
		return alpha;
	}


	public void setAlpha(boolean alpha) {
		this.alpha = alpha;
	}
}

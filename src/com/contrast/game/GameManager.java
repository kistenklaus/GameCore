package com.contrast.game;

import java.awt.event.KeyEvent;

import com.contrast.engine.AbstractGame;
import com.contrast.engine.GameContainer;
import com.contrast.engine.Renderer;
import com.contrast.engine.audio.SoundClip;
import com.contrast.engine.gfx.Image;

public class GameManager extends AbstractGame{
	
	private Image image;
	private SoundClip clip;
	private Image mark;
	
	public GameManager() 
	{
		mark = new Image("res/Tron_Solid_Mark_III.png", 100,100);
		
		image = new Image("res/wood.png",100,100);
		image.setAlpha(true);
		
		clip = new SoundClip("res/audio/baaaa.wav");
		clip.setVolume(-40);
	}
	
	public void update(GameContainer gc, float dt) 
	{
		if(gc.getInput().isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);
		if(gc.getInput().isKeyDown(KeyEvent.VK_SPACE)){
			clip.play();
		}
		
	}

	public void render(GameContainer gc, Renderer r) 
	{
		r.setzDepth(1);
		r.drawImage(image, gc.getInput().getMouseX()-image.getW()/2, gc.getInput().getMouseY()-image.getH()/2);
		r.setzDepth(2);
		r.drawImage(mark, 100, 100);
		r.setzDepth(0);
		r.fillRect(0, 0, 100, 100, 0xff0099ff);	
			
	}
	
	public static void main(String[] args) 
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
	
}

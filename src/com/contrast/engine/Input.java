package com.contrast.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseWheelListener,MouseMotionListener
{
	
	private GameContainer gc;
	
	private final int NUM_KEYS = KeyEvent.KEY_LAST+1;
	boolean[] keys = new boolean[NUM_KEYS];
	boolean[] keysLast = new boolean[NUM_KEYS];

	private final int NUM_BUTTON = 8;
	boolean[] buttons = new boolean[NUM_BUTTON];
	boolean[] buttonsLast = new boolean[NUM_BUTTON];
	
	private int mouseX,mouseY;
	private int scroll;
	
	public Input(GameContainer gc)
	{
		this.gc=gc;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
		gc.getWindow().getCanvas().addMouseWheelListener(this);
	}
	public void update()
	{
		for (int i = 0; i < NUM_KEYS; i++) 
		{
			keysLast[i] = keys[i];
		}
		for (int i = 0; i < NUM_BUTTON; i++) 
		{
			buttonsLast[i] = buttons[i];
		}
	}
	//KEYEVNTS
	public boolean isKey(int keyCode)
	{
		return keys[keyCode];
	}
	public boolean isKeyUp(int keyCode)
	{
		return !keys[keyCode] && keysLast[keyCode];
	}
	public boolean isKeyDown(int keyCode)
	{
		return keys[keyCode] && !keysLast[keyCode];
	}
	//BUTTONS EVENTS
	public boolean isButton(int button)
	{
		return buttons[button];
	}
	public boolean isButtonUp(int button)
	{
		return !buttons[button] && buttonsLast[button];
	}
	public boolean isButtonDown(int button)
	{
		return buttons[button] && !buttonsLast[button];
	}
	
	
	public void mouseDragged(MouseEvent e)
	{
		mouseX=(int)(e.getX()/gc.getScale());
		mouseY=(int)(e.getY()/gc.getScale());
	}

	public void mouseMoved(MouseEvent e) 
	{
		mouseX=(int)(e.getX()/gc.getScale());
		mouseY=(int)(e.getY()/gc.getScale());
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		scroll = e.getWheelRotation();
	}

	public void mouseClicked(MouseEvent e)
	{
		
	}

	public void mouseEntered(MouseEvent e)
	{
		
	}

	public void mouseExited(MouseEvent e)
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
		buttons[e.getButton()]=true;
	}

	public void mouseReleased(MouseEvent e)
	{
		buttons[e.getButton()]=false;
	}

	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() < keys.length && e.getKeyCode() >= 0){
			keys[e.getKeyCode()]=true;
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() < keys.length && e.getKeyCode() >= 0) {
			keys[e.getKeyCode()]=false;
		}
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}
	public int getMouseX() {
		return mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public int getScroll() {
		return scroll;
	}

}

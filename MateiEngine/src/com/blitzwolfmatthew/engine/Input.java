package com.blitzwolfmatthew.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
	private GameContainer gc;
	
	private final int NUM_KEYS = 256;
	private boolean keys[] = new boolean[NUM_KEYS];
	private boolean keysLast[] = new boolean[NUM_KEYS]; //keys pressed in the last frame
	
	private final int NUM_BUTTONS = 5;
	private boolean buttons[] = new boolean[NUM_BUTTONS];
	private boolean buttonsLast[] = new boolean[NUM_BUTTONS]; //buttons pressed in the last frame
	
	public int mouseX, mouseY;
	private int scroll;
	
	public Input(GameContainer gc)
	{
		this.gc = gc;
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
		scroll = 0;
		
		for(int i = 0; i < NUM_KEYS; i++)
		{
			keysLast[i] = keys[i];
		}
		
		for(int i = 0; i < NUM_BUTTONS; i++)
		{
			buttonsLast[i] = buttons[i];
		}
	}
	
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
	
	public boolean isButton(int buttonCode)
	{
		return buttons[buttonCode];
	}
	
	public boolean isButtonUp(int buttonCode)
	{
		return !buttons[buttonCode] && buttonsLast[buttonCode];
	}
	
	public boolean isButtonDown(int buttonCode)
	{
		return buttons[buttonCode] && !buttonsLast[buttonCode];
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		mouseX = (int)(e.getX() / EngineVariables.getScale());
		mouseY = (int)(e.getY() / EngineVariables.getScale());		
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = (int)(e.getX() / EngineVariables.getScale());
		mouseY = (int)(e.getY() / EngineVariables.getScale());
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keys[e.getKeyCode()] = false;
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

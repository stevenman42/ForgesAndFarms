package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right, escape;
	
	private boolean upReady, downReady, leftReady, rightReady;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		
		up = (keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W]) && !upReady;
		upReady = true;
		
		down = (keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S])  && !downReady;
		downReady = true;
		
		left = (keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]) && !leftReady;
		leftReady = true;
		
		right = (keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]) && !rightReady;
		rightReady = true;
		
		escape = keys[KeyEvent.VK_ESCAPE];
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		upReady = false;
		downReady = false;
		leftReady = false;
		rightReady = false;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		upReady = true;
		downReady = false;
		leftReady = false;
		rightReady = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	

}

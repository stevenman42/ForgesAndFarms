package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right, escape;
	
	
	public static boolean keyActive;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		
		up = (keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W]);
		
		down = (keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S]);
		
		left = (keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]);
		
		right = (keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]);
		
		escape = keys[KeyEvent.VK_ESCAPE];
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		keyActive = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		keyActive = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	

}

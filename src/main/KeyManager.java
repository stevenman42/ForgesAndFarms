package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.entities.creatures.Player;
import main.entities.creatures.Zombie;
import main.states.GameState;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right, escape, space,
					one, two, three, four, five, six, seven, eight, nine, zero;
	
	
//	public static boolean keyActive;
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void tick(){
		
		up = (keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W]);
		down = (keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S]);
		left = (keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]);
		right = (keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]);
		
		space = (keys[KeyEvent.VK_SPACE]);
		
		one = (keys[KeyEvent.VK_1]);
		two = (keys[KeyEvent.VK_2]);
		three = (keys[KeyEvent.VK_3]);
		four = (keys[KeyEvent.VK_4]);
		five = (keys[KeyEvent.VK_5]);
		six = (keys[KeyEvent.VK_6]);
		seven = (keys[KeyEvent.VK_7]);
		eight = (keys[KeyEvent.VK_8]);
		nine = (keys[KeyEvent.VK_9]);
		zero = (keys[KeyEvent.VK_0]);
		
		escape = keys[KeyEvent.VK_ESCAPE];
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		try{
			keys[e.getKeyCode()] = true;
		}catch (ArrayIndexOutOfBoundsException f){
			System.out.println("You probably pressed that key on accident.  You fool.");
		}
		//keyActive = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		try{
			keys[e.getKeyCode()] = false;
			Player.moved = false;
			Zombie.setMoved(false);
			GameState.setTurned(false);
		}catch (ArrayIndexOutOfBoundsException f){
			// who cares
		}
//		keyActive = false;	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}

package main;

import java.awt.Dimension;
import java.awt.Toolkit;

//import display.Display;



public class Launcher {

	
	public static void main(String [] args){
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Game game = new Game("Title", 960, 500);
		game.start();
		
	}
}

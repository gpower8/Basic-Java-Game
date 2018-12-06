package game1;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import sun.audio.*;

public class MyCanvas extends Canvas implements KeyListener {
	
	Goodguy write = new Goodguy(385,80,30,30,"files/pencil.png");
	LinkedList badguys = new LinkedList();
	Idea idea = new Idea(340, 570, 100, 100, "files/Original.png");
	Background back = new Background(0, 0, 800, 680, "files/background.png");
	Timer timer = new Timer();
	

	int goals = 0;
	int hits = 0;
	int time = 0;
	int timerSeconds = 0;
	int timerMinutes = 0;


	
	public MyCanvas() { 
		this.setSize(800,680); 
		this.addKeyListener(this); 

		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				timerSeconds++;
			
			}
		}, 1000, 1000);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				timerMinutes++;
			
			}
		} , 60*1000, 60*1000);
		

		Random rand = new Random();
		int winwidth = this.getWidth(); 
		int winheight = this.getHeight();
	

		
		
		for (int i = 0; i<6; i++) {
			int rx = rand.nextInt(winwidth); 
			int ry = rand.nextInt(winheight);
			
				
			Badguy bg = new Badguy(rx, ry, 45,45,"files/Plagiarism.png"); 
			Rectangle br = new Rectangle(rx,ry,30,30); 
				
				
			if (br.contains(write.getxCoord(), write.getyCoord())) {
				System.out.println("Thats Plagiarism");
				continue;
			}
			badguys.add(bg); 
		}
	}

	public void playIt(String filename) {
		try {
			InputStream in = new FileInputStream(filename);
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		time++;
		
		
		g.drawImage(back.getImg(), back.getxCoord(), back.getyCoord(), back.getWidth(), back.getHeight(), this);
		
	
		g.drawImage(write.getImg(), write.getxCoord(), write.getyCoord(), write.getWidth(), write.getHeight(), this);
		
	
		g.drawImage(idea.getImg(), idea.getxCoord(), idea.getyCoord(), idea.getWidth(), idea.getHeight(), this);
		

		g.drawString("Original Ideas:" + " " + String.valueOf(goals), 80, 42);
		
		
		g.drawString("Plagarism:" + " " + String.valueOf(hits), 80, 72);
		
		g.drawString("highscore: 1:02", 80, 132);
		
		// time
		if (timerSeconds < 10) {
			g.drawString(String.valueOf(timerMinutes) + ":0" + String.valueOf(timerSeconds%60), 80, 102);
		} else {
			g.drawString(String.valueOf(timerMinutes) + ":" + String.valueOf(timerSeconds%60), 80, 102);
		}
		
		// bad guys
		for(int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Random rand = new Random();
			if (time%10==0) {
				if (bg.getxCoord()<write.getxCoord() && rand.nextInt()%5<2) {
					bg.setxCoord(bg.getxCoord()+1);
				}
				else if (bg.getxCoord()>write.getxCoord() && rand.nextInt()%5<2) {
					bg.setxCoord(bg.getxCoord()-1);
				}
				
				if (bg.getyCoord()<write.getyCoord() && rand.nextInt()%5<2) {
					bg.setyCoord(bg.getyCoord()+1);
				}
				else if (bg.getyCoord()>write.getyCoord() && rand.nextInt()%5<2) {
					bg.setyCoord(bg.getyCoord()-1);
				}
			}
			
			badguys.set(i, bg);
			
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			repaint();
		}
	}
		
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) { 
		write.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());
		
		Rectangle pr = new Rectangle(write.getxCoord(), write.getyCoord(), write.getHeight(), write.getWidth()); // rectangle around good guy
		Rectangle nr = new Rectangle(340, 570, 100, 100); 
		if(nr.intersects(pr)) {
			write.setxCoord(385); 
			write.setyCoord(80); 
			playIt("files/writing-signature-1.wav"); 
			System.out.println(goals + " goal"); 
			goals++; 
			
			for(int i = 0; i < badguys.size(); i++) {
				Badguy bg = (Badguy) badguys.get(i);
				bg.RePosition(); 
				
			}
		}
			
			
		for(int i = 0; i < badguys.size(); i++) {
			Badguy bg = (Badguy) badguys.get(i);
			Rectangle br = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight()); // rectangle around bad guys
			if (br.intersects(pr)) {
				playIt("files/paper-rustle-4.wav"); 
				write.setxCoord(385); 
				write.setyCoord(80);
				hits++;
				System.out.println(hits + " hits"); 
				
				for(int j = 0; j < badguys.size(); j++) {
					Badguy bg2 = (Badguy) badguys.get(j);
					bg2.RePosition(); 
				}
			}
		}
	}	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}

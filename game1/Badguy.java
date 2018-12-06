package game1;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class Badguy {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 10;
	private int height = 10;
	private Image img;
	

	public Badguy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("../files/right.png");
	}

	public Badguy(int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}
	
	 public void RePosition() { //  re-randomizes positions of bad guys
		
		Random rand = new Random();
		int winwidth = 800;
		int winheight = 680;
		
		int rx = rand.nextInt(winwidth);
		int ry = rand.nextInt(winheight);
		
		
	
		
		setxCoord(rx);
		setyCoord(ry);
			
		
	
		
	}
	

public void setImg(String imgpath) {
	this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
}

public int getxCoord() {
	return xCoord;
}

public void setxCoord(int xCoord) {
	this.xCoord = xCoord;
}

public int getyCoord() {
	return yCoord;
}

public void setyCoord(int yCoord) {
	this.yCoord = yCoord;
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public Image getImg() {
	return img;
}

	public void setImg(Image img) {	
		this.img = img;
	}

}


	
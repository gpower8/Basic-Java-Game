package game1;

import java.awt.Image;
import java.awt.Toolkit;

public class Background {
	
	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 1000;
	private int height = 800;
	private Image img;
	

	public Background() {
	setxCoord(0);
	setyCoord(0);
	setWidth(1000);
	setHeight(800);
	setImg("../files/background.png");
}

public Background(int x, int y, int w, int h, String imgpath) {
	setxCoord(x);
	setyCoord(y);
	setWidth(w);
	setHeight(h);
	setImg(imgpath);
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

public int size() {

	return 0;
}

public Background get(int i) {
	// TODO Auto-generated method stub
	return null;
}

public void add(Background n) {
	// TODO Auto-generated method stub
	
}

public void add1(Background n) {
	// TODO Auto-generated method stub
	
}

public void remove(int i) {
	// TODO Auto-generated method stub
	
}
}


	
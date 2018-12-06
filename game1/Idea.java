package game1;

import java.awt.Image;
import java.awt.Toolkit;

public class Idea {
	
	private int xCoord = 10;
	private int yCoord = 10;
	private int width = 600;
	private int height = 40;
	private Image img;
	

	public Idea() {
	setxCoord(10);
	setyCoord(10);
	setWidth(30);
	setHeight(30);
	setImg("../files/Original.png");
}

public Idea(int x, int y, int w, int h, String imgpath) {
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
	// TODO Auto-generated method stub
	return 0;
}

public Idea get(int i) {
	// TODO Auto-generated method stub
	return null;
}

public void add(Idea n) {
	// TODO Auto-generated method stub
	
}

public void add1(Idea n) {
	// TODO Auto-generated method stub
	
}

public void remove(int i) {
	// TODO Auto-generated method stub
	
}
}


	
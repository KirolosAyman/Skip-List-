package com.company;

public class Rectangle extends java.awt.Rectangle {
	Rectangle(){}
	public Rectangle(int x,int y,int w,int h){
		super(x,y,w,h);
	}
	public String toString() {
        return  ""+this.x+", "+this.y+", "+this.width+", "+this.height;
    }
	boolean validRectangle() {
    	boolean val=true;
    	val&=(x>=0);
    	val&=(y>=0);
    	
    	val&=validRegion();
    	
    	val&=(x+width<=1024);
    	
    	val&=(y+height<=1024);
    	
    	return val;
    }
	boolean validRegion() {
		return width>0&&height>0;
	}
}

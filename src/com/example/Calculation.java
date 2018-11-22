
/* POJO Class */

package com.example;

public class Calculation {

	private int width;
	private int height;
	private int depth;
		
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


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public int calcVolume (int width, int height, int depth) {
		return width * height * depth;
		
	}

}

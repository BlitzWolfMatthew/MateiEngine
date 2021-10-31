package com.blitzwolfmatthew.engine.gfx;

public class Sprite
{
	private int width, height;
	private int pixelData[]; //pixel data
	
	public Sprite(SpriteMap map, int tileX, int tileY)
	{		
		this.width = map.tileWidth;
		this.height = map.tileHeight;
		pixelData = map.pixelData;
		
		pixelData = new int[map.tileWidth * map.tileHeight];
		
		for(int y = 0; y < map.tileHeight; y++)
		{
			for(int x = 0; x < map.tileWidth; x++)
			{
				pixelData[x + y * map.tileWidth] = map.pixelData[tileX * map.tileWidth + x + (tileY * map.tileHeight + y) * map.width];
			}
		}
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

	public int[] getPixelData() {
		return pixelData;
	}

	public void setPixelData(int[] pixelData) {
		this.pixelData = pixelData;
	}
}

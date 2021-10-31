package com.blitzwolfmatthew.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteMap
{
	int width, height;
	int tileWidth, tileHeight;
	int pixelData[];
	
	public SpriteMap(String path, int tileWidth, int tileHeight)
	{
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		
		BufferedImage image = null;
		
		try
		{
			image = ImageIO.read(Sprite.class.getResourceAsStream(path));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		width = image.getWidth();
		height = image.getHeight();
		pixelData = image.getRGB(0, 0, width, height, null, 0, width);
		
		image.flush();
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
}

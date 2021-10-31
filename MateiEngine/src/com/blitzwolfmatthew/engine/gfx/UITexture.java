package com.blitzwolfmatthew.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UITexture
{
	int width, height;
	int pixelData[];
	
	public UITexture(String path)
	{		
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

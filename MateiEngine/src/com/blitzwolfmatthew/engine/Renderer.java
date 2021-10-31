package com.blitzwolfmatthew.engine;

import java.awt.image.DataBufferInt;

import com.blitzwolfmatthew.engine.gfx.Sprite;
import com.blitzwolfmatthew.engine.gfx.UITexture;

public class Renderer
{
	private int pW, pH;
	private int p[];
	
	public Renderer(GameContainer gc)
	{
		pW = EngineVariables.getWidth();
		pH = EngineVariables.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for(int i = 0; i < p.length; i++)
		{
			p[i] = 0;;
		}
	}
	
	public void setPixel(int x, int y, int value)
	{
		//dont draw what is not on the screen // transparent color
		if ((x < 0 || x >= pW || y < 0 || y >= pH) || (value >> 24) == 0x00)
			return;
		
		p[x + y * pW] = value; 
	}
	
	public void drawImage(Sprite image, float offX, float offY)
	{		
		for(int y = 0; y < image.getHeight(); y++)
		{
			for(int x = 0; x < image.getWidth(); x++)
			{
				setPixel(x + (int) offX, y + (int) offY, image.getPixelData()[x + y * image.getWidth()]);
			}
		}
	}
	
	public void drawTexture(UITexture image, int offX, int offY, int sizeX, int sizeY)
	{		
		for(int y = 0; y < sizeY; y++)
		{
			for(int x = 0; x < sizeX; x++)
			{
				setPixel(x + offX, y + offY, image.getPixelData()[x % image.getWidth() + (y % image.getHeight()) * image.getWidth()]);
			}
		}
	}
}

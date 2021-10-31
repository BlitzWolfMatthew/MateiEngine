package com.blitzwolfmatthew.engine.assets;

import com.blitzwolfmatthew.engine.Renderer;
import com.blitzwolfmatthew.engine.gfx.*;

public class Object2D extends GameElement
{
	protected int offX, offY;
	protected int rotation;
	
	protected Sprite image;
	
	public Object2D(Sprite image, int offX, int offY, int rotaton)
	{
		this.image = image;
		this.offX = offX;
		this.offX = offY;
		this.rotation = 0;
		
		GameElement.getGameElements().add(this);
	}
	
	@Override
	public void draw(Renderer r)
	{
		r.drawImage(image, offX, offY);
	}
}

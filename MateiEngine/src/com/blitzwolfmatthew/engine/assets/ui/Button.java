package com.blitzwolfmatthew.engine.assets.ui;

import com.blitzwolfmatthew.engine.assets.GameElement;
import com.blitzwolfmatthew.engine.gfx.SpriteMap;

public class Button extends GameElement
{
	SpriteMap image;
	int offX, offY;
	
	public Button(SpriteMap image, int offX, int offY)
	{
		this.image = image;
		this.offX = offX;
		this.offY = offY;
		
		GameElement.getGameElements().add(this);
	}
}

package com.blitzwolfmatthew.game;

import com.blitzwolfmatthew.engine.AbstractGame;
import com.blitzwolfmatthew.engine.GameContainer;
import com.blitzwolfmatthew.engine.Renderer;
import com.blitzwolfmatthew.engine.assets.GameElement;
import com.blitzwolfmatthew.engine.assets.Object2D;
import com.blitzwolfmatthew.engine.assets.ui.Box;
import com.blitzwolfmatthew.engine.gfx.Sprite;
import com.blitzwolfmatthew.engine.gfx.SpriteMap;
import com.blitzwolfmatthew.engine.gfx.UITexture;

public class Main extends AbstractGame
{
	SpriteMap sprites = new SpriteMap("/Stylar-1.png", 32, 32);
	Object2D part = new Object2D(new Sprite(sprites, 0, 0), 50, 50, 0);
	UITexture texture = new UITexture("/UITest.png");
	Box box = new Box(texture, 50, 50, 100, 100);
	
	@Override
	public void update(GameContainer gc, float deltaTime)
	{
		
	}
	
	public static void main(String args[])
	{
		GameContainer gc = new GameContainer(new Main());
		gc.start();
	}
	
}

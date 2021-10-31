package com.blitzwolfmatthew.engine.assets;

import java.util.*;
import com.blitzwolfmatthew.engine.Renderer;

public class GameElement 
{
	static List<GameElement> gameElements = new ArrayList<GameElement>();
	
	public void draw(Renderer r)
	{
		return;
	}

	public static List<GameElement> getGameElements() {
		return gameElements;
	}
}

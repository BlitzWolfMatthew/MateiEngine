package com.blitzwolfmatthew.engine.assets.ui;

import java.util.ArrayList;
import java.util.List;
import com.blitzwolfmatthew.engine.Renderer;

public class UIElement
{
	static List<UIElement> uiElements = new ArrayList<UIElement>();
	
	public void draw(Renderer r)
	{
		return;
	}

	public static List<UIElement> getuiElements() {
		return uiElements;
	}
}

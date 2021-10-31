package com.blitzwolfmatthew.engine.assets.ui;

import com.blitzwolfmatthew.engine.*;
import com.blitzwolfmatthew.engine.gfx.UITexture;

public class Box extends UIElement
{
	UITexture texture;
	int offX, offY, width, height;
	
	public Box(UITexture texture, int offX, int offY, int width, int height)
	{
		this.texture = texture;
		this.offX = offX;
		this.offY = offY;
		this.width = width;
		this.height = height;
		
		UIElement.getuiElements().add(this);
	}

	@Override
	public void draw(Renderer r)
	{
		r.drawTexture(texture, offX, offY, width, height);
	}
	
	public void setTexture(UITexture texture) {
		this.texture = texture;
	}
	public int getOffX() {
		return offX;
	}
	public void setOffX(int offX) {
		this.offX = offX;
	}
	public int getOffY() {
		return offY;
	}
	public void setOffY(int offY) {
		this.offY = offY;
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

	public UITexture getTexture() {
		return texture;
	}
}

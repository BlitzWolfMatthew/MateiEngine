package com.blitzwolfmatthew.engine;

public class EngineVariables
{
	public static final double UPDATE_CAP = 1.0/60.0;
	public static int width = 640, height = 480;
	public static float scale = 2f;
	public static String Title = "version 0.1";
	
	public static int getWidth() {
		return width;
	}
	public static void setWidth(int width) {
		EngineVariables.width = width;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		EngineVariables.height = height;
	}
	public static float getScale() {
		return scale;
	}
	public static void setScale(float scale) {
		EngineVariables.scale = scale;
	}
	public static String getTitle() {
		return Title;
	}
	public static void setTitle(String title) {
		Title = title;
	}
	public static double getUpdateCap() {
		return UPDATE_CAP;
	}
}

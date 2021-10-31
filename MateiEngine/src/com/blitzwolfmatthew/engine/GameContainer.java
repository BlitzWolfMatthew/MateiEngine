package com.blitzwolfmatthew.engine;

import com.blitzwolfmatthew.engine.assets.GameElement;
import com.blitzwolfmatthew.engine.assets.ui.UIElement;

public class GameContainer implements Runnable
{
	private Thread thread;
	
	private Window window;
	private Renderer renderer;
	private Input input;
	private AbstractGame game;
	
	private boolean running = false;	
	
	public GameContainer(AbstractGame game)
	{
		this.game = game;
	}
	
	public void start()
	{
		thread = new Thread(this);
		
		window = new Window(this);		
		renderer = new Renderer(this);
		input = new Input(this);
		
		thread.run();
	}
	
	public void stop()
	{
		
	}
	
	public void run()
	{
		running = true;
		
		boolean render = false;
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		
		double frameTime = 0;
		int frames = 0;
		int fps = 0;
		
		while(running)
		{
			render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= EngineVariables.UPDATE_CAP)
			{
				unprocessedTime -= EngineVariables.UPDATE_CAP;
				render = true; //only render when the game updates - no point of rendering the game if it didnt update
				
				game.update(this, (float)EngineVariables.UPDATE_CAP);
				input.update();
				
				if(frameTime >= 1.0)
				{
					frameTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}
			}
			
			if(render)
			{
				renderer.clear();
				
				for (GameElement element : GameElement.getGameElements())
				{
					element.draw(renderer);
				}
				for (UIElement element : UIElement.getuiElements())
				{
					element.draw(renderer);
				}
				
				window.update();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		dispose();
	}
	
	public void dispose()
	{
		
	}
	
	public Window getWindow() {
		return window;
	}
	

	public Input getInput() {
		return input;
	}
}

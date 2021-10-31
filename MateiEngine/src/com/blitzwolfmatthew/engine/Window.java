package com.blitzwolfmatthew.engine;

import java.awt.*;
import java.awt.image.*;
import javax.swing.JFrame;

public class Window
{
	private JFrame frame;
	private BufferedImage image;
	private Canvas canvas;
	private BufferStrategy bs;
	private Graphics g;
	
	public Window(GameContainer gc)
	{
		image = new BufferedImage(EngineVariables.getWidth(), EngineVariables.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		canvas = new Canvas();
		Dimension s = new Dimension((int) (EngineVariables.getWidth() * EngineVariables.getScale()), (int) (EngineVariables.getHeight() * EngineVariables.getScale()));
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMaximumSize(s);
		
		frame = new JFrame(EngineVariables.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.pack(); //set the frame to the size of the canvas
		frame.setLocationRelativeTo(null); //the window starts in the middle of the screen
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas.createBufferStrategy(2);
		bs = canvas.getBufferStrategy();
		g = bs.getDrawGraphics();
	}
	
	public void update()
	{
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		bs.show();
	}

	public BufferedImage getImage() {
		return image;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}
}

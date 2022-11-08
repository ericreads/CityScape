import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
public class ParticleEmitter {
	private int x;
	private int y;
	private int pps;
	private int radius;
	private float partSize;
	private int partLife;
	private int initialVelocityX;
	private int initialVelocityY;
	private boolean active;
	private Shape shape;
	private Color color;
	private List<Particle> particles;
	
	public ParticleEmitter(int x, int y, int pps, int radius, float partSize, int partLife, int initialVelocityX, int initialVelocityY, Color color, Shape shape)
	{
		this.x = x;
		this.y = y;
		this.pps = pps;
		this.radius = radius;
		this.partLife = partLife;
		this.partSize = partSize;
		this.initialVelocityX = initialVelocityX;
		this.initialVelocityY = initialVelocityY;
		particles = new ArrayList<Particle>();
		active = true;
		this.color = color;
		this.shape = shape;
	}
	public void setActive(boolean active) { this.active = active; }
	public void update()
	{
		if(active)
		{
			for(int i = 0; i < pps; i++)
			{
				particles.add(new Particle(x + (int)(Math.random() * radius), y + (int)(Math.random() * radius), initialVelocityX, initialVelocityY, partSize, partLife, color, shape));
			}
		}
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		for(int i = 0; i < particles.size(); i++) {
			if(particles.get(i).getIsDead())
				particles.remove(i);
		}
	}
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics2D g)
	{
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).draw(g);
		}
	}
	
}

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class Car {
	private BufferedImage image = null;
	private int x;
	private int y;
	private int vx;
	private int vy;
	private CityJPanel jp;
	private DriveableUFO ufo = null;
	private boolean exploded;
	private RadialEmitter emitter;
	private ParticleEmitter tractorEffect;
	
	public Car(CityJPanel jp)
	{
		this.jp = jp;
		this.x = 20;
		this.y = 310;
		this.vx = 1;
		try {
		image = ImageIO.read(new File("car.png"));
		} catch (IOException e) {
			System.out.println("Failed to read file!");
		}
		exploded = false;
		emitter = new RadialEmitter(x, y, 200, 0.15f, 50, 10, Color.red, Shape.OVAL);
		tractorEffect = new ParticleEmitter(x, y, 5, 128, 0.10f, 60, 0, -2, Color.green, Shape.RECTANGLE);
	}
	public Car(CityJPanel jp, DriveableUFO ufo)
	{
		this.jp = jp;
		this.x = 20;
		this.y = 310;
		this.vx = 1;
		try {
		image = ImageIO.read(new File("car.png"));
		} catch (IOException e) {
			System.out.println("Failed to read file!");
		}
		this.ufo = ufo;
		exploded = false;
		emitter = new RadialEmitter(x, y, 10, 0.15f, 50, 10, Color.red, Shape.OVAL);
		tractorEffect = new ParticleEmitter(x, y, 5, 128, 0.10f, 60, 0, -2, Color.green, Shape.RECTANGLE);
	}
	public void update()
	{
		if(y == 310)
			x += vx;
		if(x >= jp.getWidth())
			x = -128;
		if(ufo != null && ufo.isTractoring() && Math.abs(ufo.getX() - x) < 100 && !exploded)
		{
			tractorEffect.setActive(true);
			vy = -1;
			tractorEffect.setPos(x, y);
			if(y == ufo.getY())
			{
				exploded = true;
				emitter.setPos(ufo.getX() + 15, ufo.getY()+50);
				emitter.burst();
				tractorEffect.setActive(false);
			}
		} else
		{
			vy += 1;
			if(vy < 3)
				vy = 3;
			tractorEffect.setActive(false);
		}
		y += vy;
		if(y > 310)
			y = 310;
		tractorEffect.update();
		emitter.update();
	}
	public void draw(Graphics2D g) {
		if(!exploded)
			g.drawImage(image, x, y, null);
		emitter.draw(g);
		tractorEffect.draw(g);
	}
}

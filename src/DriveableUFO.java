import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.*;
public class DriveableUFO {
	private int x;
	private int y;
	private CityJPanel jp;
	private int xa;
	private int ya;
	private ParticleEmitter emitter;
	private boolean tractorBeam;
	public DriveableUFO(CityJPanel jp, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.jp = jp;
		tractorBeam = false;
		emitter = new ParticleEmitter(x, y, 3, 10, 0.25f, 60 ,0 , 0, Color.blue, Shape.OVAL);
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -2;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 2;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			ya = -2;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = 2;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			tractorBeam = true;
	}
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = 0;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 0;
		if(e.getKeyCode() == KeyEvent.VK_UP)
			ya = 0;
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = 0;
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
			tractorBeam = false;
	}
	public boolean isTractoring() { return tractorBeam; }
	public int getX() { return x; }
	public int getY() { return y; }
	public void update()
	{
		x += xa;
		y += ya;
		if(x < 0)
			x = 0;
		else if (x > jp.getWidth() - 20)
			x = jp.getWidth() - 20;
		if(y < 0)
			y = 0;
		if(y > jp.getHeight() - 15)
			y = jp.getHeight() - 15;
		emitter.setPos(x, y);
		emitter.update();
	}
	public void draw(Graphics2D g)
	{
		emitter.draw(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x+2, y, 25, 15);
		g.setColor(Color.darkGray);
		g.fillOval(x-5, y+7, 40, 20);
	}
	
}
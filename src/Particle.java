import java.awt.*;
public class Particle {
	private int x;
	private int y;
	private int xa;
	private int ya;
	private float size;
	private int lifetime;
	private int countdown;
	private int curSize = 0;
	private Color color;
	private Shape shape;
	
	private boolean isDead = false;

	public Particle(int x, int y, int vx, int vy, float size, int lifetime)
	{
		this.x = x;
		this.y = y;
		xa = vx;
		ya = vy;
		this.size = size;
		this.lifetime = lifetime;
		countdown = lifetime;
		this.color = Color.blue;
		this.shape = Shape.OVAL;
	}
	public Particle(int x, int y, int vx, int vy, float size, int lifetime, Color color)
	{
		this.x = x;
		this.y = y;
		xa = vx;
		ya = vy;
		this.size = size;
		this.lifetime = lifetime;
		countdown = lifetime;
		this.color = color;
		this.shape = Shape.OVAL;
	}
	public Particle(int x, int y, int vx, int vy, float size, int lifetime, Color color, Shape shape)
	{
		this.x = x;
		this.y = y;
		xa = vx;
		ya = vy;
		this.size = size;
		this.lifetime = lifetime;
		countdown = lifetime;
		this.color = color;
		this.shape = shape;
	}
	
	public void update()
	{
		countdown--;
		x += xa;
		y += ya;
		curSize = (int)(size * ((100 / lifetime) * countdown));
		if(countdown <= 0)
			isDead = true;
	}
	public boolean getIsDead() { return isDead; }
	public void draw(Graphics2D g)
	{
		g.setColor(color);
		if(shape == Shape.OVAL)
			g.fillOval(x, y, curSize, curSize);
		else if (shape == Shape.RECTANGLE)
			g.fillRect(x, y, curSize, curSize);
	}
}

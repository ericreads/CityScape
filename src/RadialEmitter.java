import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
class RadialEmitter {
	private int ppl;
	private int x;
	private int y;
	private float partSize;
	private int partLife;
	private float initialVelocity;
	private List<Particle> particles;
	private Shape shape;
	private Color color;
	
	public RadialEmitter(int x, int y, int ppl, float partSize, int partLife, float velocity)
	{
		this.x = x;
		this.y = y;
		this.partSize = partSize;
		this.partLife = partLife;
		this.initialVelocity = velocity;
		this.ppl = ppl;
		this.color = Color.BLUE;
		particles = new ArrayList<Particle>();
	}
	
	public RadialEmitter(int x, int y, int ppl, float partSize, int partLife, float velocity, Color color, Shape shape)
	{
		this.x = x;
		this.y = y;
		this.partSize = partSize;
		this.partLife = partLife;
		this.initialVelocity = velocity;
		this.ppl = ppl;
		this.color = color;
		this.shape = shape;
		particles = new ArrayList<Particle>();
	}
	
	public void burst()
	{
		for(int i = 0; i < ppl; i++)
		{
			double a = Math.random() * Math.PI * 2;
			int xa = (int)((Math.cos(a)) * (initialVelocity * Math.random()));
			int ya = (int)((Math.sin(a)) * (initialVelocity * Math.random()));
			particles.add(new Particle(x, y, xa, ya, partSize, partLife, color, shape));
		}
	}
	public void setPos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void update()
	{
		for(int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		for(int i = 0; i < particles.size(); i++) {
			if(particles.get(i).getIsDead())
				particles.remove(i);
		}
	}
	public void draw(Graphics2D g)
	{
		for(int i = 0; i < particles.size(); i++)
		{
			particles.get(i).draw(g);
		}
	}
}

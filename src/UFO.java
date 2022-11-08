import java.awt.*;
public class UFO {
	private int x;
	private int y;
	private int xa;
	private int ya;
	private static final int DIAMETER = 20;
	private CityJPanel jp;
	private ParticleEmitter emitter;
	private RadialEmitter collisionEffect;
	
	public UFO(CityJPanel jp,int x, int y, int xa, int ya)
	{
		this.x = x;
		this.y = y;
		this.xa = xa;
		this.ya = ya;
		this.jp = jp;
		emitter = new ParticleEmitter(x, y, 3, 10, 0.25f, 60 ,0 , 0, Color.blue, Shape.OVAL);
		collisionEffect = new RadialEmitter(x, y, 10, 0.15f, 60, 10, Color.green, Shape.OVAL);
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getXA() { return xa; }
	public int getYA() { return ya; }
	public void setXA(int xa) { this.xa = xa; }
	public void setYA(int ya) { this.ya = ya; }
	
	public void collision(UFO b)
	{
		int dx = (x-b.getX()) + (xa-b.getXA());
		int dy = (y-b.getY()) + (ya-b.getYA());
		
		if (Math.sqrt(dx*dx+dy*dy)<=DIAMETER)
		{
			collisionEffect.setPos(x, y);
			collisionEffect.burst();
			int tempxa = xa;
			int tempya = ya;
			xa = b.getXA();
			ya = b.getYA();
			b.setXA(tempxa);
			b.setYA(tempya);
		}
	}
	
	public void update()
	{
		if (x + xa < 0) 
			 xa = -xa; 
			 if (x + xa > jp.getWidth() - DIAMETER) 
			 {
				 xa = -xa; //go left
				 collisionEffect.setPos(x, y);
				 collisionEffect.burst();
			 }
			 if (y + ya < 0) 
			 {
				 ya = -ya; //go down
				 collisionEffect.setPos(x, y);
				 collisionEffect.burst();
			 }
			 if (y + ya > jp.getHeight()/2 - DIAMETER) 
			 {
				 ya = -ya; 
				 //collisionEffect.setPos(x, y);
				 //collisionEffect.burst();
			 }
			 x = x + xa;
			 y = y + ya;
		emitter.setPos(x, y);
		emitter.update();
		collisionEffect.update();
	}
	public void draw(Graphics2D g)
	{
		emitter.draw(g);
		collisionEffect.draw(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x+2, y, 25, 15);
		g.setColor(Color.darkGray);
		g.fillOval(x-5, y+7, 40, 20);
	}
	
}

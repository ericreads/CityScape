import java.awt.*;
public class Swarm {
	private UFO[] ufos;
	
	public Swarm(int count, CityJPanel jp)
	{
		ufos = new UFO[count];
		for(int i = 0; i < ufos.length; i++)
		{
			ufos[i] = new UFO(jp, (int)(Math.random() * jp.getWidth()), (int)(Math.random() * (jp.getHeight() / 2 - 5)), (int)(1+Math.random()*3), (int)(1+Math.random()*3));
		}
	}
	
	public void update()
	{
		for(int i = 0; i < ufos.length; i++)
		{
			for(int j = 0; j < ufos.length; j++)
			{
				if(j != i)
					ufos[i].collision(ufos[j]);
			}
		}
		for(int i = 0; i < ufos.length; i++)
		{
			ufos[i].update();
		}
	}
	public void draw(Graphics2D g)
	{
		for(int i = 0; i < ufos.length; i++)
		{
			ufos[i].draw(g);
		}
	}

}

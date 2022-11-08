import java.awt.Color;
import java.awt.Graphics2D;

public class Window {
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	public Window(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.width = 20;
		this.height = 20;
		if(Math.random() > 0.5)
			color = Color.BLACK;
		else
			color = Color.YELLOW;
	}
	
	public void Draw(Graphics2D g)
	{
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}

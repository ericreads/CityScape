import java.awt.Graphics2D;
import java.awt.Color;
public class Building {
	private int height;
	private int width;
	private int x;
	private int y;
	private Window[][] windows;
	
	public Building(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width*25;
		this.height = height*25;
		this.windows = new Window[height][width];
		for(int i = 0; i < windows.length; i++)
		{
			int currentRow = y+i*25 + 5;
			for(int j = 0; j < windows[i].length; j++)
			{
				windows[i][j] = new Window(x+j*25 + 5, currentRow);
			}
		}
	}
	
	public void Draw(Graphics2D g)
	{
		g.setColor(Color.darkGray);
		g.fillRect(x, y, width + 5, height + 5);
		for(int i = 0; i < windows.length; i++)
		{
			for(int j = 0; j < windows[i].length; j++)
			{
				windows[i][j].Draw(g);
			}
		}
	}
}

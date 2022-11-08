import java.awt.Color;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

enum Shape {
	OVAL,
	RECTANGLE
}

public class CityJPanel extends JPanel {
	private Building b1 = new Building(4, 160, 5, 11);
	private Building b2 = new Building(170, 190, 5, 10);
	private Building b3 = new Building(370, 260, 5, 7);
	private Building b4 = new Building(520, 190, 5, 10);
	private Building b5 = new Building(700, 160, 5, 11);
	private DriveableUFO ufo = new DriveableUFO(this, 20, 20);
	private Car car = new Car(this, ufo);
	private static Swarm swarm;
	
	public CityJPanel() 
	{
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				ufo.keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				ufo.keyPressed(e);
			}
		});
		
		setFocusable(true);
	}
	
	private void update()
	{
		//swarm.update();
		car.update();
		ufo.update();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 1024, 480);
		b1.Draw(g2d);
		b2.Draw(g2d);
		b3.Draw(g2d);
		b4.Draw(g2d);
		b5.Draw(g2d);
		//swarm.draw(g2d);
		car.draw(g2d);
		ufo.draw(g2d);
	}
	public static void main(String[] args)  throws InterruptedException{
		JFrame frame = new JFrame("Cityscape");
		 //Add our JPanel to the frame
		CityJPanel p = new CityJPanel();
		frame.add(p);
		// if you use setContentPane it will allow you to switch
		// easily between multiple panels
		// frame.setContentPane(new JPanelExample());
		frame.setSize(1020, 480);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		swarm = new Swarm(3, p);
		while(true)
		{
			p.update();
			p.repaint();
			Thread.sleep(10);
		}
	}
}
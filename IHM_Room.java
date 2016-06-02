package Windows;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IHM_Room extends JPanel
{
	private ImageIcon icoFond;
	private Image imgFond1;

	private int xFond1;

	public IHM_Room(String name)
	{
		super(); 

		this.icoFond = new ImageIcon(getClass().getResource("/pictures/" + name + ".png"));
		this.imgFond1 = this.icoFond.getImage();
	}

	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics g2 = g;

		g2.drawImage(this.imgFond1, 0, -15, null);
	}

}

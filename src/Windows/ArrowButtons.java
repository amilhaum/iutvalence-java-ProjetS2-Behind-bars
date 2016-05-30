package Windows;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ArrowButtons extends JButton
{
	public ArrowButtons(int x, int y, int sizeX, int sizeY, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, sizeX, sizeY);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

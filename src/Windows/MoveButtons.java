package Windows;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MoveButtons extends JButton
{
	public MoveButtons(int x, int y, int sizeX, int sizeY, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, sizeX, sizeY);
	}
}

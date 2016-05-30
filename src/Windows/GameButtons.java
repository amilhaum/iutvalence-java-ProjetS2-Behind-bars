package Windows;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial") public class GameButtons extends JButton
{
	public GameButtons(int x, int y, int sizeX, int sizeY, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, sizeX, sizeY);
	}
}

package iut.valence.behindbars.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameButtons extends JButton
{
	public GameButtons(int x, int y, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, 219, 49);
	}
}

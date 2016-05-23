package Windows;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CharacterButtons extends JButton
{
	private String name;

	public CharacterButtons(String nameOfCharacter, int x, int y, int sizeX, int sizeY, ImageIcon image)
	{
		super(image);
		this.name = nameOfCharacter;
		this.setBounds(x, y, sizeX, sizeY);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

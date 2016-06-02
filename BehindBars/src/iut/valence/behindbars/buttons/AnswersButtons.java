package iut.valence.behindbars.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AnswersButtons extends JButton
{
	public AnswersButtons(int x, int y, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, 153, 66);
	}
}

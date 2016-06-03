package iut.valence.behindbars.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The answers buttons of the game.
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */

public class AnswersButtons extends JButton
{
	/**
	 * Initialization of the answering buttons and their positions
	 * 
	 * @param x is the line's number of the position
	 * @param y is the column's number of the position
	 * @param image is the pictures of the button
	 */
	public AnswersButtons(int x, int y, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, 153, 66);
	}
}

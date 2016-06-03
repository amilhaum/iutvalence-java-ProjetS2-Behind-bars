package iut.valence.behindbars.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * The arrow buttons of the game.
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */

public class ArrowButtons extends JButton
{
	/**
	 * Initialization of the arrow buttons and their positions
	 * 
	 * @param x is the line's number of the position
	 * @param y is the column's number of the position
	 * @param sizeX is the line's size of the position
	 * @param sizeY is the column's size of the position
	 * 
	 * @param image is the pictures of the button
	 */
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

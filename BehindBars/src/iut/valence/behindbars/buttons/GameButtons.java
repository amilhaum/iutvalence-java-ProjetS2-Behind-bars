package iut.valence.behindbars.buttons;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;
	/* Initialization of the buttons those serve to choose to start the game
	 * 
	 * @param Positions x and y, and an image
	 * */
public class GameButtons extends JButton
{
	public GameButtons(int x, int y, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, 219, 49);
	}
}

package iut.valence.behindbars.buttons;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * The buttons of the main of the game.
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class GameButtons extends JButton
{
	/** The serial version ID. */
	private static final long serialVersionUID = 8536527086946062277L;

	/**
	 * The constructor of the game button.
	 * 
	 * @param x is the number of line of the position
	 * @param y is the number of column of the position
	 * @param image is the pictures of the button
	 */
	public GameButtons(int x, int y, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, 219, 49);
	}
}

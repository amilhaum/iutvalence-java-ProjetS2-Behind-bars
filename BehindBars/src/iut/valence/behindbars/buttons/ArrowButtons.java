package iut.valence.behindbars.buttons;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;

	/* Initialization of the Arrows those serve to move
	 * 
	 * @param Positions x, y, Sizes x, y and an image
	 * 
	 * */ 
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

package iut.valence.behindbars.buttons;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
import javax.swing.ImageIcon;
import javax.swing.JButton;

	/* Initialization of the answering buttons and their positions
	 * 
	 * @param Positions x, y and an image
	 * */
public class AnswersButtons extends JButton
{
	public AnswersButtons(int x, int y, ImageIcon image)
	{
		super(image);
		this.setBounds(x, y, 153, 66);
	}
}

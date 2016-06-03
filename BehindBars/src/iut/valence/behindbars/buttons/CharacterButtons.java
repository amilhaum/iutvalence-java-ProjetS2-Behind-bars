package iut.valence.behindbars.buttons;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
import iut.valence.behindbars.character.Character;



import javax.swing.JButton;
	

	/* Initialization of the Character and their position
	 * 
	 * @param a name, the player, positions x and y, and pictures
	 *
	 * */

public class CharacterButtons extends JButton
{
	private String name;

	public CharacterButtons(String nameOfCharacter, Character player, int x, int y, int pictures)
	{
		super(player.getPictures()[pictures]);
		this.name = nameOfCharacter;
		this.setBounds(x, y, 50, 50);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

package iut.valence.behindbars.buttons;

import iut.valence.behindbars.character.Character;




import javax.swing.JButton;
	
/**
 * The character buttons of the game.
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */

public class CharacterButtons extends JButton
{
	/** The serial version ID. */
	private static final long serialVersionUID = 4723081670484350483L;
	/** The button's name. */

	/**
	 * Initialization of the character buttons and their positions
	 * 
	 * @param nameOfCharacter is the button's name
	 * @param player is the player
	 * @param x is the line's number of the position
	 * @param y is the column's number of the position
	 * @param pictures is number of the picture
	 */
	public CharacterButtons(String nameOfCharacter, Character player, int x, int y, int pictures)
	{
		super(player.getPictures()[pictures]);
		this.setBounds(x, y, 50, 50);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

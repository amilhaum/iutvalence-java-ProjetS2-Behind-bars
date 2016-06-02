package iut.valence.behindbars.buttons;

import iut.valence.behindbars.character.Character;

import javax.swing.JButton;

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

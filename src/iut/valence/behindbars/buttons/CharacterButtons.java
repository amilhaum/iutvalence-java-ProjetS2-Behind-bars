package iut.valence.behindbars.buttons;

import javax.swing.JButton;

import iut.valence.behindbars.character.Player;

public class CharacterButtons extends JButton
{
	private String name;

	public CharacterButtons(String nameOfCharacter, Player player, int x, int y)
	{
		super(player.getPictures()[0]);
		this.name = nameOfCharacter;
		this.setBounds(x, y, 50, 50);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

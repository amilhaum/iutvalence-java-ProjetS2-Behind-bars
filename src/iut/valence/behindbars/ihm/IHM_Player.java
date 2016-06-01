package iut.valence.behindbars.ihm;

import javax.swing.JButton;

import iut.valence.behindbars.character.Player;

public class IHM_Player extends JButton
{
	private String name;

	public IHM_Player(Player player)
	{
		super(player.getPictures()[0]);
		this.name = player.getName();
		this.setBounds(player.getPos().getX(), player.getPos().getY(), 50, 50);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

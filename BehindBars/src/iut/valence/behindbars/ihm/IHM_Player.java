package iut.valence.behindbars.ihm;

import javax.swing.JButton;

import iut.valence.behindbars.character.Player;

/**
 * IHM to display the player
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class IHM_Player extends JButton
{
	/** The player's ihm name. */
	private String name;

	/**
	 * The constructor of the player's ihm.
	 * @param npc is the player which is going to be shown
	 */
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

package iut.valence.behindbars.ihm;

import javax.swing.JButton;

import iut.valence.behindbars.character.NPC;

/**
 * IHM to display the npc
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class IHM_NPC extends JButton
{
	/** The serial version ID. */
	private static final long serialVersionUID = -2503393819196585621L;

	/**
	 * The constructor of the npc's ihm.
	 * @param npc is the npc which is going to be shown
	 */
	public IHM_NPC(NPC npc)
	{
		super(npc.getPicturesNPC());

		this.setBounds(npc.getPos().getX(), npc.getPos().getY(), 50, 50);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

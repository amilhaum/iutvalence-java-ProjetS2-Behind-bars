package iut.valence.behindbars.ihm;

import javax.swing.JButton;

import iut.valence.behindbars.character.NPC;

public class IHM_NPC extends JButton
{
	private String name;

	public IHM_NPC(NPC npc)
	{
		super(npc.getPicturesNPC());

		this.name = npc.getName();
		this.setBounds(npc.getPos().getX(), npc.getPos().getY(), 50, 50);

		this.setBorder(null);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}
}

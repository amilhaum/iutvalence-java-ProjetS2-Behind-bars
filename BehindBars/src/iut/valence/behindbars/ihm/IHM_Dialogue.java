package iut.valence.behindbars.ihm;

import iut.valence.behindbars.game.Dialogue;

import javax.swing.JTextArea;

/**
 * IHM to display the dialogues
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class IHM_Dialogue extends JTextArea
{
	/**
	 * The constructor of the IHM_Dialogue
	 *
	 * @param dialogue is the dialogue
	 */
	public IHM_Dialogue(Dialogue dialogue)
	{
		super(dialogue.toString());
		this.setBounds(120, 415, 525, 60);
		this.setLineWrap(true);
		this.setEditable(false);
	}
}

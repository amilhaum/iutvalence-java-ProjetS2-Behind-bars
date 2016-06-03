package iut.valence.behindbars.ihm;

import javax.swing.JTextArea;

import iut.valence.behindbars.game.Dialogue;

/**
 * IHM to display the dialogues
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class IHM_Dialogue extends JTextArea
{
	/** The serial version ID. */
	private static final long serialVersionUID = -5647863749094186620L;

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

	/**
	 * The constructor of the IHM_Dialogue
	 *
	 * @param string is the text which will be posted
	 */
	public IHM_Dialogue(String dialogue)
	{
		super(dialogue);
		this.setBounds(120, 315, 525, 60);
		this.setLineWrap(true);
		this.setEditable(false);
	}
}

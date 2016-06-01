package iut.valence.behindbars.character;

import javax.swing.ImageIcon;

import iut.valence.behindbars.windows.PositionOnScreen;

/**
 * The Non-Players Characters of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class NPC extends Character
{
	/** The NPC's state. */
	private final StateOfCharacter state;

	/**
	 * The NPC's constructor
	 *
	 * @param name is the NPC's name
	 */
	public NPC(String name, StateOfCharacter state, PositionOnScreen pos0)
	{
		super(name);
		this.state = state;
		this.pos = pos0;
	}

	/**
	 * The method to get the NPC's state.
	 *
	 * @return the NPC's state
	 */
	public StateOfCharacter getState()
	{
		return state;
	}

	public ImageIcon getPicturesNPC()
	{
		ImageIcon str;

		if (this.state == StateOfCharacter.Prisoner)
		{

			if (this.name == "Bryan" || this.name == "Alexandro" || this.name == "Daryl" || this.name == "Carlos")
			{
				str = this.pictures[1];
			}
			else if (this.name == "Barry" || this.name == "Fernando")
			{
				str = this.pictures[2];
			}
			else if (this.name == "Garry" || this.name == "Drake")
			{
				str = this.pictures[3];
			}
			else if (this.name == "Steven")
			{
				str = this.pictures[6];
			}
			else if (this.name == "John")
			{
				str = this.pictures[7];
			}
			else
			{
				str = this.pictures[4];
			}
		}
		else
		{
			str = this.pictures[5];
		}

		return str;
	}

}

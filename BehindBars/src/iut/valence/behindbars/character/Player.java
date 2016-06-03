package iut.valence.behindbars.character;

import iut.valence.behindbars.windows.PositionOnScreen;

/**
 * The player of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Player extends Character
{
	private static final int		DEFAULT_PENALTY		= 0;

	private static final PositionOnScreen	DEFAULT_PLAYER_POS	= new PositionOnScreen(300, 270);

	private int						penalty;

	/**
	 * The constructor of the player
	 *
	 * @param name is the player's name
	 */
	public Player(String name)
	{
		super(name);
		this.penalty = DEFAULT_PENALTY;
		this.pos = DEFAULT_PLAYER_POS;
	}
	/* Reading accessors for the penalty
	 * 
	 * @return penalty
	 */
	public int getPenalty()
	{
		return penalty;
	}
	/* Reading accessors for the penalty*/
	public void setPenalty(int penalty)
	{
		this.penalty = penalty;
	}

}

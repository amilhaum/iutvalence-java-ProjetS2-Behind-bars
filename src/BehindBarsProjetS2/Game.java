package BehindBarsProjetS2;

import java.util.Collection;

/**
 * The game of BehindBars
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Game
{
	/** The game's character */
	private Player			player;

	/** The game's NPCs */
	private Collection<NPC>	NPCs;

	/** The constructor of the game in progress */
	public Game(String player)
	{
		this.player = new Player(player);
	}

	/**
	 * The constructor of the game's start
	 * 
	 */
	public void start()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * The constructor of the game's quit
	 * 
	 */
	public void Quit()
	{
		throw new UnsupportedOperationException();
	}

}
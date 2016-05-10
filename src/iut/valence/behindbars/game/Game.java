package iut.valence.behindbars.game;

import java.util.ArrayList;

import iut.valence.behindbars.character.John;
import iut.valence.behindbars.character.NPC;
import iut.valence.behindbars.character.Player;

/**
 * The game of BehindBars
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Game
{
	/** The game's character */
	private Player					player;

	/** The game's NPCs */
	private static ArrayList<NPC>	NPCs;

	/** The constructor of the game in progress */
	public Game(String player)
	{
		this.player = new Player(player);
		this.NPCs = new ArrayList<NPC>();
	}

	/**
	 * The constructor of the game's start
	 *
	 */
	public void start()
	{
		initNPC();

	}

	/**
	 * The constructor of the game's quit
	 *
	 */
	public void Quit()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Initialization of NPC list.
	 */
	public static void initNPC()
	{
		NPCs.add(new NPC("Barry"));
		NPCs.add(new NPC("Matthew"));
		NPCs.add(new NPC("Brad"));
		NPCs.add(new NPC("Bryan"));
		NPCs.add(new NPC("Peter"));
		NPCs.add(new NPC("Jacob"));
		NPCs.add(new NPC("Andrew"));
		NPCs.add(new NPC("Samuel"));
		NPCs.add(new NPC("Thomas"));
		NPCs.add(new NPC("Isaac"));
		NPCs.add(new John());
	}
}

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
	private Player						player;

	/** The game's NPCs */
	private static ArrayList<NPC>		NPCs;

	/** The game's objects */
	private static ArrayList<Object>	Objects;

	/** The game's objects */
	private static ArrayList<Room>		Rooms;

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
		boolean end = false;

		while (!end)
		{
			/* Creation of the objects */
			initObjects();
			/* Creation of the NPCs and fill the NPC's inventory */
			initNPC();
			/* Creation of the rooms and fill the rooms with objects and npcs */
			initRooms();
		}

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

	/**
	 * Initialization of objects list.
	 */
	public static void initObjects()
	{

	}

	/**
	 * Initialization of rooms list.
	 */
	public static void initRooms()
	{

	}
}

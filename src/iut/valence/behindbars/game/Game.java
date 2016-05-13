package iut.valence.behindbars.game;

import iut.valence.behindbars.character.John;
import iut.valence.behindbars.character.NPC;
import iut.valence.behindbars.character.Player;
import iut.valence.behindbars.character.StateOfCharacter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * The game of BehindBars
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Game
{
	/** The game's character */
	private Player player;

	/** The game's NPCs */
	private static Map<String, NPC> NPCs;

	/** The game's objects */
	private static ArrayList<Object> Objects;

	/** The game's objects */
	private static ArrayList<Room> Rooms;

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
		NPCs.put("Barry", new NPC("Garry", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Barry", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Brad", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Bryan", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Alexandro", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Ali", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Carlos", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Calvin", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Daryl", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Drake", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Elvis", StateOfCharacter.Prisoner));
		NPCs.add(new NPC("Fernando", StateOfCharacter.Prisoner));

		NPCs.add(new NPC("Frank", StateOfCharacter.Guard));
		NPCs.add(new NPC("Harrison", StateOfCharacter.Guard));

		NPCs.add(new John());
		NPCs.add(new NPC("Steven", StateOfCharacter.Prisoner));
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
		// Faire un Set
		NPCs.getValue()
		Rooms.add(new Room(name, npcsInRoomList, objectsInRoomList))
	}
}

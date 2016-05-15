package iut.valence.behindbars.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iut.valence.behindbars.character.John;
import iut.valence.behindbars.character.NPC;
import iut.valence.behindbars.character.Player;
import iut.valence.behindbars.character.StateOfCharacter;

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
	private static Map<String, NPC>		NPCs;

	/** The game's objects */
	private static Map<String, Object>	Objects;

	/** The game's objects */
	private static ArrayList<Room>		Rooms;

	/** The constructor of the game in progress */
	public Game(String player)
	{
		this.player = new Player(player);
		this.NPCs = new HashMap<String, NPC>();
		this.Rooms = new ArrayList<Room>();
		this.Objects = new HashMap<String, Object>();

		initNPC();
		initRooms();
	}

	/**
	 * The constructor of the game's start
	 *
	 */
	public void start()
	{
		System.out.println("star");
		// boolean end = false;
		//
		// while (!end)
		// {
		// /* Creation of the objects */
		// initObjects();
		// /* Creation of the NPCs and fill the NPC's inventory */
		// initNPC();
		// /* Creation of the rooms and fill the rooms with objects and npcs */
		// initRooms();
		// }

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
		NPCs.put("Barry", new NPC("Barry", StateOfCharacter.Prisoner));
		NPCs.put("Garry", new NPC("Garry", StateOfCharacter.Prisoner));
		NPCs.put("Brad", new NPC("Brad", StateOfCharacter.Prisoner));
		NPCs.put("Bryan", new NPC("Bryan", StateOfCharacter.Prisoner));
		NPCs.put("Alexandro", new NPC("Alexandro", StateOfCharacter.Prisoner));
		NPCs.put("Ali", new NPC("Ali", StateOfCharacter.Prisoner));
		NPCs.put("Carlos", new NPC("Carlos", StateOfCharacter.Prisoner));
		NPCs.put("Calvin", new NPC("Calvin", StateOfCharacter.Prisoner));
		NPCs.put("Daryl", new NPC("Daryl", StateOfCharacter.Prisoner));
		NPCs.put("Drake", new NPC("Drake", StateOfCharacter.Prisoner));
		NPCs.put("Elvis", new NPC("Elvis", StateOfCharacter.Prisoner));
		NPCs.put("Fernando", new NPC("Fernando", StateOfCharacter.Prisoner));

		NPCs.put("Frank", new NPC("Frank", StateOfCharacter.Guard));
		NPCs.put("Harrison", new NPC("Harrison", StateOfCharacter.Guard));

		NPCs.put("John", new John());
		NPCs.put("Steven", new NPC("Steven", StateOfCharacter.Prisoner));
	}

	/**
	 * Initialization of objects list.
	 */
	public static void initObjects()
	{
		Objects.put("Cut", new Object("Cut", "A cut", 10));

	}

	/**
	 * Initialization of rooms list.
	 */
	public static void initRooms()
	{
		ArrayList<NPC> npcsInCells = new ArrayList<NPC>();

		npcsInCells.add(NPCs.get("Barry"));
		npcsInCells.add(NPCs.get("Garry"));
		npcsInCells.add(NPCs.get("Brad"));
		npcsInCells.add(NPCs.get("Bryan"));
		npcsInCells.add(NPCs.get("Steven"));

		ArrayList<NPC> npcsInCorridor1 = new ArrayList<NPC>();

		npcsInCorridor1.add(NPCs.get("Alexandro"));
		npcsInCorridor1.add(NPCs.get("Ali"));

		ArrayList<NPC> npcsInBreakRoom = new ArrayList<NPC>();

		npcsInBreakRoom.add(NPCs.get("John"));
		npcsInBreakRoom.add(NPCs.get("Carlos"));
		npcsInBreakRoom.add(NPCs.get("Calvin"));
		npcsInBreakRoom.add(NPCs.get("Daryl"));

		ArrayList<NPC> npcsInOutside = new ArrayList<NPC>();

		npcsInOutside.add(NPCs.get("Drake"));
		npcsInOutside.add(NPCs.get("Elvis"));
		npcsInOutside.add(NPCs.get("Fernando"));
		npcsInOutside.add(NPCs.get("Frank"));

		ArrayList<NPC> npcsInCorridor2 = new ArrayList<NPC>();

		npcsInCorridor2.add(NPCs.get("Harrison"));

		Rooms.add(new Room("cells", npcsInCells, objectsInCells));
		Rooms.add(new Room("corridor1", npcsInCorridor1, objectsInCorridor1));
		Rooms.add(new Room("breakRoom", npcsInBreakRoom, objectsInBreakRoom));
		Rooms.add(new Room("outside", npcsInOutside, objectsInOutside));
		Rooms.add(new Room("corridor2", npcsInCorridor2, objectsInCorridor2));

	}
}

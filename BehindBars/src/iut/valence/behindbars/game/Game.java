package iut.valence.behindbars.game;

import java.util.HashMap;
import java.util.Map;

import iut.valence.behindbars.character.NPC;
import iut.valence.behindbars.character.Player;
import iut.valence.behindbars.character.StateOfCharacter;
import iut.valence.behindbars.windows.PositionOnScreen;

/**
 * The game of BehindBars.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Game
{
	/** The game's character */
	private Player				player;

	/** The game's NPCs */
	private Map<String, NPC>	NPCs;
	/** The game's objects */
	private Map<String, Room>	Rooms;

	/** The constructor of the game in progress */
	public Game(String player)
	{
		this.player = new Player(player);
		this.NPCs = new HashMap<String, NPC>();
		this.Rooms = new HashMap<String, Room>();

		initNPC();
		initRooms();

	}

	/**
	 * Initialization of NPC list.
	 */
	public void initNPC()
	{
		NPCs.put("Barry", new NPC("Barry", StateOfCharacter.Prisoner, new PositionOnScreen(300, 50)));
		NPCs.put("Garry", new NPC("Garry", StateOfCharacter.Prisoner, new PositionOnScreen(300, 500)));
		NPCs.put("Brad", new NPC("Brad", StateOfCharacter.Prisoner, new PositionOnScreen(480, 50)));
		NPCs.put("Bryan", new NPC("Bryan", StateOfCharacter.Prisoner, new PositionOnScreen(480, 500)));
		NPCs.put("Alexandro", new NPC("Alexandro", StateOfCharacter.Prisoner, new PositionOnScreen(250, 150)));
		NPCs.put("Ali", new NPC("Ali", StateOfCharacter.Prisoner, new PositionOnScreen(600, 190)));
		NPCs.put("Carlos", new NPC("Carlos", StateOfCharacter.Prisoner, new PositionOnScreen(200, 70)));
		NPCs.put("Calvin", new NPC("Calvin", StateOfCharacter.Prisoner, new PositionOnScreen(720, 130)));
		NPCs.put("Drake", new NPC("Drake", StateOfCharacter.Prisoner, new PositionOnScreen(350, 450)));
		NPCs.put("Drake", new NPC("Daryl", StateOfCharacter.Prisoner, new PositionOnScreen(150, 450)));
		NPCs.put("Elvis", new NPC("Elvis", StateOfCharacter.Prisoner, new PositionOnScreen(200, 120)));
		NPCs.put("Fernando", new NPC("Fernando", StateOfCharacter.Prisoner, new PositionOnScreen(700, 450)));

		NPCs.put("Frank", new NPC("Frank", StateOfCharacter.Guard, new PositionOnScreen(400, 200)));
		NPCs.put("Harrison", new NPC("Harrison", StateOfCharacter.Guard, new PositionOnScreen(200, 200)));

		NPCs.put("John", new NPC("John", StateOfCharacter.Prisoner, new PositionOnScreen(720, 320)));
		NPCs.put("Steven", new NPC("Steven", StateOfCharacter.Prisoner, new PositionOnScreen(50, 50)));

	}

	/**
	 * Initialization of rooms list.
	 */
	public void initRooms()
	{
		Rooms.put("cells", new Room("cells"));
		Rooms.put("corridor", new Room("corridor"));
		Rooms.put("breakroom", new Room("breakroom"));
		Rooms.put("outside", new Room("outside"));
		Rooms.put("infirmary", new Room("infirmary"));
		Rooms.put("maintest", new Room("maintest"));
		Rooms.put("gameoverboard", new Room("gameoverboard"));

	}

	/**
	 * The player's getter.
	 *
	 * @return game's player
	 */
	public Player getPlayer()
	{
		return player;
	}

	/**
	 * The method to add penalty.
	 */
	public void addPenalty()
	{
		int penalty = this.player.getPenalty();
		this.player.setPenalty(penalty + 1);
	}

	/**
	 * The NPC's list getter.
	 *
	 * @return NPC's list
	 */
	public Map<String, NPC> getNPCs()
	{
		return NPCs;
	}

	/**
	 * The Rooms' list =getter.
	 *
	 * @return Rooms' list
	 */
	public Map<String, Room> getRooms()
	{
		return Rooms;
	}

}

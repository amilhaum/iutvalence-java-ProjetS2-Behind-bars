package iut.valence.behindbars.game;

import iut.valence.behindbars.character.Character;
import iut.valence.behindbars.character.John;
import iut.valence.behindbars.character.NPC;
import iut.valence.behindbars.character.Player;
import iut.valence.behindbars.character.StateOfCharacter;
import iut.valence.behindbars.exceptions.InventoryIsFullException;
import iut.valence.behindbars.exceptions.NoNPCInList;
import iut.valence.behindbars.exceptions.ItemNotInInventoryException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The game of BehindBars.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Game
{
	/** The default number of talk with NPC. */
	private static final int DEFAULT_NB_TALK_NPC = 0;

	/** The game's character */
	private Player player;

	/** The game's NPCs */
	private static Map<String, NPC> NPCs;

	/** The game's objects */
	private static Map<String, Item> Items;

	/** The game's objects */
	private static Map<String, Room> Rooms;

	/** The current room. */
	private Room currentRoom;

	/** The number of talk with John. */
	private int nbtalkJohn;

	/** The number of talk with Steven. */
	private int nbtalkSteven;

	/** The constructor of the game in progress */
	public Game(String player)
	{
		this.player = new Player(player);
		this.NPCs = new HashMap<String, NPC>();
		this.Rooms = new HashMap<String, Room>();
		this.Items = new HashMap<String, Item>();

		initNPC();
		initItems();
		initRooms();

		this.nbtalkJohn = DEFAULT_NB_TALK_NPC;
		this.nbtalkSteven = DEFAULT_NB_TALK_NPC;
	}

	/**
	 * The constructor of the game's start
	 *
	 */
	public void start()
	{
		/* current room is the cell where the player start */
		this.currentRoom = this.Rooms.get("cells");
		/* The player is in the cells. */
		this.currentRoom.getNpcsInRoom().add(this.player);
	}

	/**
	 * Method use to speak with different kind, all the possibility of talk are here.
	 * @param npcSelected NPC selected by the user
	 * @param currentRoom The room where the player is
	 */
	//	public Dialogue talkNPCSelected(NPC npcSelected, Room currentRoom)
	//	{
	//
	//		int nbtalkJohn = 0;
	//		int nbtalkSteve = 0;
	//
	//		try
	//		{
	//			getNPCinList(npcSelected.getName(), this.currentRoom.getNpcsInRoom());
	//		}
	//		catch (NoNPCInList e)
	//		{
	//			//Nothing todo...
	//		}
	//
	//		if (npcSelected.getName() != "John" || npcSelected.getName() != "Steven" || npcSelected.state != StateOfCharacter.Guard)
	//		{
	//			return Dialogue.PRISONER;
	//		}
	//
	//		else if (npcSelected.state == StateOfCharacter.Guard && npcSelected.getName() != "Harrison")
	//		{
	//			return Dialogue.GUARD;
	//		}
	//
	//		else if (npcSelected.getName() == "John")
	//		{
	//			if (currentRoom.getName() == "breakRoom")
	//			{
	//				if (nbtalkJohn == 0)
	//				{
	//					nbtalkJohn++;
	//					return Dialogue.JOHN_SALUTATION;
	//				}
	//				else if (nbtalkJohn == 1)
	//				{
	//					return Dialogue.JOHN_COMMON_TALK;
	//				}
	//				else if (player.getInventory().isInInventory(player.getInventory(), "Infirmary's key"))
	//				{
	//					return Dialogue.JOHN_KEY;
	//				}
	//				else if (player.getMoney() >= 50)
	//				{
	//					return Dialogue.JOHN_MONEY;
	//				}
	//				else if (player.getInventory().isInInventory(player.getInventory(), "Infirmary's key") && player.getMoney() >= 50)
	//				{
	//
	//					player.getInventory().removeObject(Objects.get("Infirmary's key"));
	//					player.setMoney(player.getMoney() - 50);
	//					nbtalkJohn = 2;
	//					// TODO john's trust ++ ? J'ai pas acc�s aux m�thodes de John.
	//					// TODO debloquer portes infirmerie apr�s qu�te
	//					return Dialogue.JOHN_QUEST_FULLFIL;
	//				}
	//			}
	//			//			else if (currentRoom.getName() == "Infirmary")
	//			//			{
	//			//				NPCs.get("Harrison").speak(Dialogue.GUARD_CHOICE);
	//			//				if (takeDecision(Dialogue.GUARD_CHOICE1, NPCs.get("Harrison"), 0) == Dialogue.GUARD_RESULT1)
	//			//				{
	//			//					NPCs.get("Harrison").speak(takeDecision(Dialogue.GUARD_CHOICE1, NPCs.get("Harrison"), 0));
	//			//				}
	//			//				else
	//			//				{
	//			//					NPCs.get("Harrison").speak(takeDecision(Dialogue.GUARD_CHOICE2, NPCs.get("Harrison"), 0));
	//			//				}
	//			//
	//			//			}
	//		}
	//		//		else
	//		//		{
	//		//			NPCs.get("Steve").speak(Dialogue.STEVEN_SALUTATION);
	//		//			while (true)
	//		//			{
	//		//				Dialogue riddleChoose;
	//		//
	//		//				if (nbtalkSteve == 0)
	//		//				{
	//		//					riddleChoose = Dialogue.STEVEN_RIDDLE1;
	//		//				}
	//		//				else
	//		//				{
	//		//					riddleChoose = Dialogue.STEVEN_RIDDLE2;
	//		//				}
	//		//
	//		//				NPCs.get("Steve").speak(riddleChoose);
	//		//				Dialogue dialogueChoose = null;
	//		//
	//		//				if (takeDecision(dialogueChoose, NPCs.get("Steve"), nbtalkSteve) == Dialogue.STEVEN_SUCCEED_RIDLLE)
	//		//				{
	//		//					nbtalkSteve++;
	//		//					break;
	//		//				}
	//		//				else if (takeDecision(dialogueChoose, NPCs.get("Steve"), nbtalkSteve) == Dialogue.STEVEN_ERROR_INVENTORY_FULL)
	//		//				{
	//		//					NPCs.get("Steve").speak(Dialogue.STEVEN_ERROR_INVENTORY_FULL);
	//		//					nbtalkSteve = 0;
	//		//					break;
	//		//				}
	//		//				else
	//		//				{
	//		//					npcSelected.speak(Dialogue.STEVEN_FAIL_RIDDLE);
	//		//					continue;
	//		//				}
	//		//			}
	//		//		}
	//		else
	//		{
	//			return Dialogue.END;
	//		}
	//		return null;
	//	}

	/**
	 * Method use for all the decision that take the player.
	 * @param dialogueChoose the answer the player choose
	 * @param npcSelected the NPC concern about the decision
	 * @param nbTalks the number of times the player talk with the NPC
	 * @return the dialogue that result the decision
	 */
	public Dialogue takeDecision(Dialogue dialogueChoose, NPC npcSelected, int nbTalks)
	{

		List<Dialogue> riddle = new ArrayList<Dialogue>();

		if (nbTalks == 0)
		{
			riddle.add(Dialogue.STEVEN_RIDDLE1_ANSWER1);
			riddle.add(Dialogue.STEVEN_RIDDLE1_ANSWER2);
		}
		else
		{
			riddle.add(Dialogue.STEVEN_RIDDLE1_ANSWER1);
			riddle.add(Dialogue.STEVEN_RIDDLE1_ANSWER2);
		}

		if (npcSelected.getName() == "Steve")
		{
			if (dialogueChoose == Dialogue.STEVEN_RIDDLE)
			{
				if (nbTalks == 0)
				{
					if (dialogueChoose == riddle.get(0))
					{
						nbTalks = 1;
						return Dialogue.STEVEN_FAIL_RIDDLE;
					}
					else if (dialogueChoose == riddle.get(1))
					{
						nbTalks = 1;
						return Dialogue.STEVEN_FAIL_RIDDLE;
					}
					else
					{
						try
						{
							NPCs.get("Steve").giveItem(Items.get("Infirmary's key"), player);
						}
						catch (ItemNotInInventoryException e)
						{
							//Nothing to do object give in the initialization

						}
						catch (InventoryIsFullException e)
						{
							return Dialogue.STEVEN_ERROR_INVENTORY_FULL;

						}
						return Dialogue.STEVEN_SUCCEED_RIDLLE;
					}
				}
			}
			else if (dialogueChoose == Dialogue.STEVEN_GAME)
			{
				if (GetRandomResult())
				{
					player.setMoney(player.getMoney() + 25);
					return Dialogue.STEVEN_GAME_WIN;
				}
				else
				{
					return Dialogue.STEVEN_GAME_LOOSE;
				}
			}

		}
		else if (npcSelected == NPCs.get("Harrison"))
		{
			if (dialogueChoose == Dialogue.GUARD_CHOICE1)
			{
				return Dialogue.GUARD_RESULT1;
			}
			else
			{
				//TODO recommencer le jeu
				return Dialogue.GUARD_RESULT2;
			}
		}
		dialogueChoose = Dialogue.QUIT;
		return dialogueChoose;
	}

	// TODO completer methode
	/**
	 * Method call when you end the game by clicking on the sewers.
	 * @param item the sewers
	 */
	public Dialogue endOfGame(Item item)
	{

		return Dialogue.END;
	}

	/**
	 * Method use to know if an Character is on the list given, if he is in return the Character
	 * @param name name of the Character
	 * @param npcList list of NPC
	 * @return the Character ask if is in the list, an error is raised if he's not
	 * @throws NoNPCInList error throws if he's not in the list
	 */
	private static Character getNPCinList(String name, ArrayList<Character> npcList) throws NoNPCInList
	{
		for (int i = 0; i < npcList.size(); i++)
		{
			if (npcList.get(i).getName() == name)
			{
				return npcList.get(i);
			}
		}
		throw new NoNPCInList();
	}

	/**
	 * This method returns a random boolean that can be 70% true and 30% false
	 * That will decide if we have won the minigame of chance or not
	 * @return
	 */
	public boolean GetRandomResult()
	{
		Random rn = new Random();
		int RandomedNumber = rn.nextInt(10) + 1;

		if (RandomedNumber <= 7)
		{
			return true;
		}
		else
		{
			return false;
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
	public static void initItems()
	{

		Items.put("Infirmary's key", new Item("Infirmary's key", "The key of infirmary", 10));

		Items.put("Knife", new Item("Knife", "A knife", 10));
		Items.put("Coffee", new Item("Coffee", "A coffee", 1));

		Items.put("Office", new Item("Office", "A office", 100));
		Items.put("Bin", new Item("Bin", "A bin", 10));
		Items.put("Sewers", new Item("Sewers", "Sewers", 100));
	}

	/**
	 * Initialization of rooms list.
	 */
	public static void initRooms()
	{
		/* List of players by place */

		/* Npcs in cells */
		ArrayList<Character> charactersInCells = new ArrayList<Character>();
		charactersInCells.add(NPCs.get("Barry"));
		charactersInCells.add(NPCs.get("Garry"));
		charactersInCells.add(NPCs.get("Brad"));
		charactersInCells.add(NPCs.get("Bryan"));
		charactersInCells.add(NPCs.get("Steven"));

		/* Npc in the first corridor */
		ArrayList<Character> charactersInCorridor1 = new ArrayList<Character>();
		charactersInCorridor1.add(NPCs.get("Alexandro"));
		charactersInCorridor1.add(NPCs.get("Ali"));

		/* Npc in the break room */
		ArrayList<Character> charactersInBreakRoom = new ArrayList<Character>();
		charactersInBreakRoom.add(NPCs.get("John"));
		charactersInBreakRoom.add(NPCs.get("Carlos"));
		charactersInBreakRoom.add(NPCs.get("Calvin"));
		charactersInBreakRoom.add(NPCs.get("Daryl"));

		/* Npc outside */
		ArrayList<Character> charactersInOutside = new ArrayList<Character>();
		charactersInOutside.add(NPCs.get("Drake"));
		charactersInOutside.add(NPCs.get("Elvis"));
		charactersInOutside.add(NPCs.get("Fernando"));
		charactersInOutside.add(NPCs.get("Frank"));

		/* Npc in the infirmary */
		ArrayList<Character> npcsInInfirmary = new ArrayList<Character>();
		npcsInInfirmary.add(NPCs.get("Harrison"));

		/* List of objects by place */

		/* Objects in the cells */
		ArrayList<Item> objectsInCells = new ArrayList<Item>();
		objectsInCells.add(Items.get("Infirmary's key"));

		/* Objects in the Break Room */
		ArrayList<Item> objectsInBreakRoom = new ArrayList<Item>();
		objectsInBreakRoom.add(Items.get("Coffee"));
		objectsInBreakRoom.add(Items.get("Knife"));

		/* Objects in the infirmary */
		ArrayList<Item> objectsInInfirmary = new ArrayList<Item>();
		objectsInInfirmary.add(Items.get("Office"));
		objectsInInfirmary.add(Items.get("Bin"));
		objectsInInfirmary.add(Items.get("Sewers"));

		Rooms.put("cells", new Room("cells", charactersInCells, objectsInCells));
		Rooms.put("corridor1", new Room("corridor1", charactersInCorridor1));
		Rooms.put("breakRoom", new Room("breakRoom", charactersInBreakRoom, objectsInBreakRoom));
		Rooms.put("outside", new Room("outside", charactersInOutside));
		Rooms.put("infirmary", new Room("infirmary", npcsInInfirmary, objectsInInfirmary));

	}

	public Player getPlayer()
	{
		return player;
	}

	public static Map<String, Item> getItems()
	{
		return Items;
	}

	public void addPenalty()
	{
		int penalty = this.player.getPenalty();
		this.player.setPenalty(penalty + 50);
	}

	public int getNbtalkJohn()
	{
		return nbtalkJohn;
	}

	public int getNbtalkSteven()
	{
		return nbtalkSteven;
	}

	public static Map<String, NPC> getNPCs()
	{
		return NPCs;
	}

	public static Map<String, Room> getRooms()
	{
		return Rooms;
	}

	public void updateJohnTalk()
	{
		this.nbtalkJohn++;
	}

	public void updateStevenTalk()
	{
		this.nbtalkSteven++;
	}
}

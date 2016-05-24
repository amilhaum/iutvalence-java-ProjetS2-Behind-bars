package iut.valence.behindbars.game;

import iut.valence.behindbars.character.Character;
import iut.valence.behindbars.character.John;
import iut.valence.behindbars.character.NPC;
import iut.valence.behindbars.character.Player;
import iut.valence.behindbars.character.StateOfCharacter;
import iut.valence.behindbars.exceptions.InventoryIsFullException;
import iut.valence.behindbars.exceptions.NoNPCInList;
import iut.valence.behindbars.exceptions.ObjectNotInInventoryException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	private static Map<String, Object> Objects;

	/** The game's objects */
	private static Map<String, Room> Rooms;

	private Room currentRoom;

	/** The constructor of the game in progress */
	public Game(String player)
	{
		this.player = new Player(player);
		this.NPCs = new HashMap<String, NPC>();
		this.Rooms = new HashMap<String, Room>();
		this.Objects = new HashMap<String, Object>();
		

		initNPC();
		initObjects();
		initRooms();

		

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
	public void talkNPCSelected(NPC npcSelected, Room currentRoom){
		
		int nbtalkJohn=0; // pour voir le nombre de fois o� on lui parl�
		
		try
		{
			//TODO npcSelected = on click
			getNPCinList(npcSelected.getName(), this.currentRoom.getNpcsInRoom());
		}
		catch (NoNPCInList e)
		{
			//Nothing todo...
		}

		if (npcSelected.getName() != "John" || npcSelected.getName() != "Steven" || npcSelected.state!=StateOfCharacter.Guard)
		{
			npcSelected.speak(Dialogue.PRISONNER);
		}
		
		else if(npcSelected.state==StateOfCharacter.Guard){
			npcSelected.speak(Dialogue.GUARD);
		}

		else if (npcSelected.getName() == "John")
		{
			if(currentRoom.getName()=="breakRoom"){
				if(nbtalkJohn==0){
					NPCs.get("John").speak(Dialogue.JOHN_SALUTATION);
					nbtalkJohn++;
				}
				else if(nbtalkJohn==1){
					NPCs.get("John").speak(Dialogue.JOHN_COMMON_TALK);
				}
				else if(player.getInventory().isInInventory(player.getInventory(), "Infirmary's key")){
					NPCs.get("John").speak(Dialogue.JOHN_KEY);
				}
				else if(player.getMoney()>=50){
					NPCs.get("John").speak(Dialogue.JOHN_MONEY);
				}
				else if(player.getInventory().isInInventory(player.getInventory(), "Infirmary's key") && player.getMoney()>=50){
					NPCs.get("John").speak(Dialogue.JOHN_QUEST_FULLFIL);
					player.getInventory().removeObject(Objects.get("Infirmary's key"));
					player.setMoney(player.getMoney()-50);
					nbtalkJohn=2;
					//TODO john's trust ++?
				}
			}
		}
		else
		{
			NPCs.get("Steve").speak(Dialogue.STEVE_SALUTATION);
			while(true){
				NPCs.get("Steve").speak(Dialogue.STEVE_RIDDLE);
				
				if(/* condition de succes ?*/){
					break;
				}
				else if(/*le joueur quitte la conversation*/){
					
				}
				else{
					npcSelected.speak(Dialogue.STEVE_FAIL_RIDDLE);
					continue;
				}
			}
		
			
			//TODO steven speak (tu veux des clefs pour la salle ? resoudre l'enigme en selectionnant le bon objet)
			//TODO appelle method
		}
	}
	
	public Dialogue takeDecision(Dialogue dialogueChoose, NPC npcSelected){
		if(npcSelected.getName()=="Steve"){
			if(dialogueChoose==Dialogue.STEVE_RIDLLE_ANSWER1){
				return Dialogue.STEVE_FAIL_RIDDLE;
			}
			else if(dialogueChoose==Dialogue.STEVE_RIDDLE_ANSWER2){
				return Dialogue.STEVE_FAIL_RIDDLE;
			}
			else{
				try {
					NPCs.get("Steve").giveObject(Objects.get("Infirmary's key"), player);
				} catch (ObjectNotInInventoryException e) {
					//Nothing to do object give in the initialisation

				} catch (InventoryIsFullException e) {
					NPCs.get("Steve").speak(Dialogue.STEVE_ERROR_INVENTORY_FULL);

				}
				return Dialogue.STEVE_SUCCEED_RIDDLE;
			}
		}
		else if(npcSelected.getName()=="John"){
			//TODO d�cison garde avec john
			
		}
		return dialogueChoose;//TODO � virer
		
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

		Objects.put("Infirmary's key", new Object("Infirmary's key", "The key of infirmary", 10));

		Objects.put("Knife", new Object("Knife", "A knife", 10));
		Objects.put("Coffee", new Object("Coffee", "A coffee", 1));

		Objects.put("Office", new Object("Office", "A office", 100));
		Objects.put("Bin", new Object("Bin", "A bin", 10));
		Objects.put("Sewers", new Object("Sewers", "Sewers", 100));
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
		ArrayList<Object> objectsInCells = new ArrayList<Object>();
		objectsInCells.add(Objects.get("Infirmary's key"));

		/* Objects in the Break Room */
		ArrayList<Object> objectsInBreakRoom = new ArrayList<Object>();
		objectsInBreakRoom.add(Objects.get("Coffee"));
		objectsInBreakRoom.add(Objects.get("Knife"));

		/* Objects in the infirmary */
		ArrayList<Object> objectsInInfirmary = new ArrayList<Object>();
		objectsInInfirmary.add(Objects.get("Office"));
		objectsInInfirmary.add(Objects.get("Bin"));
		objectsInInfirmary.add(Objects.get("Sewers"));

		Rooms.put("cells", new Room("cells", charactersInCells, objectsInCells));
		Rooms.put("corridor1", new Room("corridor1", charactersInCorridor1));
		Rooms.put("breakRoom", new Room("breakRoom", charactersInBreakRoom, objectsInBreakRoom));
		Rooms.put("outside", new Room("outside", charactersInOutside));
		Rooms.put("infirmary", new Room("infirmary", npcsInInfirmary, objectsInInfirmary));

	}


}

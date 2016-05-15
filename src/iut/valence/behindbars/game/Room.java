package iut.valence.behindbars.game;

import java.util.ArrayList;

import iut.valence.behindbars.character.NPC;

/**
 * The rooms of the game.
 *
 * @author BehindBars
 * @version 1.0.0
 */
public class Room
{
	/** The room's name. */
	private String				name;

	/** The npc's list in the room. */
	private ArrayList<NPC>		npcsInRoom;

	/** The object's list in the room. */
	private ArrayList<Object>	objectsInRoom;

	/**
	 * The room's constructor.
	 *
	 * @param name
	 *            is the room's name
	 * @param npcsInRoomList
	 *            is the npc's list in the room
	 * @param objectsInRoomList
	 *            object's list in the room
	 */
	public Room(String name, ArrayList<NPC> npcsInRoomList, ArrayList<Object> objectsInRoomList)
	{
		this.name = name;
		this.npcsInRoom = npcsInRoomList;
		this.objectsInRoom = objectsInRoomList;

	}

	/**
	 * The name's getter
	 * 
	 * @return the room's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * The name's getter
	 * 
	 * @return the room's name
	 */
	public ArrayList<NPC> getNpcsInRoom()
	{
		return npcsInRoom;
	}

	/**
	 * The object's list getter
	 * 
	 * @return the object's list of the room
	 */
	// public ArrayList<Object> getObjectsInRoom()
	// {
	// return objectsInRoom;
	// }

}

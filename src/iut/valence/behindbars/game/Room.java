package iut.valence.behindbars.game;

import iut.valence.behindbars.character.Character;

import java.util.ArrayList;

/**
 * The rooms of the game
 *
 * @author BehindBars
 * @version 1.0.0
 */
public class Room
{
	/** The room's name. */
	private String name;

	/** The npc's list in the room. */
	private ArrayList<Character> npcsInRoom;

	/** The object's list in the room. */
	private ArrayList<Item> itemsInRoom;

	/**
	 * The room's constructor.
	 *
	 * @param name
	 *            is the room's name
	 * @param charactersInCells
	 *            is the npc's list in the room
	 * @param itemsInRoomList
	 *            object's list in the room
	 */
	public Room(String name, ArrayList<Character> charactersInCells, ArrayList<Item> itemsInRoomList)
	{
		this.name = name;
		this.npcsInRoom = charactersInCells;
		this.itemsInRoom = itemsInRoomList;
	}

	/**
	 *
	 * @param name
	 *            is the room's name
	 * @param npcsInRoomList
	 *            is the npc's list in the room
	 */
	public Room(String name, ArrayList<Character> npcsInRoomList)
	{
		this.name = name;
		this.npcsInRoom = npcsInRoomList;
		this.itemsInRoom = null;

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
	public ArrayList<Character> getNpcsInRoom()
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

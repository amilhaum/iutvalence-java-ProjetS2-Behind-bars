package iut.valence.behindbars.game;

import javax.swing.ImageIcon;

/**
 * The rooms of the game
 *
 * @author BehindBars
 * @version 1.0.0
 */
public class Room
{
	/** The room's name. */
	private ImageIcon	picture;
	private String		name;

	/**
	 * The room's constructor.
	 *
	 * @param name is the room's name
	 * @param charactersInCells is the npc's list in the room
	 * @param itemsInRoomList object's list in the room
	 */
	public Room(String name)
	{
		if (name == "cells")
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/cell.png"));
		}
		else if (name == "corridor")
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/corridor.png"));
		}
		else if (name == "breakroom")
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/breakroom.png"));
		}
		else if (name == "outside")
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/outside.png"));
		}
		else if (name == "infirmary")
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/infirmaryBackground2.jpg"));
		}
		else if (name == "maintest")
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/maintest.png"));
		}
		else
		{
			this.picture = new ImageIcon(getClass().getResource("/pictures/gameoverboard.png"));
		}
		this.name = name;

	}

	/**
	 * The picture's getter
	 *
	 * @return the picture's name
	 */
	public ImageIcon getPicture()
	{
		return picture;
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

}

package iut.valence.behindbars.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The objects of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Item
{
	/** The object's name */
	protected String		name;

	/** The object's description */
	protected String		description;

	/** The object's value */
	protected int			value;

	protected MouseListener	itemActionListener;

	/**
	 * The constructor of the object
	 *
	 * @param name
	 *            is object's name
	 * @param description
	 *            is the object's description
	 * @param value
	 *            is the object's value
	 */
	public Item(String name, String description, int value)
	{
		this.name = name;
		this.description = description;
		this.value = value;

		this.itemActionListener = new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				// TODO Auto-generated method stub
				System.out.println("ITEM USED: " + name);
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub

			}
		};
	}

	/**
	 *
	 * @return the object's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *
	 * @return the object's description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 *
	 * @return the object's value
	 */
	public int getValue()
	{
		return value;
	}

}
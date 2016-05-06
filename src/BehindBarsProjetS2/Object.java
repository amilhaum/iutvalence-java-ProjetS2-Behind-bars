package BehindBarsProjetS2;

/**
 * The objects of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Object
{
	/** The object's name */
	protected String	name;

	/** The object's description */
	protected String	description;

	/** The object's value */
	protected int		value;

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
	public Object(String name, String description, int value)
	{
		this.name = name;
		this.description = description;
		this.value = value;
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
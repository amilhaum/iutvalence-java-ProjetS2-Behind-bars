package iut.valence.behindbars.game;

/**
 * The tools of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class Tool extends Item
{
	/** The tool's state */
	protected State state;

	/**
	 * The constructor of the tool
	 * 
	 * @param name
	 *            is the tool's name
	 * @param description
	 *            is the tool's description
	 * @param value
	 *            is the tool's value
	 * @param state
	 *            is the tool's state
	 */
	public Tool(String name, String description, int value, State state)
	{
		super(name, description, value);
		this.state = state;
	}

	/**
	 * 
	 * @return the tool's state
	 */
	public State getState()
	{
		return this.state;
	}

	/**
	 * 
	 */
	public void operation()
	{
		throw new UnsupportedOperationException();
	}

}
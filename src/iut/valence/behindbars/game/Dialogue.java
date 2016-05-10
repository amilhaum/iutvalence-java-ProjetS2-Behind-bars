package iut.valence.behindbars.game;

/**
 * The dialogue enumeration which contains all necessary dialogues of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum Dialogue
{
	HI("Hi bro, what's up ?"); // it's a test

	private String name = "";

	/** Create a dialogue with it's name. */
	Dialogue(String s)
	{
		name = s;
	}

	/**
	 * 
	 * @return the dialogue asked
	 */
	@Override
	public String toString()
	{
		return name;
	}

}
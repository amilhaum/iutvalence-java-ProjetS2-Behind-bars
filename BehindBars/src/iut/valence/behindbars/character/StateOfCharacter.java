package iut.valence.behindbars.character;
/**
 * The state's enum of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum StateOfCharacter
{

	Guard("Guard"), Prisoner("Prisoner");

	private String name = "";

	/** Create a dialogue with it's name */
	StateOfCharacter(String s)
	{
		name = s;
	}

	/**
	 *
	 * @return the dialogue asked
	 */
	@Override public String toString()
	{
		return name;
	}
}

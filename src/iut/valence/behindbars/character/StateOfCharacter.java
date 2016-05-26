package iut.valence.behindbars.character;

public enum StateOfCharacter
{

	Guard("Guard"), Prisoner("Prisoner");

	private String name = "";

	/** Create a dialogue with it's name. */
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

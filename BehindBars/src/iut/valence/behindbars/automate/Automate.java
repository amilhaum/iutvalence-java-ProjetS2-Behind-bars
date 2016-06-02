package iut.valence.behindbars.automate;

public enum Automate
{
	/* On peut se balader, pas de quete pas de clef */
	CELLS_BEGIN("CELLS_BEGIN"),
	CELLS_QUEST_FINISH("CELLS_QUEST_FINISH"),
	CELLS_NOKEY_QUEST_STATE0("CELLS_NOKEY_QUEST_STATE0"),

	BREAKROOM("BREAKROOM"),

	CORRIDOR("CORRIDOR"),
	OUTSIDE("OUTSIDE"),

	INFIRMARY(""),

	THE_END("THE_END");


	private String name = "";

	/** Create a dialogue with it's name. */
	Automate(String s)
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

package iut.valence.behindbars.automate;
/*
 * @author Group Behind Bars
 * @version 1.0.0
 */
public enum Automate
{
	/* Beginning of the game, no quests, just walking */
	CELLS_BEGIN("CELLS_BEGIN"),
	CELLS_QUEST_FINISH("CELLS_QUEST_FINISH"),
	CELLS_NOKEY_QUEST_STATE0("CELLS_NOKEY_QUEST_STATE0"),

	BREAKROOM("BREAKROOM"),

	CORRIDOR("CORRIDOR"),
	OUTSIDE("OUTSIDE"),

	INFIRMARY(""),

	THE_END("THE_END");


	private String name = "";

	/** Create a dialogue with his name. */
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
	/* 
	 * @return the name of the character
	 */
}

package iut.valence.behindbars.automate;
/**
 * The automate of the game.
 * 
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

	/**
	 * Create a dialogue with his name.
	 * 
	 * @return the dialogue asked
	 */
	Automate(String s)
	{
		name = s;
	}

	/**
	 * The method to display the name
	 * 
	 * @return name is the name of the automate 
	 */
	@Override public String toString()
	{
		return name;
	}

}

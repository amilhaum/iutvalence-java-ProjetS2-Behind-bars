package iut.valence.behindbars.game;

/**
 * The dialogue enumeration which contains all necessary dialogues of the game
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum Dialogue
{
	PRISONNER("What do you want I don't know you, clear off"), 
	GUARD("Prisoners are not allow to talk with guard"),
	
	
	JOHN_SALUTATION("Hi I'm John, I know everyone here, I need trust worthy people to set up a plan to escape, if you bring me 50$ and the key of the doors, you're in"),
	JOHN_COMMON_TALK("Bring me the key and the 50 bucks then we could move on"),
	JOHN_KEY("Good you bring me the key, I still need 50 bucks for ... err it's doesn't matter"),
	JOHN_MONEY("Good you bring me the money I need for ... err personal matters"),
	JOHN_QUEST_FULLFIL("Perfect you're fast I like that, now we can continue, freedom is close comrade"),
	
	STEVE_SALUTATION("you're the new one right ? what do you want ?"),
	STEVE_RIDDLE(""), //TODO find a riddle and how drag and drop object
	STEVE_FAIL_RIDDLE("That was not the right answer you may try again but beware I'm not know for my patience"),
	STEVE_RIDLLE_ANSWER1(""),
	STEVE_RIDDLE_ANSWER2(""),
	STEVE_DIDDLE_ANSWER_TRUE(""),
	STEVE_SUCCEED_RIDDLE("That was the correct answer you earn this"),
	STEVE_ERROR_INVENTORY_FULL("Your inventory seems full make some space then come back to me again");
	
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
	@Override public String toString()
	{
		return name;
	}

}
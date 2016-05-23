package iut.valence.behindbars.game;

/**
 * The dialogue enumeration which contains all necessary dialogues of the game
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum Dialogue
{
	PRISONNER("Get the f*** off !"), // it's a test
	
	
	JOHN_SALUTATION("Hi I'm John, I know everyone here, I need trust worthy people to set up a plan to escape, if you bring me 50$ and the key of the doors, you're in"),
	JOHN_COMMON_TALK("Bring me the key and the 50 bucks then we could move on"),
	JOHN_KEY("Good you bring me the key, I still need 50 bucks for ... err it's doesn't matter"),
	JOHN_MONEY("Good you bring me the money I need for ... err personal matters"),
	JOHN_QUEST_FULLFIL("Perfect you're fast I like that, now we can continue, freedom is close comrade"),
	STEVE_SALUTATION("you're the new one right ? what do you want ?"),
	STEVE_RIDDLE(""); //TODO find a riddle and how drag and drop object
	
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
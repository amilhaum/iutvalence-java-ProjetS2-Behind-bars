package iut.valence.behindbars.game;

/**
 * The dialogue enumeration which contains all necessary dialogues of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum Dialogue
{
	PRISONER("PRISONER \nWhat do you want I don't know you, clear off"),
	GUARD("GUARD \nPrisoners are not allow to talk with guard"),

	JOHN_SALUTATION("JOHN \nHi I'm John, I know everyone here, I need trust worthy people to set up a plan to escape, if you bring me the key of the doors, you're in"), 
	JOHN_COMMON_TALK("JOHN \nBring me the key then we could move on"), 
	JOHN_QUEST_FULLFIL("JOHN \nPerfect you're fast I like that, now we can continue, freedom is close comrade"),
	JOHN_QUEST_END("Let's move on !"),
	
	STEVEN_SALUTATION("STEVEN \nJohn told me about you, do you want a key ?"),
	STEVEN_FAIL_RIDDLE("STEVEN \nThat was not the right answer you may try again but beware I'm not know for my patience"), 
	STEVEN_SUCCEED_RIDLLE("STEVEN \nThat was the correct answer you earn this"), 

	STEVEN_RIDDLE("STEVEN \nYou want the key ? you need to solve this riddle"), 
	STEVEN_RIDDLE1("STEVEN \nOk, solve this : What's at the beginning of eternity, at the end of space and time, at the middle of the universe?"), // TODO find a riddle

	GUARD_CHOICE("A guard is in the infirmary, you have two choice, kill him or knock him"), 
	GUARD_RESULT1("The guard is stunned\n\nFind a way out on this map"), 


	FAIL("GAME OVER \nIt was the wrong answer"),
	FAILDOOR("GAME OVER \nYou opened the guards' room, they caught you "), 
	FAILGUARD("GAME OVER \nJohn was afraid !\nHe warned the guards ! "),
	LOCKDOOR("The door is close."), 
	STEVEN_FINISH("STEVEN \nUsually nobody solves this riddle"),

	KEY("You won the infirmary's key !"),
	QUIT("Quit"),
	END("You find a way through the sewers and see a light far away. You find yourself not far away of the prison, you can hear the scream due to the fire and your escape, you're free ...");

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

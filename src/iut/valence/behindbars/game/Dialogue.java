package iut.valence.behindbars.game;

/**
 * The dialogue enumeration which contains all necessary dialogues of the game.
 *
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum Dialogue
{
	PRISONER("PRISONER : What do you want I don't know you, clear off"), GUARD("GUARD : Prisoners are not allow to talk with guard"),

	JOHN_SALUTATION("JOHN : Hi I'm John, I know everyone here, I need trust worthy people to set up a plan to escape, if you bring me 50$ and the key of the doors, you're in"), JOHN_COMMON_TALK(
			"JOHN : Bring me the key and the 50 bucks then we could move on"), JOHN_KEY("JOHN : Good you bring me the key, I still need 50 bucks for ... err it's doesn't matter"), JOHN_MONEY(
			"JOHN : Good you bring me the money I need for ... err personal matters"), JOHN_QUEST_FULLFIL("JOHN : Perfect you're fast I like that, now we can continue, freedom is close comrade"),

	STEVEN_SALUTATION("STEVEN : John told me about you, do you want a key ?"), STEVEN_FAIL_RIDDLE("STEVEN : That was not the right answer you may try again but beware I'm not know for my patience"), STEVEN_SUCCEED_RIDLLE(
			"STEVEN : That was the correct answer you earn this"), STEVEN_ERROR_INVENTORY_FULL("STEVEN : Your inventory seems full make some space then come back to me again"),

	STEVEN_RIDDLE("STEVEN : You want the key ? you need to solve this riddle"), STEVEN_GAME("STEVEN : You want to win money ? Come and play with me"), STEVEN_GAME_WIN(
			"STEVEN : You win this round newbie, here take 25$"), STEVEN_GAME_LOOSE("STEVEN : You loose this one, meet me in the shower tonight"),

	STEVEN_RIDDLE1("STEVEN : Ok, solve this : What's at the beginning of eternity, at the end of space and time, at the middle of the universe?"), //TODO find a riddle

	GUARD_CHOICE("A guard is in the infirmary, you have two choice, kill him or knock him"), GUARD_CHOICE1("Knock him ?(could fail)"), GUARD_CHOICE2("Kill him ?"), GUARD_RESULT1(
			"The guard fall, stunned"), GUARD_RESULT2("The guard fall, you are cover with blood"),

	FAILDOOR("You opened the guards' room, they caught you "), LOCKDOOR("The door is close."),

	KEY("You won the infirmary's key !"), QUIT("Quit"), END(
			"You find a way through the sewers and see a light far away. You find yourself not far away of the prison, you can hear the scream due to the fire and your escape, you're free ...");

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
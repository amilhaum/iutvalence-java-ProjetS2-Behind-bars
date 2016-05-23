package iut.valence.behindbars.character;

import iut.valence.behindbars.game.Dialogue;


public class John extends NPC
{
	private static final int DEFAULT_TRUST = 0;
	private int trust;

	public John()
	{
		super("John", StateOfCharacter.Prisoner);
		this.trust = DEFAULT_TRUST;
	}

	public void knockOut()
	{
		//end of game
		//increment the prison sentence counter (the score increases, and the aim is to get the smallest score)
	}

}

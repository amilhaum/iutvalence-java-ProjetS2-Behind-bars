package iut.valence.behindbars.character;

import iut.valence.behindbars.game.Dialogue;


public class John extends NPC
{
	/** Basic trust of the Character */
	private static final int DEFAULT_TRUST = 0;
	
	/** Actual trust of the character */
	private int trust;

	public John()
	{
		super("John", StateOfCharacter.Prisoner);
		this.trust = DEFAULT_TRUST;
	}
	

	public int getTrust() {
		return trust;
	}



	public void setTrust(int trust) {
		this.trust = trust;
	}



	public void knockOut()
	{
		//end of game
		//increment the prison sentence counter (the score increases, and the aim is to get the smallest score)
	}

}

package iut.valence.behindbars.character;

public class John extends NPC
{
	private static final int DEFAULT_TRUST = 0;
	private int trust;

	public John()
	{
		super("John");
		this.trust = DEFAULT_TRUST;
	}

	public void knockOut()
	{
		//end of game
	}
}

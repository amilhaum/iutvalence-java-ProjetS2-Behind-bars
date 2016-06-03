package iut.valence.behindbars.automate;
/*
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum QuestAutomate
{
	NOQUEST("NOQUEST"), QUESTST0("QUESTST0"), QUESTST1("QUESTST1"), QUESTSTFINISH("QUESTSTFINISH"), GUARDFINISH("GUARDFINISH");

	private String name = "";

	/** Create a dialogue with his name. */
	QuestAutomate(String s)
	{
		name = s;
	}

	/**
	 *
	 * @return the dialogue asked
	 */
	@Override
	public String toString()
	{
		return name;
	}
	/**
	 *
	 * @return the name of the character
	 */
}

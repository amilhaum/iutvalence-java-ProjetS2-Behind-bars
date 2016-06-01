package iut.valence.behindbars.automate;

public enum QuestAutomate
{
	NOQUEST("NOQUEST"), QUESTST0("QUESTST0"), QUESTST1("QUESTST1"), QUESTSTFINISH("QUESTSTFINISH");

	private String name = "";

	/** Create a dialogue with it's name. */
	QuestAutomate(String s)
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

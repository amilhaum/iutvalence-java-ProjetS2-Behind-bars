package iut.valence.behindbars.automate;
/**
 * The quest automate of the game.
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public enum QuestAutomate
{
	NOQUEST("NOQUEST"), QUESTST0("QUESTST0"), QUESTST1("QUESTST1"), QUESTSTFINISH("QUESTSTFINISH"), GUARDFINISH("GUARDFINISH");

	private String name = "";

	/**
	 * Create a dialogue with his name.
	 * 
	 * @return the dialogue asked
	 */
	QuestAutomate(String s)
	{
		name = s;
	}

	/**
	 * The method to display the name
	 * 
	 * @return name is the name of the quest automate 
	 */
	public String toString()
	{
		return name;
	}

}

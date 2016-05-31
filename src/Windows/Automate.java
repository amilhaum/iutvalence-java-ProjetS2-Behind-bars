package Windows;

public enum Automate
{
	/* On peut se balader, pas de quete pas de clef */
	CELLS_BEGIN("CELLS_BEGIN"),
	CORRIDOR_NOKEY_NOQUEST("CORRIDOR_NOKEY_NOQUEST"),
	OUTSIDE_NOKEY_NOQUEST("OUTSIDE_NOKEY_NOQUEST"),
	BREAKROOM_NOKEY_NOQUEST("BREAKROOM_NOKEY_NOQUEST"),
	
	/* On peut se balader,on a parler a John, la quete est lancée, pas de clef */
	BREAKROOM_NOKEY_QUEST_STATE0("BREAKROOM_NOKEY_QUEST_STATE0"),
	CELLS_NOKEY_QUEST_STATE0("CELLS_NOKEY_QUEST_STATE0"),
	CORRIDOR_NOKEY_QUEST_STATE0("CORRIDOR_NOKEY_QUEST_STATE0"),
	OUTSIDE_NOKEY_QUEST_STATE0("OUTSIDE_NOKEY_QUEST_STATE0"),
	
	/* On peut se balader,on a parler a John, la quete est lancée, pas de clefs */
	/* on parle a Steven qui nous demande si on veut faire une enigme */
	/* Si on repond oui, STATE2 sinon on reste STATE1*/
	BREAKROOM_NOKEY_QUEST_STATE1("BREAKROOM_NOKEY_QUEST_STATE1"),
	CELLS_NOKEY_QUEST_STATE1("CELLS_NOKEY_QUEST_STATE1"),
	CORRIDOR_NOKEY_QUEST_STATE1("CORRIDOR_NOKEY_QUEST_STATE1"),
	OUTSIDE_NOKEY_QUEST_STATE1("OUTSIDE_NOKEY_QUEST_STATE1"),
	
	/* On peut se balader,on a parler a John, la quete est lancée, pas de clefs */
	/* on parle a Steven qui nous dit l'enigme */
	/* Si on repond juste, STATE3 (avec key) sinon on retourne STATE1*/
	BREAKROOM_NOKEY_QUEST_STATE2("BREAKROOM_NOKEY_QUEST_STATE2"),
	CELLS_NOKEY_QUEST_STATE2("CELLS_NOKEY_QUEST_STATE2"),
	CORRIDOR_NOKEY_QUEST_STATE2("CORRIDOR_NOKEY_QUEST_STATE2"),
	OUTSIDE_NOKEY_QUEST_STATE2("OUTSIDE_NOKEY_QUEST_STATE2"),
	
	/* On peut se balader,on a parler a John, la quete est lancée,on a les clefs */
	/* on a parle a Steven, on a reussi l'enigme*/
	BREAKROOM_KEY_QUEST_STATE3("BREAKROOM_KEY_QUEST_STATE3"),
	CELLS_KEY_QUEST_STATE3("CELLS_KEY_QUEST_STATE3"),
	CORRIDOR_KEY_QUEST_STATE3("CORRIDOR_KEY_QUEST_STATE3"),
	OUTSIDE_KEY_QUEST_STATE3("OUTSIDE_KEY_QUEST_STATE3"),
	
	/* On peut se balader,on a parler a John, la quete est TERMINEE,on a les clefs */
	/* la porte de l'infirmerie s'ouvre*/
	BREAKROOM_KEY_QUEST_FINISHED("BREAKROOM_KEY_QUEST_FINISHED"),
	CELLS_KEY_QUEST_FINISHED("CELLS_KEY_QUEST_FINISHED"),
	CORRIDOR_KEY_QUEST_FINISHED("CORRIDOR_KEY_QUEST_FINISHED"),
	OUTSIDE_KEY_QUEST_FINISHED("OUTSIDE_KEY_QUEST_FINISHED"),
	INFIRMARY_KEY_QUEST_FINISHED("INFIRMARY_KEY_QUEST_FINISHED"),
	
	/* On a le choix de tuer le garde ou de l'assomer*/
	/*Si on le tue, on repart a CELLS_BEGIN*/
	/*Si on l'assome on va a KEY_QUEST_FINISHED_GUARDOK*/
	BREAKROOM_KEY_QUEST_FINISHED_GUARDOK("BREAKROOM_KEY_QUEST_FINISHED_GUARDOK"),
	CELLS_KEY_QUEST_FINISHED_GUARDOK("CELLS_KEY_QUEST_FINISHED_GUARDOK"),
	CORRIDOR_KEY_QUEST_FINISHED_GUARDOK("CORRIDOR_KEY_QUEST_FINISHED_GUARDOK"),
	OUTSIDE_KEY_QUEST_FINISHED_GUARDOK("OUTSIDE_KEY_QUEST_FINISHED_GUARDOK"),
	INFIRMARY_KEY_QUEST_FINISHED_GUARDOK("INFIRMARY_KEY_QUEST_FINISHED_GUARDOK"),
	
	/*Si on clique sur la bouche d'égout apres le dragndrop on va sur etat THE_END*/
	/*Si on clique sur la salle des guards on repart a CELLS_BEGIN*/
	THE_END("THE_END");
	



	private String name = "";

	/** Create a dialogue with it's name. */
	Automate(String s)
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
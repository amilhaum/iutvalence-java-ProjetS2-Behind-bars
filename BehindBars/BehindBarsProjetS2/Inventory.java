package BehindBarsProjetS2;

import java.util.Collection;

public class Inventory
{

	private final static int	DEFAULT_MAX_SQUARE_INVENTORY	= 10;
	private Collection<Object>	lesObjets;
	private int					nbSquaresUsed				= 0;

	public boolean isFull()
	{
		return nbSquaresUsed == DEFAULT_MAX_SQUARE_INVENTORY;
	}

}
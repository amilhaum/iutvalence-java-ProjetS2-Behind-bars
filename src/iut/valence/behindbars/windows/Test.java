package iut.valence.behindbars.windows;

import javax.swing.JFrame;

import iut.valence.behindbars.game.Inventory;
import iut.valence.behindbars.game.Item;

public class Test
{

	public static void main(String[] args)
	{
		/**
		 * This is just a test, we will remove it later.
		 */
		Inventory inventaire = new Inventory(10);
		Item item1 = new Item("cle en or", "ben elle est en or et c'est une clé", 9000);
		inventaire.addItem(item1);
		
		JFrame windows = new MainWindows();
	}
}

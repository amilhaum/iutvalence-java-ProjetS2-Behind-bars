package iut.valence.behindbars.game;

import java.util.Scanner;

/**
 * The main of the game
 * 
 * @author Group BehindBars
 * @version 1.0.0
 */
public class BehindBars
{

	public static void main(String[] args)
	{
		/**
		 * The game menu that allow us to start the game with a named caracter  
		 */
		while (true)
		{

			Scanner in = new Scanner(System.in);
			int choice;
			while (true)
			{

				System.out.println("\n-Main-\n");
				System.out.println("1 - New game\n2 - Quit\n");
				System.out.println("Your choice :");

				choice = in.nextInt();
				if (choice == 1 || choice == 2)
				{
					break;
				}
			}

			/**
			 * If we chose to play a new game we need to select our character name
			 */
			if (choice == 1)
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the name of the player");
				String player = sc.nextLine();

				Game game = new Game(player);
				game.start();
			}

			else
			{
				break; //TODO methode "closeGame" ou autre ? 
			}

		}
	}
}

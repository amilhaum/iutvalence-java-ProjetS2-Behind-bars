package Windows;

import iut.valence.behindbars.game.Dialogue;
import iut.valence.behindbars.game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial") public class MainWindows extends JFrame implements ActionListener
{
	private Map<String, JButton> listOfButtons;
	public static IHM_Room room[];
	private JLabel dialogue;
	private IHM_Dialogue text;
	private Game game;

	public MainWindows()
	{
		/* Default windows */
		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);

		this.listOfButtons = new HashMap<>();

		initButton();
		initRoom();

		this.setContentPane(room[5]);
		this.repaint();
		this.revalidate();
		this.setVisible(true);

		this.dialogue = new JLabel(new ImageIcon(getClass().getResource("/pictures/diag.png")));
		this.dialogue.setBounds(100, 400, 581, 99);

		this.game = new Game("Nico");
	}

	public void initButton()
	{
		this.listOfButtons.put("NewGame", new GameButtons(100, 430, 219, 49, new ImageIcon(getClass().getResource("/pictures/newgame.png"))));
		this.listOfButtons.put("QuitGame", new GameButtons(500, 430, 219, 49, new ImageIcon(getClass().getResource("/pictures/quitgame.png"))));
		this.listOfButtons.put("Leaderboard", new GameButtons(300, 500, 219, 49, new ImageIcon(getClass().getResource("/pictures/leaderboard.png"))));

		/* The move buttons. */
		this.listOfButtons.put("right_button", new ArrowButtons(745, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_east.png"))));
		this.listOfButtons.put("left_button", new ArrowButtons(5, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_west.png"))));
		this.listOfButtons.put("bottom_button", new ArrowButtons(385, 520, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_south.png"))));
		this.listOfButtons.put("top_button", new ArrowButtons(385, 5, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_north.png"))));
		this.listOfButtons.put("rightB_button", new ArrowButtons(745, 379, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_east.png"))));
		this.listOfButtons.put("bottom_false_button", new ArrowButtons(385, 520, 30, 45, new ImageIcon(getClass().getResource("/pictures/bottom_false_button.png"))));

		/* The buttons of the players in the cell. */
		this.listOfButtons.put("Garry", new CharacterButtons("Garry", 300, 500, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner3.png"))));
		this.listOfButtons.put("Barry", new CharacterButtons("Barry", 300, 50, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner2.png"))));
		this.listOfButtons.put("Brad", new CharacterButtons("Brad", 480, 50, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner4.png"))));
		this.listOfButtons.put("Bryan", new CharacterButtons("Bryan", 480, 500, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner1.png"))));
		this.listOfButtons.put("Steven", new CharacterButtons("Steven", 50, 50, 50, 50, new ImageIcon(getClass().getResource("/pictures/boss.png"))));

		/* The buttons of the players in the corridor. */
		this.listOfButtons.put("Alexandro", new CharacterButtons("Alexandro", 250, 150, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner1.png"))));
		this.listOfButtons.put("Ali", new CharacterButtons("Ali", 600, 190, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner4.png"))));

		/* The buttons of the players outside. */
		this.listOfButtons.put("Frank", new CharacterButtons("Frank", 400, 200, 50, 50, new ImageIcon(getClass().getResource("/pictures/guard.png"))));
		this.listOfButtons.put("Drake", new CharacterButtons("Drake", 150, 450, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner1.png"))));
		this.listOfButtons.put("Elvis", new CharacterButtons("Elvis", 200, 120, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner4.png"))));
		this.listOfButtons.put("Fernando", new CharacterButtons("Fernando", 700, 450, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner2.png"))));

		/* The buttons of the players in the breakroom. */
		this.listOfButtons.put("Carlos", new CharacterButtons("Carlos", 200, 70, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner1.png"))));
		this.listOfButtons.put("Calvin", new CharacterButtons("Calvin", 720, 130, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner4.png"))));
		this.listOfButtons.put("John", new CharacterButtons("John", 720, 320, 50, 50, new ImageIcon(getClass().getResource("/pictures/john.png"))));
		this.listOfButtons.put("Drake", new CharacterButtons("Drake", 350, 450, 50, 50, new ImageIcon(getClass().getResource("/pictures/prisoner3.png"))));

		/* The button of the player in the infirmary. */
		this.listOfButtons.put("Harrison", new CharacterButtons("Harrison", 200, 200, 50, 50, new ImageIcon(getClass().getResource("/pictures/guard.png"))));

		this.listOfButtons.put("Player", new CharacterButtons("Player", 300, 270, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));

		this.listOfButtons.put("PlayerR", new CharacterButtons("PlayerR", 700, 270, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));
		this.listOfButtons.put("PlayerL", new CharacterButtons("PlayerL", 55, 270, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));
		this.listOfButtons.put("PlayerT", new CharacterButtons("PlayerT", 385, 55, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));
		this.listOfButtons.put("PlayerB", new CharacterButtons("PlayerB", 385, 470, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));

		/* The questions */
		this.listOfButtons.put("reponse", new GameButtons(215, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/reponse.png"))));
		this.listOfButtons.put("quitbutton", new GameButtons(314, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/quitbutton.png"))));

		for (Map.Entry<String, JButton> entry : this.listOfButtons.entrySet())
		{
			entry.getValue().addActionListener(this);
		}
	}

	private void initRoom()
	{
		this.room = new IHM_Room[]
		{ new IHM_Room("cell"), new IHM_Room("corridor"), new IHM_Room("outside"), new IHM_Room("infirmary"), new IHM_Room("breakroom"), new IHM_Room("maintest") };

		for (int i = 0; i < room.length; i++)
		{
			room[i].setLayout(null);
		}

		room[0].add(this.listOfButtons.get("right_button"));
		room[0].add(this.listOfButtons.get("Player"));
		room[0].add(this.listOfButtons.get("Barry"));
		room[0].add(this.listOfButtons.get("Garry"));
		room[0].add(this.listOfButtons.get("Brad"));
		room[0].add(this.listOfButtons.get("Bryan"));
		room[0].add(this.listOfButtons.get("Steven"));

		room[1].add(this.listOfButtons.get("Alexandro"));
		room[1].add(this.listOfButtons.get("Ali"));

		room[2].add(this.listOfButtons.get("Frank"));
		room[2].add(this.listOfButtons.get("Drake"));
		room[2].add(this.listOfButtons.get("Elvis"));
		room[2].add(this.listOfButtons.get("Fernando"));

		room[4].add(this.listOfButtons.get("Carlos"));
		room[4].add(this.listOfButtons.get("Calvin"));
		room[4].add(this.listOfButtons.get("John"));
		room[4].add(this.listOfButtons.get("Drake"));

		room[3].add(this.listOfButtons.get("Harrison"));

		room[5].add(this.listOfButtons.get("NewGame"));
		room[5].add(this.listOfButtons.get("QuitGame"));
		room[5].add(this.listOfButtons.get("Leaderboard"));
	}

	@Override public void actionPerformed(ActionEvent e)
	{
		Object sourceClick = e.getSource();
		Object sourceRoom = this.getContentPane();

		if (sourceClick == this.listOfButtons.get("QuitGame"))
		{
			System.exit(0);
		}

		else if (sourceClick == this.listOfButtons.get("NewGame"))
		{
			this.setContentPane(room[0]);
			this.repaint();
			this.revalidate();
		}

		else if (sourceRoom == this.room[0])
		{
			/* If is the right button. */
			if (sourceClick == this.listOfButtons.get("right_button"))
			{
				removeDialogue(0);
				setARoom(1);
				room[1].add(this.listOfButtons.get("PlayerL"));
			}
			else
			{
				click(sourceClick, 0);
			}
		}

		else if (sourceRoom == this.room[1])
		{
			if (sourceClick == this.listOfButtons.get("left_button"))
			{
				setARoom(0);
				room[0].add(this.listOfButtons.get("PlayerR"));
			}
			else if (sourceClick == this.listOfButtons.get("right_button"))
			{
				setARoom(2);
				room[2].add(this.listOfButtons.get("PlayerL"));
			}
			else if (sourceClick == this.listOfButtons.get("bottom_button"))
			{
				setARoom(4);
				room[4].add(this.listOfButtons.get("PlayerT"));
			}
			else
			{
				click(sourceClick, 1);
			}
		}

		else if (sourceRoom == this.room[2])
		{
			if (sourceClick == this.listOfButtons.get("left_button"))
			{
				setARoom(1);
				room[1].add(this.listOfButtons.get("PlayerR"));
			}
			else
			{
				click(sourceClick, 2);
			}
		}

		else if (sourceRoom == this.room[4])
		{
			if (sourceClick == this.listOfButtons.get("top_button"))
			{
				setARoom(1);
				room[1].add(this.listOfButtons.get("PlayerB"));

			}
			else if (sourceClick == this.listOfButtons.get("bottom_button"))
			{
				setARoom(3);
				room[3].add(this.listOfButtons.get("PlayerT"));
			}
			else if (sourceClick == this.listOfButtons.get("bottom_false_button"))
			{
				displayDialogue(Dialogue.LOCKDOOR);
				room[4].add(this.listOfButtons.get("quitbutton"));
			}
			else
			{
				click(sourceClick, 4);
			}
			this.listOfButtons.get("bottom_button").setEnabled(true);
		}

		else
		{
			if (sourceClick == this.listOfButtons.get("rightB_button"))
			{
				setARoom(0);
				room[0].add(this.listOfButtons.get("Player"));
				displayDialogue(Dialogue.FAILDOOR);
				this.game.addPenalty();
				room[0].add(this.listOfButtons.get("quitbutton"));
				System.out.println(this.game.getPlayer().getPenalty());
			}
			else
			{

				setARoom(4);
				room[4].add(this.listOfButtons.get("PlayerB"));
			}
		}
	}

	private void displayDialogue(Dialogue dialogue)
	{
		this.text = new IHM_Dialogue(dialogue);
		this.getContentPane().add(this.text);
		this.getContentPane().add(this.dialogue);
		this.repaint();
		this.revalidate();
	}

	private void setARoom(int x)
	{

		this.setContentPane(room[x]);
		this.repaint();
		this.revalidate();

		if (x == 0)
		{
			room[0].add(this.listOfButtons.get("right_button"));
			room[0].add(this.listOfButtons.get("PlayerR"));
		}

		else if (x == 1)
		{
			room[1].add(this.listOfButtons.get("left_button"));
			room[1].add(this.listOfButtons.get("bottom_button"));
			room[1].add(this.listOfButtons.get("right_button"));
		}

		else if (x == 2)
		{
			room[2].add(this.listOfButtons.get("left_button"));
		}

		else if (x == 3)
		{
			room[3].add(this.listOfButtons.get("top_button"));
			room[3].add(this.listOfButtons.get("rightB_button"));
		}

		else if (x == 4)
		{
			//this.game.getPlayer().getInventory().addObject(this.game.getObjects().get("Infirmary's key"));
			if (!(this.game.getPlayer().getInventory().isInInventory(this.game.getPlayer().getInventory(), "Infirmary's key")))
			{
				room[4].add(this.listOfButtons.get("bottom_false_button"));
				room[4].add(this.listOfButtons.get("top_button"));
			}
			else
			{
				room[4].add(this.listOfButtons.get("bottom_button"));
				room[4].add(this.listOfButtons.get("top_button"));
			}
		}

		room[x].remove(this.listOfButtons.get("Player"));
		room[x].remove(this.listOfButtons.get("PlayerR"));
		room[x].remove(this.listOfButtons.get("PlayerL"));
		room[x].remove(this.listOfButtons.get("PlayerB"));
		room[x].remove(this.listOfButtons.get("PlayerT"));
	}

	private void removeDialogue(int x)
	{
		try
		{
			room[x].remove(this.listOfButtons.get("quitbutton"));
			room[x].remove(dialogue);
			room[x].remove(text);
		}
		catch (NullPointerException e)
		{
			//TODO nothing
		}
		this.setContentPane(room[x]);
		this.repaint();
		this.revalidate();
	}

	private void click(Object sourceClick, int x)
	{
		/* If is Steven. */
		if (sourceClick == this.listOfButtons.get("Steven"))
		{
			if (this.game.getNbtalkJohn() == 0)
			{
				removeDialogue(x);
				displayDialogue(Dialogue.PRISONER);
				room[x].add(this.listOfButtons.get("quitbutton"));
			}

			else if (this.game.getNbtalkJohn() == 1)
			{
				removeDialogue(x);
				displayDialogue(Dialogue.STEVEN_SALUTATION);
				room[x].add(this.listOfButtons.get("quitbutton"));
			}
		}

		else if (sourceClick == this.listOfButtons.get("John"))
		{
			if (this.game.getNbtalkJohn() == 0)
			{
				removeDialogue(x);
				displayDialogue(Dialogue.JOHN_SALUTATION);
				this.game.updateJohnTalk();
				room[x].add(this.listOfButtons.get("quitbutton"));
			}
			else if (this.game.getNbtalkJohn() == 1)
			{
				removeDialogue(x);
				displayDialogue(Dialogue.JOHN_COMMON_TALK);
				room[x].add(this.listOfButtons.get("quitbutton"));
			}
		}

		/* If is the first answer. */
		else if (sourceClick == this.listOfButtons.get("reponse"))
		{
			System.out.println("qs");
		}

		/*If is the player. */
		else if (sourceClick == this.listOfButtons.get("Player") || sourceClick == this.listOfButtons.get("PlayerT") || sourceClick == this.listOfButtons.get("PlayerB")
				|| sourceClick == this.listOfButtons.get("PlayerL") || sourceClick == this.listOfButtons.get("PlayerR"))
		{
			//TODO nothing
		}

		/* If is the quit button. */
		else if (sourceClick == this.listOfButtons.get("quitbutton"))
		{
			removeDialogue(x);
		}

		else if (sourceClick == this.listOfButtons.get("Frank"))
		{
			removeDialogue(x);
			displayDialogue(Dialogue.GUARD);
			room[x].add(this.listOfButtons.get("quitbutton"));
		}
		/* If is the other prisoners. */
		else
		{
			removeDialogue(x);
			displayDialogue(Dialogue.PRISONER);
			room[x].add(this.listOfButtons.get("quitbutton"));
		}
	}
}
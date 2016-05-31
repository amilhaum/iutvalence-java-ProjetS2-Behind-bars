package TESTMAIN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import iut.valence.behindbars.game.Dialogue;
import iut.valence.behindbars.game.Game;

public class MainWindows extends JFrame implements ActionListener
{
	private Map<String, JButton>	listOfButtons;
	public static IHM_Room			room[];
	private JLabel					dialogue;
	private IHM_Dialogue			text;
	private Game					game;

	public static JLabel			jlabelList[];
	private Automate				currentAutomate;

	/**
	 * The mainwindows constructor.
	 */
	public MainWindows()
	{
		/* Default windows */
		this.setTitle("BehindBars");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		this.addKeyListener(new InventoryKeyListener());

		this.listOfButtons = new HashMap<>();
		this.currentAutomate = Automate.CELLS_BEGIN;

		jlabelList = new JLabel[10];
		for (int i = 0; i < 10; i++)
		{
			jlabelList[i] = new JLabel("L" + i);
		}

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

	/**
	 * The initialization of the buttons.
	 */
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
		this.listOfButtons.put("yes", new GameButtons(215, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/yes.png"))));
		this.listOfButtons.put("no", new GameButtons(400, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/no.png"))));

		this.listOfButtons.put("idk", new GameButtons(115, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/idk.png"))));
		this.listOfButtons.put("e", new GameButtons(300, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/e.png"))));
		this.listOfButtons.put("you", new GameButtons(500, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/you.png"))));

		this.listOfButtons.put("quitbutton", new GameButtons(314, 500, 153, 66, new ImageIcon(getClass().getResource("/pictures/quitbutton.png"))));

		for (Map.Entry<String, JButton> entry : this.listOfButtons.entrySet())
		{
			entry.getValue().addActionListener(this);
		}
	}

	/**
	 * The initialization of the rooms.
	 */
	private void initRoom()
	{
		this.room = new IHM_Room[]
		{
				new IHM_Room("cell"), new IHM_Room("corridor"), new IHM_Room("outside"), new IHM_Room("infirmary"), new IHM_Room("breakroom"), new IHM_Room("maintest")
		};

		for (int i = 0; i < room.length; i++)
		{
			room[i].setLayout(null);
			for (int j = 0; j < 10; j++)
			{
				// Add inventory slots (labels) to each room
				room[i].add(jlabelList[j]);
				// Initialize position and size of inventory slots
				jlabelList[j].setLocation(400 + (30 * j), 50);
				jlabelList[j].setSize(30, 30);
				/**
				 * Put the inventory on top
				 *
				 * @TODO MUST BE DONE, DOESN'T WORK !!!
				 */
				room[i].setComponentZOrder(jlabelList[j], 0);
			}
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JButton sourceClick = (JButton) e.getSource();
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

		else if (sourceClick == this.listOfButtons.get("yes"))
		{
			currentAutomate = Automate.CELLS_NOKEY_QUEST_YES;
		}

		else if (sourceClick == this.listOfButtons.get("no") || sourceClick == this.listOfButtons.get("idk") || sourceClick == this.listOfButtons.get("you"))
		{
			currentAutomate = Automate.CELLS_NOKEY_QUEST_FALSE;
		}

		else if (sourceClick == this.listOfButtons.get("quitbutton"))
		{
			setQuit(sourceRoom);
		}

		switch (currentAutomate)
		{
			case CELLS_BEGIN:
			{
				cells_begin(Dialogue.PRISONER, sourceClick);
				break;
			}
			case CELLS_NOKEY_QUEST_STATE0:
			{
				if (sourceClick == this.listOfButtons.get("Steven"))
				{
					setDialogueAndButton(Dialogue.STEVEN_SALUTATION, 0, false);
					room[0].add(this.listOfButtons.get("yes"));
					room[0].add(this.listOfButtons.get("no"));
					room[0].remove(this.listOfButtons.get("quitbutton"));
					setVisibilityButton("Bryan", false);
				}
				else
				{
					cells_begin(Dialogue.PRISONER, sourceClick);
				}

				break;
			}
			case CELLS_NOKEY_QUEST_YES:
			{
				if (sourceClick == this.listOfButtons.get("Steven"))
				{
					removeDialogue(0);
					setDialogueAndButton(Dialogue.STEVEN_RIDDLE1, 0, false);
					room[0].add(this.listOfButtons.get("idk"));
					room[0].add(this.listOfButtons.get("e"));
					room[0].add(this.listOfButtons.get("you"));
					room[0].remove(this.listOfButtons.get("quitbutton"));
					room[0].remove(this.listOfButtons.get("yes"));
					room[0].remove(this.listOfButtons.get("no"));
					setVisibilityButton("Bryan", false);
				}
				else
				{
					cells_begin(Dialogue.PRISONER, sourceClick);
				}

				break;
			}
			case CELLS_NOKEY_QUEST_FALSE:
			{
				if (sourceClick == this.listOfButtons.get("Steven"))
				{
					removeDialogue(0);
					setVisibilityButton("Bryan", true);
					setVisibilityButton("Garry", true);

				}
				else
				{
					cells_begin(Dialogue.PRISONER, sourceClick);
				}
				currentAutomate = Automate.CELLS_NOKEY_QUEST_STATE0;
				break;
			}

			case CELLS_NOKEY_QUEST_E:
			{
				if (sourceClick == this.listOfButtons.get("Steven"))
				{
					removeDialogue(0);
					this.game.getPlayer().getInventory().addItem(this.game.getItems().get("Infirmary's key"));
					setDialogueAndButton(Dialogue.KEY, 0, false);
					setVisibilityButton("Bryan", true);
				}
				else
				{
					cells_begin(Dialogue.PRISONER, sourceClick);
				}
				currentAutomate = Automate.CELLS_NOKEY_QUEST_STATE0;
				break;
			}

			case CORRIDOR:
			{
				if (sourceClick == this.listOfButtons.get("left_button"))
				{
					actionOnButton(1, 0, true, "PlayerR");
					currentAutomate = Automate.CELLS_BEGIN;
				}
				else if (sourceClick == this.listOfButtons.get("right_button"))
				{
					actionOnButton(1, 2, true, "PlayerL");
					currentAutomate = Automate.OUTSIDE;
				}
				else if (sourceClick == this.listOfButtons.get("bottom_button"))
				{
					actionOnButton(1, 4, true, "PlayerT");
					currentAutomate = Automate.BREAKROOM_NOKEY_NOQUEST;
				}
				else
				{
					setDialogueAndButton(Dialogue.PRISONER, 1, false);
				}
				break;
			}
			case OUTSIDE:
			{
				if (sourceClick == this.listOfButtons.get("left_button"))
				{
					actionOnButton(2, 1, true, "PlayerR");
					currentAutomate = Automate.CORRIDOR;
				}
				else if (sourceClick == this.listOfButtons.get("Frank"))
				{
					setDialogueAndButton(Dialogue.GUARD, 2, false);
				}
				else
				{
					setDialogueAndButton(Dialogue.PRISONER, 2, false);
				}
				break;
			}
			case BREAKROOM_NOKEY_NOQUEST:
			{
				breakroom_nokey_noquest(Dialogue.JOHN_SALUTATION, sourceClick);
				break;
			}
			case BREAKROOM_NOKEY_QUEST_STATE0:
			{
				breakroom_nokey_noquest(Dialogue.JOHN_COMMON_TALK, sourceClick);
				break;
			}
			case BREAKROOM_KEY_QUEST_STATE1:
			{
				breakroom_nokey_noquest(Dialogue.JOHN_QUEST_FULLFIL, sourceClick);
				break;
			}
			case INFIRMARY:
			{
				if (sourceClick == this.listOfButtons.get("rightB_button"))
				{
					actionOnButton(3, 0, true, "Player");
					displayDialogue(Dialogue.FAILDOOR);
					this.game.addPenalty();
					room[0].add(this.listOfButtons.get("quitbutton"));
					setVisibilityUnderButton(0, false);

				}
				else
				{
					actionOnButton(3, 4, true, "PlayerB");
				}
			}
		}

	}

	/**
	 * The method to display a dialogue.
	 *
	 * @param dialogue is the dialogue displayed
	 */
	private void displayDialogue(Dialogue dialogue)
	{
		this.text = new IHM_Dialogue(dialogue);
		this.getContentPane().add(this.text);
		this.getContentPane().add(this.dialogue);
		this.repaint();
		this.revalidate();
	}

	/**
	 * The method to set a room.
	 *
	 * @param x is the room's number
	 */
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

	/**
	 * The method to remove a dialogue and a button.
	 *
	 * @param x is the room's nubmer
	 */
	private void removeDialogue(int x)
	{
		try
		{
			room[x].remove(this.listOfButtons.get("quitbutton"));
			room[x].remove(dialogue);
			room[x].remove(text);
			room[x].remove(this.listOfButtons.get("yes"));
			room[x].remove(this.listOfButtons.get("no"));
			room[x].remove(this.listOfButtons.get("idk"));
			room[x].remove(this.listOfButtons.get("e"));
			room[x].remove(this.listOfButtons.get("you"));

		}
		catch (NullPointerException e)
		{
			// TODO nothing
		}
		this.setContentPane(room[x]);
		this.repaint();
		this.revalidate();
	}

	/**
	 * The method to flip a dialogue and a button in the room.
	 *
	 * @param x is the room's number
	 */
	private void setVisibilityUnderButton(int x, boolean b)
	{
		if (x == 0)
		{
			setVisibilityButton("Garry", b);
		}

		else if (x == 1)
		{
			setVisibilityButton("bottom_button", b);
			setVisibilityButton("PlayerB", b);
		}

		else if (x == 4)
		{
			setVisibilityButton("Drake", b);
			setVisibilityButton("bottom_button", b);
			setVisibilityButton("bottom_false_button", b);
			try
			{
				setVisibilityButton("PlayerB", b);
			}
			catch (NullPointerException e)
			{
				// TODO nothing
			}
		}

	}

	/**
	 * The method to flip the button's visibility.
	 *
	 * @param name is the button's name
	 */
	private void setVisibilityButton(String name, boolean b)
	{
		if (!b)
		{
			this.listOfButtons.get(name).setVisible(false);
		}
		else
		{
			this.listOfButtons.get(name).setVisible(true);
		}

	}

	/**
	 * The method to display an dialogue with a quit button.
	 *
	 * @param dialogue is the dialogue to display
	 * @param x is the room's number
	 */
	private void setDialogueAndButton(Dialogue dialogue, int x, boolean b)
	{
		removeDialogue(x);
		displayDialogue(dialogue);
		room[x].add(this.listOfButtons.get("quitbutton"));
		setVisibilityUnderButton(x, b);
	}

	/**
	 * The action on the buttons when it's pressed.
	 *
	 * @param Dial the number of the current room
	 * @param xroom the number of the next room
	 * @param b is the button is an arrow button or not
	 * @param buttonName the name button to add
	 */
	private void actionOnButton(int Dial, int xroom, boolean b, String buttonName)
	{
		removeDialogue(Dial);
		setARoom(xroom);
		room[xroom].add(this.listOfButtons.get(buttonName));
		setVisibilityUnderButton(Dial, b);
	}

	private void breakroom_nokey_noquest(Dialogue dialogue, JButton sourceClick)
	{
		if (sourceClick == this.listOfButtons.get("top_button"))
		{
			actionOnButton(4, 1, true, "PlayerB");
			room[4].remove(this.listOfButtons.get("bottom_false_button"));
			currentAutomate = Automate.CORRIDOR;
		}
		else if (sourceClick == this.listOfButtons.get("bottom_button"))
		{
			actionOnButton(4, 3, true, "PlayerT");
			currentAutomate = Automate.INFIRMARY;
		}
		else if (sourceClick == this.listOfButtons.get("bottom_false_button"))
		{
			removeDialogue(4);
			displayDialogue(Dialogue.LOCKDOOR);
			room[4].add(this.listOfButtons.get("quitbutton"));
			listOfButtons.get("bottom_false_button").setVisible(false);
			this.listOfButtons.get("Drake").setVisible(false);
		}
		else if (sourceClick == this.listOfButtons.get("John"))
		{
			setDialogueAndButton(dialogue, 4, false);
			currentAutomate = Automate.BREAKROOM_NOKEY_QUEST_STATE0;
		}
		else
		{
			setDialogueAndButton(Dialogue.PRISONER, 4, false);
		}
	}

	private void cells_begin(Dialogue dialogue, JButton sourceClick)
	{
		if (sourceClick == this.listOfButtons.get("right_button"))
		{
			actionOnButton(0, 1, true, "PlayerL");
			currentAutomate = Automate.CORRIDOR;
		}
		else
		{
			setDialogueAndButton(Dialogue.PRISONER, 3, false);
		}
	}

	private void setQuit(Object sourceRoom)
	{
		if (sourceRoom == this.room[0])
		{
			removeDialogue(0);
			setVisibilityUnderButton(0, true);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}

		if (sourceRoom == this.room[1])
		{
			removeDialogue(1);
			setVisibilityUnderButton(1, true);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}
		if (sourceRoom == this.room[2])
		{
			removeDialogue(2);
			setVisibilityUnderButton(2, true);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}
		if (sourceRoom == this.room[3])
		{
			removeDialogue(3);
			setVisibilityUnderButton(3, true);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}
		if (sourceRoom == this.room[4])
		{
			removeDialogue(4);
			setVisibilityUnderButton(4, true);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}
	}

}

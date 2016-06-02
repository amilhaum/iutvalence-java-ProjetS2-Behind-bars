package iut.valence.behindbars.windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import iut.valence.behindbars.automate.Automate;
import iut.valence.behindbars.automate.QuestAutomate;
import iut.valence.behindbars.buttons.AnswersButtons;
import iut.valence.behindbars.buttons.ArrowButtons;
import iut.valence.behindbars.buttons.CharacterButtons;
import iut.valence.behindbars.buttons.GameButtons;
import iut.valence.behindbars.character.Bed;
import iut.valence.behindbars.game.Dialogue;
import iut.valence.behindbars.game.Game;
import iut.valence.behindbars.ihm.BedLabel;
import iut.valence.behindbars.ihm.IHM_Dialogue;
import iut.valence.behindbars.ihm.IHM_NPC;
import iut.valence.behindbars.ihm.IHM_Player;
import iut.valence.behindbars.ihm.IHM_Room;

public class MainWindows extends JFrame implements ActionListener
{
	/**
	 *
	 */
	private static final long		serialVersionUID	= 1332053010607176048L;
	private Map<String, JButton>	listOfButtons;
	private Map<String, JLabel>		listOfInfirmaryButtons;

	public static IHM_Room			room[];
	private JLabel					dialogue;
	private IHM_Dialogue			text;
	private Game					game;
	private IHM_Dialogue			dialoguefinal;
	private JLabel					dialfinal;

	private Automate				currentAutomate;
	private QuestAutomate			currentQuestAutomate;

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
		this.setIconImage(new ImageIcon(getClass().getResource("/pictures/iconwindows.png")).getImage());

		this.game = new Game("Nico");

		this.listOfButtons = new HashMap<>();
		this.listOfInfirmaryButtons = new HashMap<>();

		this.currentAutomate = Automate.CELLS_BEGIN;
		this.currentQuestAutomate = QuestAutomate.NOQUEST;

		initButton();
		initRoom();
		initRoom3();

		this.setContentPane(room[5]);
		this.repaint();
		this.revalidate();
		this.setVisible(true);

		this.dialfinal = new JLabel(new ImageIcon(getClass().getResource("/pictures/diaggameover.png")));
		this.dialfinal.setBounds(100, 200, 581, 99);

		this.dialogue = new JLabel(new ImageIcon(getClass().getResource("/pictures/diag.png")));
		this.dialogue.setBounds(100, 400, 581, 99);

		ComponentMove listener = new ComponentMove(this.room[3], this.listOfInfirmaryButtons);

		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	/**
	 * The initialization of the buttons.
	 */
	public void initButton()
	{
		this.listOfButtons.put("NewGame",
				new GameButtons(100, 430, new ImageIcon(getClass().getResource("/pictures/newgame.png"))));
		this.listOfButtons.put("QuitGame",
				new GameButtons(500, 430, new ImageIcon(getClass().getResource("/pictures/quitgame.png"))));

		/* The move buttons. */
		this.listOfButtons.put("right_button",
				new ArrowButtons(745, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_east.png"))));
		this.listOfButtons.put("left_button",
				new ArrowButtons(5, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_west.png"))));
		this.listOfButtons.put("bottom_button",
				new ArrowButtons(385, 520, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_south.png"))));
		this.listOfButtons.put("top_button",
				new ArrowButtons(385, 5, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_north.png"))));
		this.listOfButtons.put("rightB_button",
				new ArrowButtons(745, 379, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_east.png"))));
		this.listOfButtons.put("bottom_false_button", new ArrowButtons(385, 520, 30, 45,
				new ImageIcon(getClass().getResource("/pictures/bottom_false_button.png"))));

		/* The buttons of the players in the cell. */
		this.listOfButtons.put("Garry", new IHM_NPC(this.game.getNPCs().get("Garry")));
		this.listOfButtons.put("Barry", new IHM_NPC(this.game.getNPCs().get("Barry")));
		this.listOfButtons.put("Brad", new IHM_NPC(this.game.getNPCs().get("Brad")));
		this.listOfButtons.put("Bryan", new IHM_NPC(this.game.getNPCs().get("Bryan")));
		this.listOfButtons.put("Steven", new IHM_NPC(this.game.getNPCs().get("Steven")));

		/* The buttons of the players in the corridor. */
		this.listOfButtons.put("Alexandro", new IHM_NPC(this.game.getNPCs().get("Alexandro")));
		this.listOfButtons.put("Ali", new IHM_NPC(this.game.getNPCs().get("Ali")));

		/* The buttons of the players outside. */
		this.listOfButtons.put("Frank", new IHM_NPC(this.game.getNPCs().get("Frank")));
		this.listOfButtons.put("Drake", new IHM_NPC(this.game.getNPCs().get("Drake")));
		this.listOfButtons.put("Elvis", new IHM_NPC(this.game.getNPCs().get("Elvis")));
		this.listOfButtons.put("Fernando", new IHM_NPC(this.game.getNPCs().get("Fernando")));

		/* The buttons of the players in the breakroom. */
		this.listOfButtons.put("Carlos", new IHM_NPC(this.game.getNPCs().get("Carlos")));
		this.listOfButtons.put("Calvin", new IHM_NPC(this.game.getNPCs().get("Calvin")));
		this.listOfButtons.put("John", new IHM_NPC(this.game.getNPCs().get("John")));
		this.listOfButtons.put("Drake", new IHM_NPC(this.game.getNPCs().get("Drake")));

		/* The button of the player in the infirmary. */
		this.listOfButtons.put("Harrison", new IHM_NPC(this.game.getNPCs().get("Harrison")));

		this.listOfButtons.put("Player", new IHM_Player(this.game.getPlayer()));

		this.listOfButtons.put("PlayerR", new CharacterButtons("PlayerR", this.game.getPlayer(), 700, 270, 0));
		this.listOfButtons.put("PlayerL", new CharacterButtons("PlayerL", this.game.getPlayer(), 55, 270, 0));
		this.listOfButtons.put("PlayerT", new CharacterButtons("PlayerT", this.game.getPlayer(), 385, 55, 0));
		this.listOfButtons.put("PlayerB", new CharacterButtons("PlayerB", this.game.getPlayer(), 385, 470, 0));

		this.listOfButtons.put("JohnR", new CharacterButtons("JohnR", this.game.getNPCs().get("John"), 700, 220, 7));
		this.listOfButtons.put("JohnL", new CharacterButtons("JohnL", this.game.getNPCs().get("John"), 55, 220, 7));
		this.listOfButtons.put("JohnT", new CharacterButtons("JohnT", this.game.getNPCs().get("John"), 335, 55, 7));
		this.listOfButtons.put("JohnB", new CharacterButtons("JohnB", this.game.getNPCs().get("John"), 335, 470, 7));

		/* The questions */
		this.listOfButtons.put("yes",
				new AnswersButtons(215, 500, new ImageIcon(getClass().getResource("/pictures/yes.png"))));
		this.listOfButtons.put("no",
				new AnswersButtons(400, 500, new ImageIcon(getClass().getResource("/pictures/no.png"))));
		this.listOfButtons.put("knockhim",
				new AnswersButtons(215, 500, new ImageIcon(getClass().getResource("/pictures/knockhim.png"))));
		this.listOfButtons.put("killhim",
				new AnswersButtons(400, 500, new ImageIcon(getClass().getResource("/pictures/killhim.png"))));

		this.listOfButtons.put("idk",
				new AnswersButtons(115, 500, new ImageIcon(getClass().getResource("/pictures/idk.png"))));
		this.listOfButtons.put("e",
				new AnswersButtons(300, 500, new ImageIcon(getClass().getResource("/pictures/e.png"))));
		this.listOfButtons.put("you",
				new AnswersButtons(500, 500, new ImageIcon(getClass().getResource("/pictures/you.png"))));

		this.listOfButtons.put("quitbutton",
				new AnswersButtons(314, 500, new ImageIcon(getClass().getResource("/pictures/quitbutton.png"))));
		this.listOfButtons.put("ok",
				new AnswersButtons(314, 500, new ImageIcon(getClass().getResource("/pictures/ok.png"))));
		this.listOfButtons.put("great",
				new AnswersButtons(314, 500, new ImageIcon(getClass().getResource("/pictures/great.png"))));
		this.listOfButtons.put("main",
				new GameButtons(284, 500, new ImageIcon(getClass().getResource("/pictures/main.png"))));

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
				new IHM_Room(this.game.getRooms().get("cells")),
				new IHM_Room(this.game.getRooms().get("corridor")),
				new IHM_Room(this.game.getRooms().get("outside")),
				new IHM_Room(this.game.getRooms().get("infirmary")),
				new IHM_Room(this.game.getRooms().get("breakroom")),
				new IHM_Room(this.game.getRooms().get("maintest")),
				new IHM_Room(this.game.getRooms().get("gameoverboard"))
		};

		for (int i = 0; i < room.length; i++)
		{
			room[i].setLayout(null);
		}

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

		initRoom3();

		room[5].add(this.listOfButtons.get("NewGame"));
		room[5].add(this.listOfButtons.get("QuitGame"));
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
			initRoom0();
			this.setContentPane(room[0]);
			this.repaint();
			this.revalidate();
			currentAutomate = Automate.CELLS_BEGIN;
			currentQuestAutomate = QuestAutomate.NOQUEST;
			room[0].remove(this.listOfButtons.get("JohnR"));
			room[4].add(this.listOfButtons.get("John"));
		}

		else if (sourceClick == this.listOfButtons.get("main"))
		{
			this.setContentPane(room[5]);
			this.repaint();
			this.revalidate();
			currentAutomate = Automate.CELLS_BEGIN;
			currentQuestAutomate = QuestAutomate.NOQUEST;
			room[0].remove(this.listOfButtons.get("PlayerR"));

		}

		else if (sourceClick == this.listOfButtons.get("yes"))
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

		else if (sourceClick == this.listOfButtons.get("ok"))
		{
			removeDialogue(0);
			setDialogueAndButton(Dialogue.KEY, 0, false);
			room[0].remove(this.listOfButtons.get("ok"));
			room[0].add(this.listOfButtons.get("quitbutton"));
		}

		else if (sourceClick == this.listOfButtons.get("great"))
		{
			removeDialogue(4);
			room[4].remove(this.listOfButtons.get("bottom_false_button"));
			room[4].remove(this.listOfButtons.get("great"));
			room[4].add(this.listOfButtons.get("bottom_button"));
			this.listOfButtons.get("bottom_button").setVisible(true);
			setVisibilityButton("Drake", true);
		}

		else if (sourceClick == this.listOfButtons.get("idk") || sourceClick == this.listOfButtons.get("you"))
		{
			endFail(Dialogue.FAIL);
		}
		else if (sourceClick == this.listOfButtons.get("no"))
		{
			removeDialogue(0);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}

		else if (sourceClick == this.listOfButtons.get("e"))
		{
			removeDialogue(0);
			setDialogueAndButton(Dialogue.STEVEN_SUCCEED_RIDLLE, 0, false);
			setVisibilityButton("Bryan", true);
			currentQuestAutomate = QuestAutomate.QUESTST1;
			currentAutomate = Automate.CELLS_QUEST_FINISH;
		}
		else if (sourceClick == this.listOfButtons.get("quitbutton"))
		{
			setQuit(sourceRoom);
			setOnLabelInfirmary();
		}
		else if (sourceClick == this.listOfButtons.get("killhim"))
		{
			removeDialogue(3);
			endFail(Dialogue.FAILGUARD);
		}
		else if (sourceClick == this.listOfButtons.get("knockhim"))
		{
			removeDialogue(3);
			displayDialogue(Dialogue.GUARD_RESULT1);
			room[3].add(this.listOfButtons.get("quitbutton"));
			currentQuestAutomate = QuestAutomate.GUARDFINISH;
		}

		else
		{

			switch (currentAutomate)
			{
				case CELLS_BEGIN:
				{
					if (!(isPlayerOrJohn(sourceClick)))
					{
						cells_begin(Dialogue.PRISONER, sourceClick);
					}
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
					else if (sourceClick == this.listOfButtons.get("JohnR"))
					{
						cells_begin(Dialogue.JOHN_QUEST_END, sourceClick);
					}
					else if (!(isPlayerOrJohn(sourceClick)))
					{
						cells_begin(Dialogue.PRISONER, sourceClick);
					}

					break;
				}

				case CELLS_QUEST_FINISH:
				{
					if (sourceClick == this.listOfButtons.get("Steven"))
					{
						cells_begin(Dialogue.STEVEN_FINISH, sourceClick);
					}
					else if (sourceClick == this.listOfButtons.get("JohnR"))
					{
						cells_begin(Dialogue.JOHN_QUEST_END, sourceClick);
					}
					else if (!(isPlayerOrJohn(sourceClick)))
					{
						cells_begin(Dialogue.PRISONER, sourceClick);
					}

					break;
				}

				case CORRIDOR:
				{
					if (sourceClick == this.listOfButtons.get("left_button"))
					{
						actionOnButton(1, 0, true, "PlayerR");
						if (currentQuestAutomate == QuestAutomate.NOQUEST)
						{
							currentAutomate = Automate.CELLS_BEGIN;
						}
						else if (currentQuestAutomate == QuestAutomate.QUESTST0)
						{
							currentAutomate = Automate.CELLS_NOKEY_QUEST_STATE0;
						}
						else if (currentQuestAutomate == QuestAutomate.QUESTST1)
						{
							currentAutomate = Automate.CELLS_QUEST_FINISH;
						}
						else if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH
								|| currentQuestAutomate == QuestAutomate.GUARDFINISH)
						{
							currentAutomate = Automate.CELLS_QUEST_FINISH;
						}

					}
					else if (sourceClick == this.listOfButtons.get("right_button"))
					{
						actionOnButton(1, 2, true, "PlayerL");
						currentAutomate = Automate.OUTSIDE;
					}
					else if (sourceClick == this.listOfButtons.get("bottom_button"))
					{
						actionOnButton(1, 4, true, "PlayerT");
						currentAutomate = Automate.BREAKROOM;
					}
					else if (isJohn(sourceClick))
					{
						setDialogueAndButton(Dialogue.JOHN_QUEST_END, 1, false);
					}
					else if (!(isPlayerOrJohn(sourceClick)))
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
					else if (isJohn(sourceClick))
					{
						setDialogueAndButton(Dialogue.JOHN_QUEST_END, 2, false);
					}
					else if (!(isPlayerOrJohn(sourceClick)))
					{
						setDialogueAndButton(Dialogue.PRISONER, 2, false);
					}
					break;
				}
				case BREAKROOM:
				{
					if (currentQuestAutomate == QuestAutomate.NOQUEST)
					{
						breakroom_nokey_noquest(Dialogue.JOHN_SALUTATION, sourceClick);
					}
					else if (currentQuestAutomate == QuestAutomate.QUESTST0)
					{
						breakroom_nokey_noquest(Dialogue.JOHN_COMMON_TALK, sourceClick);
					}
					else if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH
							|| currentQuestAutomate == QuestAutomate.GUARDFINISH)
					{
						breakroom_nokey_noquest(Dialogue.JOHN_QUEST_END, sourceClick);
					}
					else
					{
						breakroom_nokey_noquest(Dialogue.JOHN_QUEST_FULLFIL, sourceClick);
					}
					break;
				}

				case INFIRMARY:
				{
					if (sourceClick == this.listOfButtons.get("rightB_button"))
					{
						endFail(Dialogue.FAILDOOR);
					}
					else if (sourceClick == this.listOfButtons.get("Harrison"))
					{
						if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH)
						{
							removeDialogue(3);
							displayDialogue(Dialogue.GUARD_CHOICE);
							room[3].add(this.listOfButtons.get("knockhim"));
							room[3].add(this.listOfButtons.get("killhim"));
							setOffLabelInfirmary();
						}
						else
						{
							removeDialogue(3);
							setOffLabelInfirmary();
							displayDialogue(Dialogue.GUARD_RESULT1);
							room[3].add(this.listOfButtons.get("quitbutton"));
						}
					}
					else if (isJohn(sourceClick))
					{
						if (currentQuestAutomate == QuestAutomate.GUARDFINISH)
						{
							setDialogueAndButton(Dialogue.JOHN_QUEST_END, 3, false);
							setOffLabelInfirmary();
						}
					}

					else if (sourceClick == this.listOfButtons.get("top_button"))
					{
						actionOnButton(3, 4, true, "PlayerB");
						currentAutomate = Automate.BREAKROOM;
					}
					break;
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

		if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH || currentQuestAutomate == QuestAutomate.GUARDFINISH)
		{
			room[x].remove(this.listOfButtons.get("John"));
		}
		room[x].remove(this.listOfButtons.get("JohnR"));
		room[x].remove(this.listOfButtons.get("JohnL"));
		room[x].remove(this.listOfButtons.get("JohnB"));
		room[x].remove(this.listOfButtons.get("JohnT"));

		if (x == 0)
		{
			room[0].add(this.listOfButtons.get("right_button"));
			room[0].add(this.listOfButtons.get("PlayerR"));
			if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH
					|| currentQuestAutomate == QuestAutomate.GUARDFINISH)
			{
				room[0].add(this.listOfButtons.get("JohnR"));
			}
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
			initRoom3();
		}

		else if (x == 4)
		{
			if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH)
			{
				room[4].add(this.listOfButtons.get("bottom_button"));
				room[4].add(this.listOfButtons.get("top_button"));
			}
			else
			{
				room[4].add(this.listOfButtons.get("bottom_false_button"));
				room[4].add(this.listOfButtons.get("top_button"));
			}
		}
		else if (x == 6)
		{
			removeDialogue(6);
			room[6].add(this.listOfButtons.get("main"));
			String str;
			if (this.game.getPlayer().getPenalty() == 0)
			{
				str = String.format(
						"\n                                                Well played, you finished the game withoud losing !");
			}
			else if (this.game.getPlayer().getPenalty() == 1)
			{
				str = String.format(
						"\n                                                           Well played, you lost only 1 time");
			}
			else
			{
				str = String.format(
						"\n                                                          Well played, you lost only %s times",
						this.game.getPlayer().getPenalty());
			}

			this.dialoguefinal = new IHM_Dialogue(str);
			room[6].add(this.dialoguefinal);
			room[6].add(dialfinal);

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
			room[x].remove(this.listOfButtons.get("ok"));
			room[x].remove(this.listOfButtons.get("great"));
			room[x].remove(this.listOfButtons.get("killhim"));
			room[x].remove(this.listOfButtons.get("knockhim"));
			room[x].remove(this.dialogue);
			room[x].remove(this.text);
			room[x].remove(this.dialfinal);
			room[x].remove(this.dialoguefinal);

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
			setVisibilityButton("JohnB", b);
		}

		else if (x == 4)
		{
			setVisibilityButton("Drake", b);
			setVisibilityButton("bottom_button", b);
			setVisibilityButton("bottom_false_button", b);
			try
			{
				setVisibilityButton("PlayerB", b);
				setVisibilityButton("JohnB", b);
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
		if (dialogue == Dialogue.STEVEN_SUCCEED_RIDLLE)
		{
			room[x].add(this.listOfButtons.get("ok"));
		}
		else if (dialogue == Dialogue.JOHN_QUEST_FULLFIL)
		{
			room[x].add(this.listOfButtons.get("great"));
		}
		else
		{
			room[x].add(this.listOfButtons.get("quitbutton"));
		}
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
		if (currentQuestAutomate == QuestAutomate.GUARDFINISH || currentQuestAutomate == QuestAutomate.QUESTSTFINISH)
		{
			switch (buttonName)
			{
				case "PlayerB":
				{
					room[xroom].add(this.listOfButtons.get("JohnB"));
					break;
				}
				case "PlayerT":
				{
					room[xroom].add(this.listOfButtons.get("JohnT"));
					break;
				}
				case "PlayerL":
				{
					room[xroom].add(this.listOfButtons.get("JohnL"));
					break;
				}
				case "PlayerR":
				{
					room[xroom].add(this.listOfButtons.get("JohnR"));
					break;
				}
			}
		}
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
			if (currentQuestAutomate == QuestAutomate.QUESTSTFINISH)
			{
				removeDialogue(3);
				displayDialogue(Dialogue.GUARD_CHOICE);
				room[3].add(this.listOfButtons.get("knockhim"));
				room[3].add(this.listOfButtons.get("killhim"));
				setOffLabelInfirmary();

			}

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
			if (dialogue == Dialogue.JOHN_QUEST_FULLFIL)
			{
				currentQuestAutomate = QuestAutomate.QUESTSTFINISH;
			}
			else if (!(dialogue == Dialogue.JOHN_QUEST_END))
			{
				currentQuestAutomate = QuestAutomate.QUESTST0;
			}
		}
		else if (isJohn(sourceClick))
		{
			setDialogueAndButton(Dialogue.JOHN_QUEST_END, 4, false);
		}
		else if (!(isPlayerOrJohn(sourceClick)))
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
			setDialogueAndButton(dialogue, 0, false);
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
			setOffLabelInfirmary();
		}
		if (sourceRoom == this.room[4])
		{
			removeDialogue(4);
			setVisibilityUnderButton(4, true);
			setVisibilityButton("Bryan", true);
			setVisibilityButton("Garry", true);
		}
	}

	private void endFail(Dialogue dialogue)
	{
		removeDialogue(3);
		actionOnButton(0, 0, true, "Player");
		displayDialogue(dialogue);
		this.game.addPenalty();
		room[0].add(this.listOfButtons.get("quitbutton"));
		setVisibilityUnderButton(0, false);
		currentAutomate = Automate.CELLS_BEGIN;
		currentQuestAutomate = QuestAutomate.NOQUEST;
		room[0].remove(this.listOfButtons.get("JohnR"));
		room[4].add(this.listOfButtons.get("John"));
	}

	private boolean isJohn(JButton sourceClick)
	{
		return (sourceClick == this.listOfButtons.get("JohnB")
				|| sourceClick == this.listOfButtons.get("JohnT")
				|| sourceClick == this.listOfButtons.get("JohnL")
				|| sourceClick == this.listOfButtons.get("JohnR"));
	}

	private boolean isPlayerOrJohn(JButton sourceClick)
	{
		return (isJohn(sourceClick) || sourceClick == this.listOfButtons.get("Player")
				|| sourceClick == this.listOfButtons.get("PlayerT")
				|| sourceClick == this.listOfButtons.get("PlayerB")
				|| sourceClick == this.listOfButtons.get("PlayerL")
				|| sourceClick == this.listOfButtons.get("PlayerR"));
	}

	private void setOffLabelInfirmary()
	{
		room[3].remove(this.listOfInfirmaryButtons.get("bed3"));
		room[3].remove(this.listOfInfirmaryButtons.get("bed4"));
		room[3].remove(this.listOfInfirmaryButtons.get("bed5"));
		room[3].remove(this.listOfInfirmaryButtons.get("trapdoor"));
	}

	private void setOnLabelInfirmary()
	{
		room[3].add(this.listOfInfirmaryButtons.get("bed3"));
		room[3].add(this.listOfInfirmaryButtons.get("bed4"));
		room[3].add(this.listOfInfirmaryButtons.get("bed5"));
		room[3].add(this.listOfInfirmaryButtons.get("trapdoor"));
	}

	private static class ComponentMove extends MouseAdapter
	{

		private boolean				move;
		private int					x1;
		private JComponent			component;
		private int					y1;
		private Container			container;
		private Map<String, JLabel>	map1;

		public ComponentMove(Container container, Map<String, JLabel> map1)
		{
			this.container = container;
			this.map1 = map1;

		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			if (move)
			{
				move = false;
				component.setBorder(null);
				component = null;
			}
			else
			{
				component = getComponent(e.getX(), e.getY());
				if (component != null && (component == this.map1.get("bed1")
						|| component == this.map1.get("bed2")
						|| component == this.map1.get("bed3")
						|| component == this.map1.get("bed4")
						|| component == this.map1.get("bed5")
						|| component == this.map1.get("bed6")
						|| component == this.map1.get("bed7")))

				{
					container.setComponentZOrder(component, 0);

					x1 = e.getX() - component.getX();
					y1 = e.getY() - component.getY();
					move = true;
					component.setBorder(BorderFactory.createLineBorder(Color.BLACK));

				}
			}
		}

		private JComponent getComponent(int x, int y)
		{

			for (Component component : container.getComponents())
			{
				if (component instanceof JComponent && component.getBounds().contains(x, y))
				{
					return (JComponent) component;
				}
			}
			return null;
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{

			if (move)
			{

				component.setLocation(e.getX() - x1, e.getY() - y1);
			}

		}
	}

	public void initRoom3()
	{
		for (Map.Entry<String, JLabel> entry : this.listOfInfirmaryButtons.entrySet())
		{
			room[3].remove(entry.getValue());
		}

		room[3].add(this.listOfButtons.get("Harrison"));

		listOfInfirmaryButtons.remove("bed1");
		listOfInfirmaryButtons.remove("bed2");
		listOfInfirmaryButtons.remove("bed3");
		listOfInfirmaryButtons.remove("bed4");
		listOfInfirmaryButtons.remove("bed5");
		listOfInfirmaryButtons.remove("bed6");
		listOfInfirmaryButtons.remove("bed7");
		listOfInfirmaryButtons.remove("trapdoor");

		this.listOfInfirmaryButtons.put("bed1", new BedLabel(new Bed("bed1", new PositionOnScreen(51, 153))));
		this.listOfInfirmaryButtons.put("bed2", new BedLabel(new Bed("bed2", new PositionOnScreen(51, 303))));
		this.listOfInfirmaryButtons.put("bed3", new BedLabel(new Bed("bed3", new PositionOnScreen(207, 448))));
		this.listOfInfirmaryButtons.put("bed4", new BedLabel(new Bed("bed4", new PositionOnScreen(345, 448))));
		this.listOfInfirmaryButtons.put("bed5", new BedLabel(new Bed("bed5", new PositionOnScreen(643, 448))));
		this.listOfInfirmaryButtons.put("bed6", new BedLabel(new Bed("bed6", new PositionOnScreen(207, 11))));
		this.listOfInfirmaryButtons.put("bed7", new BedLabel(new Bed("bed7", new PositionOnScreen(207, 153))));
		JLabel trapdoor = new JLabel("trapdoor");
		trapdoor.setIcon(new ImageIcon(getClass().getResource("/pictures/trapdoor.png")));
		trapdoor.setBounds(350, 491, 37, 37);
		this.listOfInfirmaryButtons.put("trapdoor", trapdoor);

		trapdoor.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				removeDialogue(3);
				setARoom(6);
			}

		});

		for (Map.Entry<String, JLabel> entry : this.listOfInfirmaryButtons.entrySet())
		{
			room[3].add(entry.getValue());
		}

		setOffLabelInfirmary();
		setOnLabelInfirmary();
	}

	public void initRoom0()
	{
		room[0].add(this.listOfButtons.get("right_button"));
		room[0].add(this.listOfButtons.get("Player"));
		room[0].add(this.listOfButtons.get("Barry"));
		room[0].add(this.listOfButtons.get("Garry"));
		room[0].add(this.listOfButtons.get("Brad"));
		room[0].add(this.listOfButtons.get("Bryan"));
		room[0].add(this.listOfButtons.get("Steven"));
	}

}

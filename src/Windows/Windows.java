package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Windows extends JFrame implements ActionListener
{
	public static Room				room[];
	private Map<String, JButton>	listOfButtons;

	public Windows()
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

		this.setContentPane(room[0]);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object sourceClick = e.getSource();
		Object sourceRoom = this.getContentPane();
		if (sourceRoom == this.room[0])
		{
			setARoom(1);
			removePlayer(1);
			room[1].add(this.listOfButtons.get("PlayerL"));
		}

		else if (sourceRoom == this.room[1])
		{
			if (sourceClick == this.listOfButtons.get("left_button"))
			{
				setARoom(0);
				removePlayer(0);
				room[0].add(this.listOfButtons.get("PlayerR"));
			}
			else if (sourceClick == this.listOfButtons.get("right_button"))
			{
				setARoom(2);
				removePlayer(2);
				room[2].add(this.listOfButtons.get("PlayerL"));
			}
			else
			{
				setARoom(4);
				removePlayer(4);
				room[4].add(this.listOfButtons.get("PlayerT"));
			}
		}

		else if (sourceRoom == this.room[2])
		{
			setARoom(1);
			removePlayer(1);
			room[1].add(this.listOfButtons.get("PlayerR"));
		}

		else if (sourceRoom == this.room[4])
		{
			if (sourceClick == this.listOfButtons.get("top_button"))
			{
				setARoom(1);
				removePlayer(1);
				room[1].add(this.listOfButtons.get("PlayerB"));

			}
			else
			{
				setARoom(3);
				removePlayer(3);
				room[3].add(this.listOfButtons.get("PlayerT"));
			}

		}

		else
		{
			setARoom(4);
			removePlayer(4);
			room[4].add(this.listOfButtons.get("PlayerB"));
		}
	}

	private void initRoom()
	{
		this.room = new Room[]
		{
				new Room("cell"), new Room("corridor"), new Room("outside"), new Room("corridor"), new Room("breakroom")
		};

		for (int i = 0; i < room.length; i++)
			room[i].setLayout(null);

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

	}

	public void initButton()
	{
		/* The move buttons. */
		this.listOfButtons.put("right_button", new GameButtons(745, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_east.png"))));
		this.listOfButtons.put("left_button", new GameButtons(5, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_west.png"))));
		this.listOfButtons.put("bottom_button", new GameButtons(385, 520, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_south.png"))));
		this.listOfButtons.put("top_button", new GameButtons(385, 5, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_north.png"))));

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

		this.listOfButtons.put("PlayerR", new CharacterButtons("PlayerR", 710, 270, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));
		this.listOfButtons.put("PlayerL", new CharacterButtons("PlayerL", 55, 270, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));
		this.listOfButtons.put("PlayerT", new CharacterButtons("PlayerT", 385, 55, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));
		this.listOfButtons.put("PlayerB", new CharacterButtons("PlayerB", 385, 480, 50, 50, new ImageIcon(getClass().getResource("/pictures/player.png"))));

		for (Map.Entry<String, JButton> entry : this.listOfButtons.entrySet())
		{
			entry.getValue().addActionListener(this);
		}

	}

	public void setARoom(int x)
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
		}

		else if (x == 4)
		{
			room[4].add(this.listOfButtons.get("bottom_button"));
			room[4].add(this.listOfButtons.get("top_button"));
		}
	}

	public void removePlayer(int x)
	{
		room[x].remove(this.listOfButtons.get("Player"));
		room[x].remove(this.listOfButtons.get("PlayerR"));
		room[x].remove(this.listOfButtons.get("PlayerL"));
		room[x].remove(this.listOfButtons.get("PlayerB"));
		room[x].remove(this.listOfButtons.get("PlayerT"));

	}
}

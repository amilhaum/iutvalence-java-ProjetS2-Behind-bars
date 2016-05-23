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
		}

		else if (sourceRoom == this.room[1])
		{
			if (sourceClick == this.listOfButtons.get("left_button"))
			{
				setARoom(0);
			}
			else if (sourceClick == this.listOfButtons.get("right_button"))
			{
				setARoom(2);
			}
			else
			{
				setARoom(4);
			}
		}

		else if (sourceRoom == this.room[2])
		{
			setARoom(1);
		}

		else if (sourceRoom == this.room[4])
		{
			if (sourceClick == this.listOfButtons.get("top_button"))
				setARoom(1);
			else
				setARoom(3);
		}

		else
			setARoom(4);
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

	}

	public void initButton()
	{
		this.listOfButtons.put("right_button", new MoveButtons(745, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_east.png"))));
		this.listOfButtons.put("left_button", new MoveButtons(5, 270, 45, 30, new ImageIcon(getClass().getResource("/pictures/arrow_west.png"))));
		this.listOfButtons.put("bottom_button", new MoveButtons(385, 520, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_south.png"))));
		this.listOfButtons.put("top_button", new MoveButtons(385, 5, 30, 45, new ImageIcon(getClass().getResource("/pictures/arrow_north.png"))));

		this.listOfButtons.put("Garry", new CharacterButtons("Garry", 200, 200, 30, 30, new ImageIcon(getClass().getResource("/pictures/prisoner.png"))));

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
}

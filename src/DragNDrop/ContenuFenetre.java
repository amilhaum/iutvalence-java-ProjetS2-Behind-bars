package DragNDrop;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ContenuFenetre extends JPanel
{

	public ContenuFenetre()
	{

		setLayout(null);

		ComponentMove listener = new ComponentMove(this);

		addMouseListener(listener);
		addMouseMotionListener(listener);

	}

	private static class ComponentMove extends MouseAdapter
	{

		private boolean		move;
		private int			x1;
		private JComponent	component;
		private int			y1;
		private Container	container;

		public ComponentMove(Container container)
		{
			this.container = container;
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
				if (component != null && component.getName() != "sewers")
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

}

package calculator;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Graph extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		// Set up a Cartesian coordinate system
	    // get the size of the drawing area		
	    Dimension size = this.getSize();

	    // place the origin at the middle
	    g.translate (size.width / 2, size.height / 2);

	    // draw the x and y axes
	    drawXYAxes (g);
		
	}
	
	private void drawXYAxes (Graphics g) {
	    Dimension size = this.getSize();
	    int xBound = size.width / 2;
	    int yBound = size.height / 2;
	    int tic = size.width / 100;
				
	    // draw the x-axis
	    g.drawLine (-xBound, 0, xBound, 0);

	    // draw the tic marks along the x axis
	    for (int i = -xBound; i <= xBound; i += 10)
	      g.drawLine (i, tic, i, -tic);
				
	    // draw the y-axis
	    g.drawLine (0, yBound, 0, -yBound);	

	    // draw the tic marks along the y axis
	    for (int i = -yBound; i <= yBound; i += 10)
	      g.drawLine (-tic , i, +tic, i);					
	  }
	
}

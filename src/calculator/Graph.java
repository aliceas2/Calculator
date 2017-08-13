package calculator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Graph extends JPanel{
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		 double x1 = 0;
			double y1 = 263;
			double x2 = 222;
			double y2 = 0;
			
			g2.draw(new Line2D.Double(x1, y1, x2, y2));
			
			x1 = 222;
			y1 = 0;
			x2 = 445;
			y2 = 263;
			
			g2.draw(new Line2D.Double(x1, y1, x2, y2));
		
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

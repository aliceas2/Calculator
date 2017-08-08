package calculator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Area {
	
	private Double radius, diameter, circumference, area, sideA, sideB, diagonal, perimeter, base, height;
	final double pi = Math.PI;
	JPanel panel;
	
	public Area(JPanel panel) {
		this.panel = panel;
	}
	
	public Double[] calculateCircle(Double[] cData) {
		radius = cData[0];
		diameter = cData[1];
		circumference = cData[2];
		area = cData[3];
		
		if(radius > 0) {
			diameter = 2 * radius;
			circumference = pi * diameter;
			area = pi * Math.pow(radius, 2);
		} else if(diameter > 0) {
			radius = diameter/2;
			circumference = pi * diameter;
			area = pi * Math.pow(radius, 2);
		} else if(circumference > 0) {
			radius = circumference/(2 * pi);
			diameter = 2 * radius;
			area = pi * Math.pow(radius, 2);
		} else if(area > 0) {
			double temp = area/pi;
			radius = Math.sqrt(temp);
			diameter = 2 * radius;
			circumference = pi * diameter;
		} else {
			JOptionPane.showMessageDialog(panel, "At least 1 value of a circle must be known to calculate the other 3");
		}
		
		cData[0] = radius;
		cData[1] = diameter;
		cData[2] = circumference;
		cData[3] = area;
		
		return cData;	
	}
	
	public Double[] calculateRectangle(Double[] rData) {
		sideA = rData[0];
		sideB = rData[1];
		diagonal = rData[2];
		perimeter = rData[3];
		area = rData[4];
		
		if(sideA > 0 && sideB > 0) {
			diagonal = Math.sqrt((Math.pow(sideA, 2)) + (Math.pow(sideB, 2)));
			perimeter = 2 * (sideA + sideB);
			area = sideA * sideB;
		} else if(sideA > 0 && perimeter > 0) {
			sideB = (perimeter/2) - sideA;
			diagonal = Math.sqrt((Math.pow(sideA, 2)) + (Math.pow(sideB, 2)));
			area = sideA * sideB;
		} else if(sideB > 0 && perimeter > 0) {
			sideA = (perimeter/2) - sideB;
			diagonal = Math.sqrt((Math.pow(sideA, 2)) + (Math.pow(sideB, 2)));
			area = sideA * sideB;
		} else if(sideA > 0 && diagonal > 0) {
			sideB = Math.sqrt((Math.pow(diagonal, 2)) - (Math.pow(sideA, 2)));
			perimeter = 2 * (sideA + sideB);
			area = sideA * Math.sqrt((Math.pow(diagonal, 2)) - (Math.pow(sideA, 2)));
		} else if(sideB > 0 && diagonal > 0) {
			sideA = Math.sqrt((Math.pow(diagonal, 2)) - (Math.pow(sideB, 2)));
			perimeter = 2 * (sideA + sideB);
			area = sideB * Math.sqrt((Math.pow(diagonal, 2)) - (Math.pow(sideB, 2)));
		} else if(sideA > 0 && area > 0) {
			sideB = area/sideA;
			diagonal = Math.sqrt((Math.pow(sideA, 2)) + (Math.pow(sideB, 2)));
			perimeter = (2 * sideA) + (2 * sideB);
		} else if(sideB > 0 && area > 0) {
			sideA = area/sideB;
			diagonal = Math.sqrt((Math.pow(sideA, 2)) + (Math.pow(sideB, 2)));
			perimeter = (2 * sideA) + (2 * sideB);
		} else {
			JOptionPane.showMessageDialog(panel, "At least 2 values of a rectangle (Not Area & Perimeter) \n must be known to calculate the other 3");
		}
		
		rData[0] = sideA;
		rData[1] = sideB;
		rData[2] = diagonal;
		rData[3] = perimeter;
		rData[4] = area;
		
		return rData;	
	}
	
	public Double[] calculateTriangle(Double[] tData) {
		base = tData[0];
		height = tData[1];
		area = tData[2];
		
		if(base > 0 && height > 0) {
			area = 0.5 * (base * height);
		} else if(height > 0 && area > 0) {
			base = 2 * (area/height);
		} else if(base > 0 && area > 0) {
			height = 2 * (area/base);
		} else {
			JOptionPane.showMessageDialog(panel, "At least 2 values of a triangle must be known to calculate the 3rd");
		}
		
		tData[0] = base;
		tData[1] = height;
		tData[2] = area;
		
		return tData;
	}
}

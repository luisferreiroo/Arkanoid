package codigo;

import java.awt.Color;

import acm.graphics.GRect;

public class Ladrillo extends GRect{
	
	int n�_golpes = 0;
	
	public Ladrillo (double x, double y, double width, double height, Color c){
		super(x, y, width, height);
		setFillColor(c);
		setFilled(true);
	}

}

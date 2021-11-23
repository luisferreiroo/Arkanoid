package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval {
	int dx = 1; //velocidad en el eje x
	int dy = 1; //velocidad en el eje y

	public Bola(double width, double height) {
		super(width, height);

	}

	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}


	public  void muevete(Arkanoid ark){
		//rebote con el suelo y rebote con el techo
		if (getY() > ark.getHeight() || (getY() < 0)){
			dy = dy * -1;		

		}
		//rebote con la pared de la derecha y rebote con la izquierda
		if (getX() > ark.getWidth() ||  (getX() < 0)){
			dx = dx * -1;
		}
		//chequeo la esquina superior izquierda de la bola
		if (chequeaColision(getX(), getY(), ark)){
			if (chequeaColision(getX() + getWidth(), getY(), ark)){
				if (chequeaColision(getX(), getY() + getHeight(), ark)){
					if (chequeaColision(getX() + getWidth(), getY() + getHeight(), ark)){
					}
				}
			}
		}

		//mueve la bola en la dirección correcta
		move(dx,dy);
	}

	private boolean chequeaColision (double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;

		auxiliar = ark.getElementAt(posx, posy); //si entra aquí, es que choca con el cursor 

		if (auxiliar == ark.miCursor){
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){ //si vale null, es que no había nada de ahí

		}else { //suponemos que es un ladrillo
			ark.remove(auxiliar);
			dy = dy * -1;
			dx = dx * -1;
			noHaChocado = false;
		}
		return noHaChocado;
	}
}

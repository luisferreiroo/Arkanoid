package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram{
	
	 static final int ANCHO_LADRILLO = 35;
	    static final int ALTO_LADRILLO = 15;
	Bola bola1 = new Bola(10, 10, Color.black);
	Cursor miCursor = new Cursor (0, 400, 60, 10, Color.YELLOW);
	
	public void init(){
		addMouseListeners();
		add(bola1);
		add(miCursor);
	}
	
	public void run(){
		creaPiramide();
		while(true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando a
			pause(5);
		}
	}
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(getWidth(), evento.getX());
	}
	private void creaPiramide(){
    	int numeroLadrillos=14;
    	for(int j=0;j<numeroLadrillos;j++){
    		for(int i=j;i<numeroLadrillos;i++){
    			Ladrillo miLadrillo = new Ladrillo(
    					ANCHO_LADRILLO*i-ANCHO_LADRILLO/2*j, //pos x
    					ALTO_LADRILLO*j, //posy
    					ANCHO_LADRILLO,  //ancho
    					ALTO_LADRILLO, //ALTO    					
                        Color.RED);
    			add(miLadrillo);
    		}
    	}
    }
}
	


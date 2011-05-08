package tap.practica.interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Inicio {
	
	
	public static void main(String[] args) {
		try {
		    //// Creamos JFrame con estilo y operación de cierre
		    MatricularMarco frame = new MatricularMarco();
		    javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
		    frame.setDefaultCloseOperation( javax.swing.JFrame.HIDE_ON_CLOSE);

		    //// Centra la ventana principal
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    Dimension frameSize = new Dimension( screenSize.width/2, screenSize.height/2 );
		    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		    frame.setSize(frameSize.width, frameSize.height);

//		    frame.pack();	// Su tamaño se ciñe a  preferred size y al tamaño de subcomponentes

		    frame.setVisible(true);
		    
		     
		}
		catch(Exception e) {
		    e.printStackTrace();
	    }
	}
}

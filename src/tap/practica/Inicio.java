package tap.practica;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import tap.practica.estructuras.Alumno;
import tap.practica.interfaz.MatricularMarco;

public class Inicio {
	
	//Alumno cargado actualmente
	public static Alumno alumno;
	//La factoría de donde sacamos los alumnos y demás
	private static final XmlBeanFactory factory = new XmlBeanFactory(
			new ClassPathResource("tap/practica/objetos.xml"));
	
	public static void main(String[] args) {		
		
		try {
			alumno = (Alumno) factory.getBean("q1234");
			alumno.print();
			
		    //// Creamos JFrame con estilo y operación de cierre
		    MatricularMarco frame = new MatricularMarco();
		    javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
		    frame.setDefaultCloseOperation( javax.swing.JFrame.HIDE_ON_CLOSE);

		    //// Centra la ventana principal
		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    Dimension frameSize = new Dimension( screenSize.width/2, screenSize.height/2 );
		    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		    frame.setSize(frameSize.width, frameSize.height);
		    
		    frame.setVisible(true);
		    
		}
		catch(Exception e) {
		    e.printStackTrace();
	    }
	}

	/**
	 * @return the alumno
	 */
	public static Alumno getAlumno() {
		return alumno;
	}
	
	public static boolean cargarAlumno(String nif) {
		try {
			alumno = (Alumno) factory.getBean(nif);
			System.out.println("Cargando alumno con nif" +  nif);
			return true;
		} catch (BeansException e) {
			System.out.println("Pues no existe");
			return false;
		}
	}
}
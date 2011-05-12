package tap.practica.cliente;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.WindowConstants;

import org.springframework.beans.BeansException;

import tap.practica.estructuras.Alumno;
import tap.practica.interfaz.MatricularMarco;
import tap.practica.servidor.FactoryIfaz;

public class Inicio {

	public static Alumno alumno;
	public static FactoryIfaz fac;

	// La factoría de donde sacamos los alumnos y demás

	public static boolean cargarAlumno(String nif) throws RemoteException {
		try {
			alumno = fac.getAlumno(nif);
			System.out.println("Cargando alumno con nif" + nif);
			return true;
		} catch (BeansException e) {
			System.out.println("Pues no existe");
			return false;
		}
	}

	public static Alumno getAlumno() {
		return alumno;
	}

	public static void main(String[] args) {
		String url = "rmi://localhost/";
		try {
			fac = (FactoryIfaz) Naming.lookup(url + "alumnos");
			MatricularMarco frame = new MatricularMarco();
			javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
			frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

			// // Centra la ventana principal
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = new Dimension(screenSize.width / 2,
					screenSize.height / 2);
			frame.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);
			frame.setSize(frameSize.width, frameSize.height);

			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

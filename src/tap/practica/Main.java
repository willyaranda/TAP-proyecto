package tap.practica;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import tap.practica.interfaz.*;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		XmlBeanFactory factory = new XmlBeanFactory(
				new ClassPathResource("tap/practica/objetos.xml"));
		
		Alumno facAlumno = (Alumno) factory.getBean("Alumno1");
		facAlumno.print();
		
		//BuscarUsuarioNif panel = new BuscarUsuarioNif();
		//panel.setVisible(true);
		
	}
}

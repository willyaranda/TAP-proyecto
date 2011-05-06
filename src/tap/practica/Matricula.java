package tap.practica;

import java.util.ArrayList;

/**
 * Clase Matrícula, tiene un atributo matriculadas que guarda un array
 * de las asignaturas matriculadas.
 * Y un atributo entero que guarda el número de créditos matriculados
 * @author willyaranda
 * @author aldo
 */
public class Matricula {
	
	ArrayList<Asignatura> matriculadas = new ArrayList<Asignatura>();
	int numCreditos;
	
	/**
	 * Añade una Asignatura a la lista de matriculadas.<br />
	 * Comprueba si se puede añadir a la lista de matriculación. No nos 
	 * podemos pasar de 60 créditos matriculados, y en ese caso devuelve <b>false</b>
	 * En cualquier otro caso, devuelve <b>true</b>
	 * @param asig la Asignatura
	 * @return si la operación ha sido completada correctamente
	 */
	public Boolean matricular(Asignatura asig) {
		if ((numCreditos + asig.getCreditos()) > 60) return false;
		matriculadas.add(asig);
		numCreditos += asig.getCreditos();
		return true;
	}
	
	/**
	 * Comprueba si la matrícula es correcta. Si es menor de 12 o mayor de 60
	 * el número de créditos matriculados, se devuelve <b>false</b> y en
	 * otro caso se devuelve <b>true</b>
	 * @return si la matrícula es correcta
	 */
	public Boolean comprobar() {
		return ((numCreditos > 60) || (numCreditos < 12)) ? false : true;
	}

}
